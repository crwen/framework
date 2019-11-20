package me.crw.framework;

import me.crw.framework.helper.ConfigHelper;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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
}
