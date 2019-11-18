package me.crw.framework.helper;

import me.crw.framework.annotation.Inject;
import me.crw.framework.utils.ArrayUtil;
import me.crw.framework.utils.CollectionUtil;
import me.crw.framework.utils.RelfectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * ClassName: IocHelper
 * Description: 依赖注入帮助类
 * date: 2019/11/18 20:03
 *
 * @author crwen
 * @create 2019-11-18-20:03
 * @since JDK 1.8
 */
public final class IocHelper {

	static {
		// 获取所有 Bean 类与 Bean 实例之间的映射关系
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if (CollectionUtil.isNotEmpty(beanMap)) {
			// 遍历 Bean Map
			for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
				// 从 BeanMap 中获取 Bean 类与 Bean 实例
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				// 获取 Bean 类定义的所有成员变量
				Field[] beanFileds = beanClass.getDeclaredFields();
				if (ArrayUtil.isNotEmpty(beanFileds)) {
					// 遍历 Bean Field
					for (Field beanField : beanFileds) {
						// 判断当前 Bean Field 是否带有 Inject 注解
						if (beanField.isAnnotationPresent(Inject.class)) {
							// 在 Bean Map 中获取 Bean Field 对应的实例
							Class<?> beanFieldClass = beanField.getType();// 获取对象类型
							Object beanFieldInstance = beanMap.get(beanFieldClass); // 对过对象类型获取成员变量实例对象
							if (beanFieldInstance != null) {
								// 通过反射初始化 BeanField 的值   public static void setField(Object obj, Field field, Object value)
								RelfectionUtil.setField(beanInstance, beanField, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}

}
