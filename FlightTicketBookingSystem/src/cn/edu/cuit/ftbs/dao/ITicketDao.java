package cn.edu.cuit.ftbs.dao;

import java.sql.SQLException;

import java.util.List;

import cn.edu.cuit.ftbs.entity.Ticket;

/**
 * Ticket数据访问类接口
 * @author 邓义
 */
public interface ITicketDao{
	/**
	 * 执行数据的增加操 ִ
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
	 * @param ticketNum 要删除机票的编号
	 * @return 如果删除数据成功则返回true，否则返回false
	 * @throws SQLException 数据库异常
	 */
	public boolean doRemove(String ticketNum) throws SQLException;
	/**
	 * 根据机票编号查找机票
	 * @param ticketNum 待查找机票的机票编号
	 * @return 如果没有指定的机票信息，返回值为null，<br>
	 * 如果有指定的机票信息，则将所有的机票信息包装到Ticket实例化对象之中返回。
	 * @throws SQLException 数据库异常
	 */
	public Ticket findByTicketNum(String ticketNum) throws SQLException;
	/**
	 * 根据用户名查找机票
	 * @param username 待查询机票的用户名
	 * @return 如果没有指定的机票信息，返回值为null，<br>
	 * 如果有指定的机票信息，返回机票信息的列表
	 * @throws SQLException 数据库异常
	 */
	public List<Ticket> findByUsername(String username) throws SQLException;
}
