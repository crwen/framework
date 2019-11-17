package me.crw.framework.helper;

import me.crw.framework.annotation.Controller;
import me.crw.framework.annotation.Service;
import me.crw.framework.utils.ClassUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * ClassName: ClassHelper
 * Description: 类操作助手类
 * date: 2019/11/17 19:39
 *
 * @author crwen
 * @create 2019-11-17-19:39
 * @since JDK 1.8
 */
public final class ClassHelper {

	/**
	 *  定义类集合（用于存放所加载的类）
	 */
	private static final Set<Class<?>> CLASS_SET;

	static {
		String basePackage = ConfigHelper.getAppBasePackage();
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}

	/**
	 * 获取应用包名下的所有类
	 * @return
	 */
	public static Set<Class<?>> getClassSet() {
		return CLASS_SET;
	}

	/**
	 *  获取应用包名下所有 Service 类
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Service.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 *  获取应用包名下所有 Controller 类
	 * @return
	 */
	public static Set<Class<?>> getControllerClassSet() {
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for (Class<?> cls : CLASS_SET) {
			if (cls.isAnnotationPresent(Controller.class)) {
				classSet.add(cls);
			}
		}
		return classSet;
	}

	/**
	 *  获取应用包名下所有 Bean 类 （包括：Service、Controller 等）
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet() {
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
}
