package me.crw.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * ClassName: CollectionUtil
 * Description: 集合工具类
 * date: 2019/10/20 21:32
 *
 * @author crwen
 * @create 2019-10-20-21:32
 * @since JDK 1.8
 */
public final class CollectionUtil {

	/**
	 * 判读collection是否为空
	 * @param collection
	 * @return
	 */
	public static boolean isEmpty(Collection<?> collection) {
		return CollectionUtils.isEmpty(collection);
	}

	/**
	 * 判断Collection是否非空
	 * @param collection
	 * @return
	 */
	public static boolean isNotEmpty(Collection<?> collection) {
		return !isEmpty(collection);
	}

	/**
	 * 判断map是否为空
	 * @param map
	 * @return
	 */
	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}

	/**
	 * 判断map是否非空
	 * @param map
	 * @return
	 */
	public static boolean isNotEmpty(Map<?, ?> map) {
		return ! isEmpty(map);
	}
}
