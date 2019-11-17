package me.crw.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Inject
 * Description: 依赖注入注解
 * date: 2019/11/17 19:28
 *
 * @author crwen
 * @create 2019-11-17-19:28
 * @since JDK 1.8
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

}
