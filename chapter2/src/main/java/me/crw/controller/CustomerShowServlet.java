package me.crw.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CustomerShowServlet
 * Description:
 * date: 2019/10/20 12:34
 *
 * @author crwen
 * @create 2019-10-20-12:34
 * @since JDK 1.8
 */
@WebServlet("/customer_show")
public class CustomerShowServlet extends HttpServlet {

	/**
	 * 进入 查看客户界面
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
	 * 处理 查看客户 请求
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
