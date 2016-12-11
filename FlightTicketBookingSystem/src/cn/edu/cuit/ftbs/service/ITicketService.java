package cn.edu.cuit.ftbs.service;

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
	 * @param username 要删除机票的username
	 * @return 如果删除成功，返回true，如果数据不存在或删除失败，则返回false
	 */
	public boolean deleteTicket(String username);
	/**
	 * 执行机票更新操作
	 * @param ticket 包含数据的对象
	 * @return 如果修改成功，返回true，如果数据不存在或修改失败，返回false
	 */
	public boolean updateTicket(Ticket ticket);
	/**
	 * 执行查询机票操作
	 * @param username 要查询机票的username
	 * @return 如果没有指定的顾客姓名，返回值为null，<br>
	 * 如果有指定的雇员信息，则将所有的雇员信息包装到Ticket实例化对象之中返回。
	 */
	public Ticket queryTicket(String username);
}
