package cn.edu.cuit.ftbs.service;

import cn.edu.cuit.ftbs.entity.Customer;

/**
 * ICustomerService操作接口
 * @author 陈星
 */
public interface ICustomerService {
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 登陆密码
	 * @return 登陆成功返回true，否则返回false
	 */
	public boolean login(String username, String password);
	/**
	 * 用户注册
	 * @param customer Customer类对象
	 * @return 如果注册成功返回true，否则返回false
	 */
	public boolean register(Customer customer);
	/**
	 * 更新用户信息
	 * @param customer Customer类对象
	 * @return 如果更新数据成功返回true，否则返回false
	 */
	public boolean updateCustomer(Customer customer);
	/**
	 * 查找用户信息
	 * @param username 所要查找用户用户名
	 * @return 返回一个Customer实体类对象
	 */
	public Customer qureyCustomer(String username);
	/**
	 * 添加用户
	 * @param customer 所要添加的用户对象
	 * @return 如果增加数据成功返回true，否则返回false
	 */
	public boolean addCustomer(Customer customer);
	/**
	 * 注销登录
	 * @param username 所要注销的用户的用户名
	 */
	public void logout(String username);

}
