package cn.edu.cuit.ftbs.dao;

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
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doCreate(Ticket ticket) throws Exception;
	/**
	 * 执行数据的更新操作
	 * @param ticket 包含新数据的ticket对象
	 * @return 如果更新数据成功返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doUpdate(Ticket ticket) throws Exception;
	/**
	 * 执行数据的删除操作
	 * @param ticketNum 要删除机票的编号ticketNum
	 * @return 如果删除数据成功则返回true，否则返回false
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public boolean doRemove(String ticketNum) throws Exception;
	/**
	 * 根据顾客姓名查找机票
	 * @param ticketNum 要查找机票的编号
	 * @return 如果没有指定的雇员编号，返回值为null，<br>
	 * 如果有指定的雇员信息，则将所有的雇员信息包装到Ticket实例化对象之中返回。
	 * @throws Exception 操作之中出现了异常，返回给被调用处执行处理
	 */
	public Ticket findByTicketNum(String ticketNum) throws Exception;
}
