
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


