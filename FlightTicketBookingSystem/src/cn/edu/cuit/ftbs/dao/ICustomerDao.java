package cn.edu.cuit.ftbs.dao;

import cn.edu.cuit.ftbs.entity.Customer;

/**
 * Customer数据访问接口
 * @author 陈星
 */
public interface ICustomerDao {

	/**
	 * 执行用户的增加操作
	 * @param customer 包含所要增加的数据的Customer对象
	 * @return 如果增加数据成功返回true，否则返回false
	 */
	public boolean doCreate(Customer customer);
	/**
	 * 执行用户的更新操作
	 * @param customer 包含所要增加的数据的Customer对象
	 * @return 如果更新数据成功返回true，否则返回false
	 */
	public boolean doUpdate(Customer customer);
	/**
	 * 根据用户名删除用户
	 * @param username 所要删除用户的用户名
	 * @return 如果删除数据成功返回true，否则返回false
	 */
	public boolean doRemove(String username);
	/**
	 * 根据用户名查找用户
	 * @param username 所要查找用户的用户名
	 * @return 如果查找成功返回查找到的用户实例，否则返回null
	 */
	public Customer findByUsername(String username);
	/**
	 * 验证用户名和密码
	 * @param username 用户名
	 * @param password 登陆密码
	 * @return 如果验证成功返回true，否则返回false
	 */
	public boolean checkCustomer(String username, String password);
}
