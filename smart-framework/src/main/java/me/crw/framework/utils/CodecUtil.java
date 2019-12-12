package me.crw.framework.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * ClassName: CodecUtil
 * Description: 编码与解码工具类
 * date: 2019/12/12 21:38
 *
 * @author crwen
 * @create 2019-12-12-21:38
 * @since JDK 1.8
 */
public final class CodecUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(CodecUtil.class);

	/**
	 *  将 URL 编码
	 * @param source
	 * @return
	 */
	public static String encodeURL(String source) {
		String target;
		try {
			target = URLEncoder.encode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("encode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}

	public static String decodeURL(String source) {
		String target;
		try {
			target = URLDecoder.decode(source, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("decode url failure", e);
			throw new RuntimeException(e);
		}
		return target;
	}
}
