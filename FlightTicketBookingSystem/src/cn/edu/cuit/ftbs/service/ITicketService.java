package cn.edu.cuit.ftbs.service;

import cn.edu.cuit.ftbs.entity.Ticket;

/**
 * 业务逻辑层
 * @author 邓义
 *
 */

public interface ITicketService {
	/**
	 * 调用数据库的增加操作，操作流程如下：<br>
	 * <li>首先要使用ITicketDao接口中的findByTicketNum()方法，根据要增加的TicketNum查看指定的机票信息是否存在；
	 * <li>如果要增加的机票信息不存在，则执行ITicketDao接口的doCreate()方法，并将结果返回；
	 * @param vo 包装数据的对象
	 * @return 如果增加成功，返回true，如果顾客姓名存在或者是增加失败，返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean addTicket(Ticket ticket) throws Exception;
	/**
	 * 执行数据的删除操作，删除操作的时候调用ITicketDAO接口的doRemove()方法
	 * @param ticketNum 要删除机票的ticketNum
	 * @return 如果删除成功，返回true，如果数据不存在或删除失败，则返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean deleteTicket(String ticketNum) throws Exception;
	/**
	 * 执行数据的更新操作，操作的时候直接调用ITicketDao接口的doUpdate()方法，并将更新结果返回
	 * @param ticket 包装数据的对象
	 * @return 如果修改成功，返回true，如果数据不存在或修改失败，返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean updateTicket(Ticket ticket) throws Exception;
	/**
	 * 执行机票的查询操作，查询操作的时候调用ITicketDAO接口的findByticketNum()方法
	 * @param ticketNum 要查询机票的ticketNum
	 * @return 如果没有指定的顾客姓名，返回值为null，<br>
	 * 如果有指定的雇员信息，则将所有的雇员信息包装到Ticket实例化对象之中返回。
	 * @throws Exception 有异常交给被调用处处理
	 */
	public Ticket queryTicket(String ticketNum) throws Exception;
	/**
	 * 执行机票的预订操作，
	 * @param customerId 要预订机票的顾客编号
	 * @param ticket 包含机票信息的ticket对象
	 * @return 如果订票成功返回true，否则返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean bookTicket(String customerId,Ticket ticket)throws Exception;
	/**
	 * ִ执行机票的退订操作
	 * @param CustomerId 要退订机票的顾客编号
	 * @param ticket 包含机票信息的ticket对象
	 * @return 如果退订成功返回true，否则返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean returnTicket(String CustomerId,Ticket ticket) throws Exception;
	/**
	 * 执行机票的改签操作
	 * @param CustomerId 要改签机票的顾客编号
	 * @param oldTicket 包含原有机票信息的Ticket对象
	 * @param newTicket 包含新机票信息的Ticket对象
	 * @return 如果改签成功返回true，否则返回false
	 * @throws Exception 有异常交给被调用处处理
	 */
	public boolean changTicket(String CustomerId,Ticket oldTicket,Ticket newTicket)throws Exception;
}
