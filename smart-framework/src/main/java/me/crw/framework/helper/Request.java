package me.crw.framework.helper;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * ClassName: Request
 * Description: 封装请求信息
 * date: 2019/11/19 12:23
 *
 * @author crwen
 * @create 2019-11-19-12:23
 * @since JDK 1.8
 */
public class Request {

	/**
	 *  请求方法
	 */
	private String requestMethod;

	/**
	 *  请求路径
	 */
	private String requestPath;

	public Request(String requestMethod, String requestPath) {
		this.requestMethod = requestMethod;
		this.requestPath = requestPath;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public String getRequestPath() {
		return requestPath;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this);
	}
}
