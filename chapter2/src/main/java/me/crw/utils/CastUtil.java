package me.crw.utils;

/**
 * ClassName: CastUtil
 * Description: 数据类型转换工具类
 * date: 2019/10/20 21:02
 *
 * @author crwen
 * @create 2019-10-20-21:02
 * @since JDK 1.8
 */
public final class CastUtil {

	/**
	 * 转换为String 类型
	 * @param obj
	 * @return
	 */
	public static String castString(Object obj) {
		return CastUtil.castString(obj , "");
	}

	/**
	 * 转为String型 （提供默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static String castString(Object obj, String defaultValue) {
		return obj != null ? String.valueOf(obj) : defaultValue;
	}

	/**
	 * 转为double型
	 * @param obj
	 * @return
	 */
	public static double castDouble(Object obj) {
		return castDouble(obj, 0.0);
	}

	/**
	 * 转为double型（提供默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static double castDouble(Object obj, double defaultValue) {
		double doubleValue = defaultValue;
		if (obj != null) {
			String strValue = castString((obj));
			if (StringUtils.isNotEmpty(strValue)) {
				try {
					doubleValue = Double.parseDouble(strValue);
				} catch (NumberFormatException e) {
					doubleValue = defaultValue;
				}
			}
		}
		return  doubleValue;
	}

	/**
	 * 转为long型
	 * @param obj
	 * @return
	 */
	public static long castLong(Object obj) {
		return castLong(obj, 0L);
	}

	/**
	 * 转为long型（提供默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static long castLong(Object obj, long defaultValue) {
		long longValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			try {
				longValue = Long.parseLong(strValue);
			} catch (NumberFormatException e) {
				longValue = defaultValue;
			}
		}
		return longValue;
	}

	/**
	 * 转为int型
	 * @param obj
	 * @return
	 */
	public static int castInt(Object obj) {
		return castInt(obj, 0);
	}

	/**
	 * 转为int型（提供默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static int castInt(Object obj, int defaultValue) {
		int intValue = defaultValue;
		if (obj != null) {
			String strValue = castString(obj);
			try {
				intValue = Integer.parseInt(strValue);
			} catch (NumberFormatException e) {
				intValue = defaultValue;
			}
		}
		return intValue;
	}

	/**
	 * 转为Boolean类型
	 * @param obj
	 * @return
	 */
	public static boolean castBoolean(Object obj) {
		return castBoolean(obj, false);
	}

	/**
	 * 转为boolean型（提供默认值）
	 * @param obj
	 * @param defaultValue
	 * @return
	 */
	public static boolean castBoolean(Object obj, boolean defaultValue) {
		boolean booleanValue = defaultValue;
		if (obj != null) {
			booleanValue = Boolean.parseBoolean(castString(obj));
		}
		return booleanValue;
	}
}
