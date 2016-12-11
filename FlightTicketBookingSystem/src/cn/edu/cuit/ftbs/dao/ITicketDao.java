package cn.edu.cuit.ftbs.dao;

import java.sql.SQLException;

import cn.edu.cuit.ftbs.entity.Ticket;

/**
 * 数据访问类接口
 * @author 邓义
 */
public interface ITicketDao{
	/**
	 * 执行数据的增加操作 ִ
	 * @param ticket 包含要增加数据的ticket对象
	 * @return 如果增加数据成功返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doCreate(Ticket ticket) throws SQLException;
	/**
	 * 执行数据的更新操作
	 * @param ticket 包含新数据的ticket对象
	 * @return 如果更新数据成功返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doUpdate(Ticket ticket) throws SQLException;
	/**
	 * 执行数据的删除操作
	 * @param username 要删除机票的顾客姓名
	 * @return 如果删除数据成功则返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doRemove(String username) throws SQLException;
	/**
	 * 根据顾客姓名查找机票
	 * @param username 要查找机票的顾客姓名
	 * @return 如果没有指定的雇员编号，返回值为null，<br>
	 * 如果有指定的雇员信息，则将所有的雇员信息包装到Ticket实例化对象之中返回。
	 * @throws Exception SQLException 数据库异常
	 */
	public Ticket findByUsername(String username) throws SQLException;
}
