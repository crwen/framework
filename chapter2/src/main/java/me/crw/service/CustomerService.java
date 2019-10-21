package me.crw.service;

import me.crw.model.Customer;
import me.crw.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

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
	private static final String DRIVER;
	private static final String URL;
	private static final String USERNAME;
	private static final String PASSWORD;

	static {
		Properties conf = PropsUtil.loadProps("config.properties");
		DRIVER = conf.getProperty("jdbc.driver");
		URL = conf.getProperty("jdbc.url");
		USERNAME = conf.getProperty("jdbc.username");
		PASSWORD = conf.getProperty("jdbc.password");

		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			LOGGER.error("can not load jdbc driver", e);
		}
	}

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
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getLong("id"));
				customer.setName(rs.getString("name"));
				customer.setContact(rs.getString("contact"));
				customer.setTelephone(rs.getString("telephone"));
				customer.setEmail(rs.getString("email"));
				customer.setRemark(rs.getString("remark"));
				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException e) {
			LOGGER.error("execute sql failure", e);
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					LOGGER.error("close connection failure", e);
				}
			}
		}
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
	public boolean deleteCustomer(long id) {
		//TODO
		return false;
	}
}
