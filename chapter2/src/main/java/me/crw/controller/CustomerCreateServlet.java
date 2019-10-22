package me.crw.controller;

import me.crw.model.Customer;
import me.crw.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: CustomerCreateServlet
 * Description: 创建用户
 * date: 2019/10/20 12:33
 *
 * @author crwen
 * @create 2019-10-20-12:33
 * @since JDK 1.8
 */
@WebServlet("/customer_create")
public class CustomerCreateServlet extends HttpServlet {

	private CustomerService customerService;

	@Override
	public void init() throws ServletException {
		customerService = new CustomerService();
	}

	/**
	 * 进入 创建客户 界面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/view/customer_create.jsp").forward(req, resp);
	}

	/**
	 * 处理 创建客户 请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Customer customer = new Customer();
		Map<String, Object> fieldMap = new HashMap<>();
		fieldMap.put("name", req.getParameter("name"));
		fieldMap.put("contact", req.getParameter("contact"));
		fieldMap.put("telephone", req.getParameter("telephone"));
		fieldMap.put("remark", req.getParameter("remark"));
		boolean result = customerService.createCustomer(fieldMap);

		resp.sendRedirect(req.getServletPath() + "/customer");
	}
}
