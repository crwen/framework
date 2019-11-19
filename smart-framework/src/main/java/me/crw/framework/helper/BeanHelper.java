package me.crw.framework.helper;

import me.crw.framework.utils.RelfectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * ClassName: BeanHelper
 * Description: Bean 助手类
 * date: 2019/11/18 19:22
 *
 * @author crwen
 * @create 2019-11-18-19:22
 * @since JDK 1.8
 */
public final class BeanHelper {

	/**
	 *  定义 Bean 映射（用于存放Bean 类与 Bean 实例的映射关系）
	 */
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();

	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> beanClass : beanClassSet) {
			Object obj = RelfectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}

	/**
	 *  获取 Bean 映射
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}

	/**
	 *  获取 Bean 实例
	 * @param cls
	 * @param <T>
	 * @return
	 */
	public static <T>T getBean(Class<T> cls) {
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean by class: " + cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
}
