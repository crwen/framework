package me.crw.framework.utils;

/**
 * ClassName: StringUtils
 * Description: 字符工具类
 * date: 2019/10/20 21:23
 *
 * @author crwen
 * @create 2019-10-20-21:23
 * @since JDK 1.8
 */
public final class StringUtil {

	public static boolean isEmpty(String str) {
		if (str != null) {
			str = str.trim();
		}
		return StringUtil.isEmpty(str);
	}

	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	public static String[] splitString(String src, String div) {
		return src.split(div);
	}
}
