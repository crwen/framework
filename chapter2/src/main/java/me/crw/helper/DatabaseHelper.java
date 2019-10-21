package me.crw.helper;

import me.crw.utils.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * ClassName: DatebaseHelper
 * Description: 数据库操作助手类
 * date: 2019/10/21 13:30
 *
 * @author crwen
 * @create 2019-10-21-13:30
 * @since JDK 1.8
 */
public final class DatabaseHelper {

	private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseHelper.class);

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
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			LOGGER.error("execute sql failure", e);
		}

		return conn;
	}

	/**
	 * 关闭数据库连接
	 * @param connection
	 */
	public static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.error("close connection failure", e);
			}
		}
	}


}
