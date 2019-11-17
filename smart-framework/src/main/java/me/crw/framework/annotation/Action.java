package me.crw.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Action
 * Description: Action 方法注解
 * date: 2019/11/17 19:26
 *
 * @author crwen
 * @create 2019-11-17-19:26
 * @since JDK 1.8
 */

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Action {

	/**
	 *  请求类型与路径
	 */
	String value();
}
