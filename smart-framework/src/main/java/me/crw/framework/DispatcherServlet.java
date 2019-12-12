package me.crw.framework;

import me.crw.framework.bean.Data;
import me.crw.framework.bean.Handler;
import me.crw.framework.bean.Param;
import me.crw.framework.bean.View;
import me.crw.framework.helper.BeanHelper;
import me.crw.framework.helper.ConfigHelper;
import me.crw.framework.helper.ControllerHelper;
import me.crw.framework.utils.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: DispatcherServlet
 * Description 请求转发器:
 * date: 2019/11/20 21:34
 *
 * @author crwen
 * @create 2019-11-20-21:34
 * @since JDK 1.8
 */
@WebServlet(urlPatterns = "/*", loadOnStartup = 0)
public class DispatcherServlet extends HttpServlet {

	@Override
	public void init(ServletConfig servletConfig) throws ServletException {
		// 初始化相关 Helper 类
		HelperLoader.init();
		// 获取 ServletConfig 对象（用于注册 Servlet）
		ServletContext servletContext = servletConfig.getServletContext();
		// 处理注册 JSP 的 Servlet
		ServletRegistration jspServlet = servletContext.getServletRegistration("jsp");
		jspServlet.addMapping(ConfigHelper.getAppJspPath() + "*");
		// 注册处理静态资源的默认 Servlet
		ServletRegistration defaultServlet = servletContext.getServletRegistration("default");
		defaultServlet.addMapping(ConfigHelper.getAppAssetPath() + "*");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
		// 获取请求方法与请求路径
		String requestMethod = request.getMethod().toLowerCase();
		String requestPath = request.getPathInfo();
		// 获取 Action 处理器
		Handler handler = ControllerHelper.getHandler(requestMethod, requestPath);
		if (handler != null) {
			// 获取 Controller 类及其 Bean 示例
			Class<?> controllerClass = handler.getControllerClass();
			Object controllerBean = BeanHelper.getBean(controllerClass);
			// 创建请求参数
			Map<String, Object> paramMap = new HashMap<String, Object>();
			Enumeration<String> paramNames = request.getParameterNames();
			while (paramNames.hasMoreElements()) {
				String paramName = paramNames.nextElement();
				String paramValue = request.getParameter(paramName);
				paramMap.put(paramName, paramValue);
			}
			String body = CodecUtil.decodeURL(StreamUtil.getString(request.getInputStream()));
			if (StringUtil.isNotEmpty(body)) {
				String[] params = StringUtil.splitString(body, "&");
				if (ArrayUtil.isNotEmpty(params)) {
					for (String param : params) {
						String[] array = StringUtil.splitString(param, "=");
						if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
							String paramName = array[0];
							String paramValue = array[1];
							paramMap.put(paramName, paramValue);
						}
					}
				}
			}
			Param param = new Param(paramMap);
			// 调用 Action 方法
			Method actionMethod = handler.getActionMethod();
			Object result = RelfectionUtil.invokeMethod(controllerBean, actionMethod, param);
			// 处理 Action 方法返回值
			if (result instanceof View) {
				// 返回JSP页面
				View view = (View) result;
				String path = view.getPath();
				if (StringUtil.isNotEmpty(path)) {
					if (path.startsWith("/")) {
						resp.sendRedirect(request.getContextPath() + path);
					} else {
						Map<String, Object> model = view.getModel();
						for (Map.Entry<String, Object> entry : model.entrySet()) {
							request.setAttribute(entry.getKey(), entry.getValue());
						}
						request.getRequestDispatcher(ConfigHelper.getAppJspPath() + path).forward(request, resp);
					}
				} else if (result instanceof Data) {
					// 返回 JSON 数据
					Data data = (Data) result;
					Object model = data.getModel();
					if (model != null) {
						resp.setContentType("application/json");
						resp.setCharacterEncoding("UTF-8");
						PrintWriter writer = resp.getWriter();
						String json = JsonUtil.toJson(model);
						writer.write(json);
						writer.flush();
						writer.close();
					}
				}
			}
		}
	}
}
