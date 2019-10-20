package me.crw.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CustomerDeleteServlet
 * Description: 删除用户
 * date: 2019/10/20 12:34
 *
 * @author crwen
 * @create 2019-10-20-12:34
 * @since JDK 1.8
 */
@WebServlet("/customer_delete")
public class CustomerDeleteServlet extends HttpServlet {
	/**
	 *  处理 删除客户 请求
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO
	}
}
