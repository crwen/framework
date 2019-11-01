package me.crw.framework;

/**
 * ClassName: ConfigConstant
 * Description: 提供相关配置项常量
 * date: 2019/11/1 14:58
 *
 * @author crwen
 * @create 2019-11-01-14:58
 * @since JDK 1.8
 */
public interface ConfigConstant {

	String CONFIG_FILE = "smart.properties";

	String JDBC_DRIVER = "smart.framework.jdbc.driver";
	String JDBC_URL = "smart.framework.jdbc.url";
	String JDBC_USERNAME = "smart.framework.jdbc.username";
	String JDBC_PASSWORD = "smart.framework.jdbc.password";

	String APP_BASE_PACKAGE = "smart.framework.app.base_package";
	String APP_JSP_PATH = "smart.framework.app.jsp_path";
	String APP_ASSERT_PATH = "smart.framework.app.assert_path";
}
