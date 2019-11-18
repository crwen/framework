package me.crw.framework.utils;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.Collection;
import java.util.Map;

/**
 * ClassName: CollectionUtil
 * Description: 集合工具类
 * date: 2019/11/18 20:05
 *
 * @author crwen
 * @create 2019-11-18-20:05
 * @since JDK 1.8
 */
public final class CollectionUtil {

	public static boolean isEmpty(Collection<?> coll) {
		return CollectionUtils.isEmpty(coll);
	}

	public static boolean isNotEmpty(Collection<?> coll) {
		return CollectionUtils.isNotEmpty(coll);
	}

	public static boolean isEmpty(Map<?, ?> map) {
		return MapUtils.isEmpty(map);
	}

	public static boolean isNotEmpty(Map<?, ?> map) {
		return MapUtils.isNotEmpty(map);
	}
}
