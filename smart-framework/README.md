
## 3.1 确定目标
&emsp;通过Controller注解来定义Controller类，在该类中，可通过Inject注解定义一系列Service成员变量，这就是“依赖注入。”

&emsp;有一系列被Action注解所定义的方法(检查Action方法)，在这些Action方法中，调用了Service成员变量的方法来完成具体的业务逻辑。若返回View对象，则表示JSP页面；若返回Data对象，则表示Json数据

&emsp;一个Controller包含多个Action方法 ，可返回View或Data对象，分别对应JSP页面或JSON数据。

示例：
```java
@Controller
public class CustomerController {

    @Inject
    private CustomerService customerService;
    
    @Action("get:/customer)
    public View index(Param param){ return new View("customer.jsp")}
    
    @Action("put:/customer_edit")
    public Data editSubmit(Param param){ 
        boolean result = customerService.updateCustomer(id, fieldMap); 
        return new Data(result);
    }
}
```

## 3.2 搭建开发环境

### 3.2.1 创建框架项目

### 3.2.2 创建示例项目

## 3.3 定义框架配置项

```properties
# 数据库连接配置信息
smart.framework.jdbc.driver = com.mysql.jdbc.Driver
smart.framework.jdbc.url = jdbc:mysql://localhost:3306/demo
smart.framework.jdbc.username = root
smart.framework.jdbc..password =

# 项目基础包名
smart.framework.app.base_package = me.crw.chapter3
# JSP基础路径
smart.framework.app.jsp_path = /WEB-INF/view/
# 静态资源文件基础路径（js、css、图片等）
smart.framework.app.asset_path = /asset/
```

## 加载配置项
&emsp;维护配置文件中相关配置项名称的常量类
```java
public interface ConfigConstant {

	String CONFIG_FILE = "smart.properties";

	String JDBC_DRIVER = "smart.framework.jdbc.driver";
	String JDBC_URL = "smart.framework.jdbc.url";
	String JDBC_USERNAME = "smart.framework.jdbc.username";
	String JDBC_PASSWORD = "smart.framework.jdbc.password";

	String APP_BASE_PACKAGE = "smart.framework.app.base_package";
	String APP_JSP_PATH = "smart.framework.app.jsp_path";
	String APP_ASSET_PATH = "smart.framework.app.asset_path";
}
```

&emsp;数据库帮助类

```java
public final class ConfigHelper {

	private static final Properties CONFIG_PROPS = PropsUtil.loadProps(ConfigConstant.CONFIG_FILE);

	/**
	 *  获取JDBC驱动
	 * @return
	 */
	public static String getJdbcDriver() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_DRIVER);
	}

	/**
	 *  获取JDBC_URL
	 * @return
	 */
	public static String getJdbcUrl() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_URL);
	}

	/**
	 *  获取 JDBC 用户名
	 * @return
	 */
	public static String getJdbcUsername() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_USERNAME);
	}

	/**
	 *  获取 JDBC 密码
	 * @return
	 */
	public static String getJdbcPassword() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.JDBC_PASSWORD);
	}

	/**
	 *  获取应用基础包名
	 * @return
	 */
	public static String getAppBasePackage() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_BASE_PACKAGE);
	}

	/**
	 *  获取 应用 JSP 路径
	 * @return
	 */
	public static String getAppJspPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_JSP_PATH, "/WEB-INF/view");
	}

	/**
	 * 获取应用静态资源路径
	 * @return
	 */
	public static String getAppAssetPath() {
		return PropsUtil.getString(CONFIG_PROPS, ConfigConstant.APP_ASSET_PATH, "/asset");
	}

}
```

## 3.5 开发一个类加载器
