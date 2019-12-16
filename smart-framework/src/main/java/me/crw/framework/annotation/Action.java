package me.crw.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Action
 * Description: Action 方法注解，如@Action("get:/customer")
 * date: 2019/11/17 19:26
 *
 * @author crwen
 * @create 2019-11-17-19:26
 * @since JDK 1.8
 */

@Target(ElementType.METHOD) // 修饰范围：方法
@Retention(RetentionPolicy.RUNTIME) // 限制生命周期：运行时有效
public @interface Action {

	/**
	 *  请求类型与路径
	 */
	String value();
}
