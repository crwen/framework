package me.crw.framework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: View
 * Description: 返回视图对象
 * date: 2019/11/20 21:00
 *
 * @author crwen
 * @create 2019-11-20-21:00
 * @since JDK 1.8
 */
public class View {

	/**
	 *  视图路径
	 */
	private String path;

	/**
	 *  模型数据
	 */
	private Map<String, Object> model;

	public View(String path) {
		this.path = path;
		model = new HashMap<String, Object>();
	}

	public String getPath() {
		return this.path;
	}

	public Map<String, Object> getModel() {
		return this.model;
	}
}
