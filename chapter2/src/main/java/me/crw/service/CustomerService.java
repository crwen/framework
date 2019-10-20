package me.crw.service;

import me.crw.model.Customer;

import java.util.List;
import java.util.Map;

/**
 * ClassName: CustomerService
 * Description: 服务处
 *                  提供数据服务
 * date: 2019/10/20 13:38
 *
 * @author crwen
 * @create 2019-10-20-13:38
 * @since JDK 1.8
 */
public class CustomerService {

	/**
	 * 根据关键词获取客户列表
	 * @param keyword
	 * @return
	 */
	public List<Customer> getCustomerList(String keyword) {
		//TODO
		return null;
	}

	/**
	 * 根据id获取客户
	 * @param id
	 * @return
	 */
	public Customer getCustomer(long id) {
		//TODO
		return null;
	}

	/**
	 * 创建客户
	 * @param fieldMap
	 * @return
	 */
	public boolean createCustomer(Map<String, Object> fieldMap) {
		//TODO
		return false;
	}

	/**
	 * 更新客户
	 * @param id
	 * @param fieldMap
	 * @return
	 */
	public boolean updateCustomer(long id, Map<String, Object> fieldMap) {
		//TODO
		return false;
	}

	/**
	 * 删除客户
	 * @param id
	 * @return
	 */
	private boolean deleteCustomer(long id) {
		//TODO
		return false;
	}
}
