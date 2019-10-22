package me.crw.controller;

import me.crw.model.Customer;
import me.crw.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * ClassName: CustomerServlet
 * Description:
 * date: 2019/10/20 12:34
 *
 * @author crwen
 * @create 2019-10-20-12:34
 * @since JDK 1.8
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

	private CustomerService customerService;

	@Override
	public void init() throws ServletException {
		customerService = new CustomerService();
	}

	/**
	 * 进入 客户列表 界面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Customer> customerList = customerService.getCustomerList();
		req.setAttribute("customerList", customerList);
		req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
	}
}
