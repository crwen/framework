package me.crw.utils;

/**
 * ClassName: StringUtils
 * Description: 字符工具类
 * date: 2019/10/20 21:23
 *
 * @author crwen
 * @create 2019-10-20-21:23
 * @since JDK 1.8
 */
public final class StringUtils {

	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtils.isEmpty(str);
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
}
