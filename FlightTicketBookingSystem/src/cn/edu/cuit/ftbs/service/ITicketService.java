package cn.edu.cuit.ftbs.service;

import java.util.List;

import cn.edu.cuit.ftbs.entity.Ticket;

/**
 * 业务逻辑层
 * @author 邓义
 *
 */

public interface ITicketService {
	/**
	 * 执行添加机票操作
	 * @param ticket 包装数据的对象
	 * @return 如果增加成功，返回true，如果顾客姓名存在或者是增加失败，返回false
	 */
	public boolean addTicket(Ticket ticket);
	/**
	 * 执行删除机票操作
	 * @param username 要删除机票的用户名
	 * @return 如果删除成功，返回true，如果数据不存在或删除失败，则返回false
	 */
	public boolean deleteTicket(String username);
	/**
	 * 执行根据用户名更新机票
	 * @param TicketNum 待修改机票的编号
	 * @param ticket 包含新数据的对象
	 * @return 如果修改成功，返回true，如果数据不存在或修改失败，返回false
	 */
	public boolean updateTicket(String TicketNum,Ticket ticket);
	/**
	 * 执行查询机票操作
	 * @param username 要查询机票的用户名 
	 * @return 如果没有指定的用户名，返回值为null，<br>
	 * 如果有指定的机票信息，则将所有的机票信息包装到Ticket实例化对象列表之中返回。
	 */
	public List<Ticket> queryTicket(String username);
}
