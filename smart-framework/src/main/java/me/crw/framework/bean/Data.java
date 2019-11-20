package me.crw.framework.bean;

/**
 * ClassName: Data
 * Description: 返回数据对象
 * date: 2019/11/20 21:11
 *
 * @author crwen
 * @create 2019-11-20-21:11
 * @since JDK 1.8
 */
public class Data {

	/**
	 *  模型数据
	 */
	private Object model;

	public Data(Object model) {
		this.model = model;
	}

	public Object getModel() {
		return this.model;
	}

}
