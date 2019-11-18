package me.crw.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ClassName: RelfectionUtil
 * Description: 反射工具类
 * date: 2019/11/18 19:14
 *
 * @author crwen
 * @create 2019-11-18-19:14
 * @since JDK 1.8
 */
public class RelfectionUtil {

	private static final Logger LOGGER = LoggerFactory.getLogger(RelfectionUtil.class);

	/**
	 *  创建实例
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls) {
		Object instance;
		try {
			instance = cls.newInstance();
		} catch (Exception e) {
			LOGGER.error("new instance failure", e);
			throw new RuntimeException(e);
		}
		return instance;
	}

	/**
	 *  第哦啊用方法
	 * @param obj
	 * @param method
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object obj, Method method, Object ... args) {
		Object result;
		try {
			method.setAccessible(true);
			result = method.invoke(obj, args);
		} catch (Exception e) {
			LOGGER.error("invoke method failure", e);
			throw new RuntimeException(e);
		}
		return result;
	}

	/**
	 *  设置成员变量
	 * @param obj
	 * @param field
	 * @param value
	 */
	public static void setField(Object obj, Field field, Object value) {
		try {
			field.setAccessible(true);
			field.set(obj, value);
		} catch (IllegalAccessException e) {
			LOGGER.error("set field failure", e);
			throw new RuntimeException(e);
		}
	}
}
