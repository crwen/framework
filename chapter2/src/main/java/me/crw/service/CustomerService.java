package me.crw.service;

import me.crw.helper.DatabaseHelper;
import me.crw.model.Customer;
import me.crw.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.ArrayList;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(PropsUtil.class);

	/**
	 * 根据关键词获取客户列表
	 * @param keyword
	 * @return
	 */
	public List<Customer> getCustomerList(String keyword) {
		Connection connection = null;
		try {
			List<Customer> customerList = new ArrayList<>();
			String sql = "SELECT * FROM customer";
			//connection = DatabaseHelper.getConnection();
			//PreparedStatement stmt = connection.prepareStatement(sql);
			//ResultSet rs = stmt.executeQuery();
			//while (rs.next()) {
			//	Customer customer = new Customer();
			//	customer.setId(rs.getLong("id"));
			//	customer.setName(rs.getString("name"));
			//	customer.setContact(rs.getString("contact"));
			//	customer.setTelephone(rs.getString("telephone"));
			//	customer.setEmail(rs.getString("email"));
			//	customer.setRemark(rs.getString("remark"));
			//	customerList.add(customer);
			//}
			customerList = DatabaseHelper.queryEntityList(Customer.class, sql);
			return customerList;
		} finally {
			DatabaseHelper.closeConnection();
		}
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
	public boolean deleteCustomer(long id) {
		//TODO
		return false;
	}
}
