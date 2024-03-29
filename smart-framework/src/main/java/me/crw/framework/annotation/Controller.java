package me.crw.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Controller
 * Description: 控制器注解
 * date: 2019/11/17 19:24
 *
 * @author crwen
 * @create 2019-11-17-19:24
 * @since JDK 1.8
 */

@Target(ElementType.TYPE) // 描述类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME) // 运行时有效
public @interface Controller {

}
