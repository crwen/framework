package me.crw.framework.utils;

import org.apache.commons.lang3.ArrayUtils;

/**
 * ClassName: ArrayUtils
 * Description: 数组工具类
 * date: 2019/11/18 19:30
 *
 * @author crwen
 * @create 2019-11-18-19:30
 * @since JDK 1.8
 */
public final class ArrayUtil{

	/**
	 *  判断数组是否非空
	 * @param array
	 * @return
	 */
	public static boolean isNotEmpty( Object[] array) {
		return !ArrayUtils.isEmpty(array);
	}

	/**
	 *  判断数组是否为空
	 * @param array
	 * @return
	 */
	private static boolean isEmpty(Object[] array) {
		return ArrayUtils.isEmpty(array);
	}
}
