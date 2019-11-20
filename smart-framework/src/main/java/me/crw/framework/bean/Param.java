package me.crw.framework.bean;

import me.crw.framework.utils.CastUtil;

import java.util.Map;

/**
 * ClassName: Param
 * Description: 请求参数对象
 * date: 2019/11/20 20:52
 *
 * @author crwen
 * @create 2019-11-20-20:52
 * @since JDK 1.8
 */
public class Param {

	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}

	/**
	 *  根据参数名获取 long 型参数
	 * @param name
	 * @return
	 */
	public long getLong(String name) {
		return CastUtil.castLong(name);
	}

	/**
	 *  获取所有字段信息
	 * @return
	 */
	public Map<String, Object> getMap() {
		return paramMap;
	}
}
