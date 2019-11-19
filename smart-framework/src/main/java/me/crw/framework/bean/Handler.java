package me.crw.framework.bean;

import java.lang.reflect.Method;

/**
 * ClassName: Handler
 * Description: 封装 Action 信息
 * date: 2019/11/19 12:30
 *
 * @author crwen
 * @create 2019-11-19-12:30
 * @since JDK 1.8
 */
public class Handler {

	/**
	 *  Controller 对象
	 */
	private Class<?> controllerClass;

	/**
	 *  Action 方法，形如：@Action("get:/customer)
	 */
	private Method actionMethod;

	public Handler(Class<?> controllerClass, Method actionMethod) {
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}

	public Class<?> getControllerClass() {
		return controllerClass;
	}

	public Method getActionMethod() {
		return actionMethod;
	}
}
