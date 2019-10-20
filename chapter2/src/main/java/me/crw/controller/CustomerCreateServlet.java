package me.crw.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

	/**
	 * 进入 创建客户 界面
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO
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
		//TODO
	}
}
