package me.crw.framework;

import me.crw.framework.helper.BeanHelper;
import me.crw.framework.helper.ClassHelper;
import me.crw.framework.helper.ConfigHelper;
import me.crw.framework.helper.IocHelper;
import me.crw.framework.utils.ClassUtil;

/**
 * ClassName: HelperLoader
 * Description: 加载相应的 Helper 类
 * date: 2019/11/20 20:31
 *
 * @author crwen
 * @create 2019-11-20-20:31
 * @since JDK 1.8
 */
public final class HelperLoader {

	public static void init() {
		Class<?>[] classList = {ClassHelper.class, BeanHelper.class, IocHelper.class, ConfigHelper.class};
		for (Class<?> cls : classList) {
			ClassUtil.loadClass(cls.getName());
		}
	}
}
