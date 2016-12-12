package cn.edu.cuit.ftbs.entity;

import java.util.ArrayList;
/**
 * Customer用户实体类，定义基本属性及方法
 * @author 陈星
 */
public class Customer {
	private String Id;
	private String name;
	private String sex;
	private String telephone;
	private String idCardNumber;
	private String eMail;
	private String address;
	private String username;
	private String password;
	//private ArrayList<Ticket> tickets;
	//private ArrayList<Order> orders;
	
	
	
	public Customer(){}
	
	public Customer(String id, String name, String sex, String telephone, String idCardNumber, String eMail,
			String address, String username, String password /*ArrayList<Ticket> tickets, ArrayList<Order> orders*/) {
		Id = id;
		this.name = name;
		this.sex = sex;
		this.telephone = telephone;
		this.idCardNumber = idCardNumber;
		this.eMail = eMail;
		this.address = address;
		this.username = username;
		this.password = password;
		//this.tickets = tickets;
		//this.orders = orders;
	}



	public Customer(String username) {
		this.username=username;
	}

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getIdCardNumber() {
		return idCardNumber;
	}
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	/*public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}*/
	
	
}