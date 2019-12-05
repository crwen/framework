
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
&emsp;我们需要[自定义一个类加载器](https://github.com/crwen/framework/blob/master/smart-framework/src/main/java/me/crw/framework/utils/ClassUtil.java)，用来加载基础包下的所有类，比如使用了某注解的类，或者实现了某接口的类，再或者继承了某父类的所有子类等。

我们的目标是在控制器类上使用Controller注解，在控制器类的方法上使用 Action 注解，在服务类上使用 Serivice注解，在控制器类中使用 Inject 注解将服务类依赖注入进来。因此我们需要自定义这4个注解类。
```java
public @interface Controller {}
public @interface Service {}
public @interface Action {}
public @interface Inject {}
```
由于我们需要通过配置文件的基础包名来获取包名下的所有类，所以我们有必要提供一个[帮助类](https://github.com/crwen/framework/blob/master/smart-framework/src/main/java/me/crw/framework/helper/ClassHelper.java)，让它分别获取应用包名下的所有类。此外，我们可以将带有Controller注解和Service注解的类所产生的对象理解为有框架所管理的Bean，所以有必要在帮助类中增加一个获取应用包名下所有Bean的方法。

## 3.6 实现 Bean 容器
&emsp;使用ClassHelper类可以获取所加载的类，但是无法的到实例化对象。因此，需要提供一个反射工具类，让它封装反射相关API，对外提供更好用的工具方法，以此来获取实例化对象。

```java
public final class BeanHelper {
	/**
	 *  定义 Bean 映射（用于存放Bean 类与 Bean 实例的映射关系）
	 */
	private static final Map<Class<?>, Object> BEAN_MAP = new HashMap<Class<?>, Object>();
	
	static {
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for (Class<?> beanClass : beanClassSet) {
			Object obj = RelfectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, obj);
		}
	}
	/**
	 *  获取 Bean 映射
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap() {
		return BEAN_MAP;
	}
	
	public static <T>T getBean(Class<T> cls) {
		if (!BEAN_MAP.containsKey(cls)) {
			throw new RuntimeException("can not get bean by class: " + cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
}

```

## 3.7 实现依赖注入功能

&emsp;**目的**: 在 Controller 定义 Service 成员变量，然后在 Controller 的 Action 方法中调用 Service 成员变量的方法

&emsp;**问题**：如何实例化 Service 成员变量？

&emsp;**思路**：

&emsp;1. 通过 BeanHelper 获取所有 Bean Map（一个Map<Class<?>, Object>结构，记录了类与对象的映射关系）

&emsp;2.遍历map，分别取出 Bean 类 和 Bean 实例，通过反射获取类中的所有成员变量

&emsp;3. 继续遍历这些成员变量，判断当前成员变量是否带有 Inject 注解，若带有该注解，则从 Bean Map 中根据 Bean 类取出 Bean 实例。

&emsp;4. 最后通过 ReflectionUtil#setField 方法来修改当前成员变量的值

 ## 3.8 加载 Controller
 &emsp;我们需要创建一个 ControllerHelper 类，让它来处理如下逻辑：
 - 获取所有定义了 Controller 注解的类
 - 通过反射获取该类中所有带 Action 注解的方法
 - 获取 Action 注解中的请求表达式，进而获取请求方法与请求路径
 - 封装一个请求对象（Request）与处理对象（Handler）
 - 将 Request 与 Handler 建立一个映射关系，放入一个 Action Map 中，并提供一个可根据请求方法与请求路径获取处理对象的方法
 
 ## 3.9 初始化框架
 
 &emsp;我们之前创建了 ClassHelper、BeanHelper、IocHelper、ControllerHelper，现在我们需要一个入口程序来加载他们。
 
 ## 3.10 请求转发器
 
&emsp;帮助类和工具类都写完了，现在，我们需要编写一个Servlet，让它来处理所有的请求。
思路：
- &emsp;从HttpServletRequest 对象获取请求方法与请求路径，通过 ControllerHelper#getHandler 方法来获取 Handler 对象。
- 拿到 Handler 对象后，获取 Controller 对象，进而通过 BeanHelper.getBean 方法获取 Controller 的实例对象。
- 从 HttpServletRequest 对象中获取所有请求参数，并将其初始化到一个名为 Param 的对象中

Param类实现：
- 有一些类get 方法，可通过参数名获取指定类型的参数值，也可以获取所有参数的 Map 结构。
- 可以从 Handler 对象中获取 Action 的方法返回值，该返回值有两种情况：
  - 返回值是 View 类型的视图对象，返回一个 JSP 页面
  - 返回值是 Data类型的数据对象，返回一个 JSON 数据。