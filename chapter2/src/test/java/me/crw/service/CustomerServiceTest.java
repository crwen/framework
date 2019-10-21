package me.crw.service;

import me.crw.model.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: CustomerServiceTest
 * Description:CustomerService测试类
 * date: 2019/10/20 13:55
 *
 * @author crwen
 * @create 2019-10-20-13:55
 * @since JDK 1.8
 */
public class CustomerServiceTest {

	private  CustomerService customerService;

	public CustomerServiceTest() {
		customerService = new CustomerService();
	}

	@Before
	public void init() {
		//TODO 初始化数据库
	}

	@Test
	public void getCustomerListTest() throws Exception {
		List<Customer> customerList = customerService.getCustomerList("");
		//Assert.assertEquals(2, customerList.size());
		Assert.assertNotEquals(0, customerList.size());
		for (Customer customer : customerList) {
			System.out.println(customer);
		}
	}

	@Test
	public void getCustomerTest() throws Exception {
		long id = 1L;
		Customer customer = customerService.getCustomer(id);
		Assert.assertNotNull(customer);
	}

	@Test
	public void createCustomerTest() throws Exception {
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("name", "customer100");
		fieldMap.put("contact", "John");
		fieldMap.put("telephone", "137212345678");
		boolean result = customerService.createCustomer(fieldMap);
		Assert.assertTrue(result);
	}

	@Test
	public void updateCustomerTest() throws Exception {
		long id  = 1L;
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("contact", "Eric");
		boolean result = customerService.updateCustomer(id, fieldMap);
		Assert.assertTrue(result);
	}

	@Test
	public void deleteCustomerTest() {
		long id = 1;
		boolean result = customerService.deleteCustomer(id);
		Assert.assertTrue(result);
	}

}
