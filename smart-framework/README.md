
# 组织结构
```
framework
├─annotation -- 定义的可以使用的注解
│  ├─Action -- 使用在方法上的注解
│  ├─Controller -- Controller层注解
│  ├─Inject -- 依赖注入注解
│  └─Service -- Service层注解
├─bean -- bena对象
├─helper -- 帮助类
├─utils -- 工具类及通用代码
├─ConfigConstant -- 提供相关配置项常量
└─
```
**一些帮助类解释：**

- ClassHelper：获取加载过的类

  - getClassSet()：获取应用包下所有类
  
  - getServiceClassSet()：获取应用包名下所有 Service 类
  
  - getControllerClassSet()：获取应用包名下所有 Controller 类
  
  - getBeanClassSet()：获取应用包名下所有 Bean 类 （包括：Service、Controller 等）

- BeanHelper：获取并管理实例化对象

  - getBeanMap()：获取所有实例化对象
  
  - getBean(Class<T> cls)：获取相应类的实例化对象

**一些工具类解释**

- PropsUtil：加载配置文件
- ClassUtil：加载类
- RefelectionUtil：通过反射实例化对象

  - newInstance(Class<?> cls)：实例化对象
  
  - invokeMethod(Object obj, Method method, Object ... args)：调用对应对象的方法
  
  - setField(Object obj, Field field, Object value)：给对应对象的对应属性赋值


### 配置文件
smart.properties 示例
```properties
# 数据库连接配置信息
smart.framework.jdbc.driver = com.mysql.jdbc.Driver
smart.framework.jdbc.url = jdbc:mysql://localhost:3306/数据库
smart.framework.jdbc.username = 用户名
smart.framework.jdbc.password = 密码

# 项目基础包名
smart.framework.app.base_package = 项目基础包名
# JSP基础路径
smart.framework.app.jsp_path = /WEB-INF/view/
# 静态资源文件基础路径（js、css、图片等）
smart.framework.app.asset_path = /asset/
```