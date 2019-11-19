package me.crw.framework.helper;

import me.crw.framework.annotation.Action;
import me.crw.framework.bean.Handler;
import me.crw.framework.bean.Request;
import me.crw.framework.utils.ArrayUtil;
import me.crw.framework.utils.CollectionUtil;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: ControllerHelper
 * Description: 控制器帮助类
 * date: 2019/11/19 12:34
 *
 * @author crwen
 * @create 2019-11-19-12:34
 * @since JDK 1.8
 */
public final class ControllerHelper {

	/**
	 *  用于存放请求与处理器的映射关系
	 */
	private static final Map<Request, Handler> ACTION_MAP = new HashMap<Request, Handler>();

	static {
		// 获取所有 Controller 类
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if (CollectionUtil.isNotEmpty(controllerClassSet)) {
			for (Class<?> controllerClass : controllerClassSet) {
				Method[] methods = controllerClass.getDeclaredMethods();
				if (ArrayUtil.isNotEmpty(methods)) {
					for (Method method : methods) {
						// 判断当前方法是否带有 Action 注解
						if (method.isAnnotationPresent(Action.class)) {
							// 从Action 中获取 URL 映射规则
							Action action = method.getAnnotation(Action.class);
							String mapping = action.value();
							//验证 URL 映射规则
							if (mapping.matches("\\w+:/\\w*")) {
								String[] array = mapping.split(":");
								if (ArrayUtil.isNotEmpty(array) && array.length == 2) {
									String requestMethod = array[0];
									String requestPath = array[1];
									Request request = new Request(requestMethod, requestPath);
									Handler handler = new Handler(controllerClass, method);
									// 初始化 Action Map
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}

			}
		}
	}

	/**
	 *  获取 Handler
	 * @param requestMethod
	 * @param requestPath
	 * @return
	 */
	public static Handler getHandler(String requestMethod, String requestPath) {
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}
