package cn.edu.cuit.ftbs.dao;

import cn.edu.cuit.ftbs.entity.Customer;

/**
 * ICustomerDao操作接口
 * @author 陈星
 */
public interface ICustomerDao {

	/**
	 * 执行用户的增加操作
	 * @param customer 包含所要增加的数据的Customer对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doCreate(Customer customer) throws Exception;
	/**
	 * 执行用户的更新操作
	 * @param customer 包含所要增加的数据的Customer对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doUpdate(Customer customer) throws Exception;
	/**
	 * 根据用户名删除用户
	 * @param username 所要删除用户的用户名
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doRemove(String username) throws Exception;
	/**
	 * 根据用户名查找用户
	 * @param username 所要删除用户的用户名
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public Customer findByusername(String username) throws Exception;
	/**
	 * 验证用户名和密码
	 * @param username 用户名
	 * @param password 登陆密码
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean checkCustomer(String username, String password) throws Exception;
}
