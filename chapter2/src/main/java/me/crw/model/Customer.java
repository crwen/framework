package me.crw.model;

/**
 * ClassName: Customer
 * Description: 用户模型层
 * date: 2019/10/20 12:20
 *
 * @author crwen
 * @create 2019-10-20-12:20
 * @since JDK 1.8
 */
public class Customer {

	/**
	 * ID
	 */
	private long id;

	/**
	 * 客户名称
	 */
	private String name;

	/**
	 * 联系人
	 */
	private String contact;

	/**
	 * 电话号码
	 */
	private String telephone;

	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 备注
	 */
	private String remark;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", contact='" + contact + '\'' +
				", telephone='" + telephone + '\'' +
				", email='" + email + '\'' +
				", remark='" + remark + '\'' +
				'}';
	}
}
