package me.crw.framework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * ClassName: Service
 * Description: 服务类注解
 * date: 2019/11/17 19:27
 *
 * @author crwen
 * @create 2019-11-17-19:27
 * @since JDK 1.8
 */

@Target(ElementType.TYPE) // 描述类、接口或enum声明
@Retention(RetentionPolicy.RUNTIME)
public @interface Service {

}
