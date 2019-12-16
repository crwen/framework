
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