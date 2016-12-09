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
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean login(String username, String password) throws Exception;
	/**
	 * 用户注册
	 * @param customer Customer类对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean register(Customer customer)throws Exception;
	/**
	 * 更新用户信息
	 * @param customer Customer类对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean updateCustomer(Customer customer)throws Exception;
	/**
	 * 更新用户信息
	 * @param username 所要查找用户用户名
	 * @return 返回一个Customer实体类对象
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public Customer qureyCustomer(String username)throws Exception;
	/**
	 * 添加用户
	 * @param customer 所要添加的用户对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean addCustomer(Customer customer)throws Exception;
	/**
	 * 注销登录
	 * @param username 所要注销的用户的用户名
	 * @return没有返回值
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public void logout(String username)throws Exception;

}
