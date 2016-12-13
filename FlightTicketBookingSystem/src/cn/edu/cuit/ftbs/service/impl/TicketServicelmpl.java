package cn.edu.cuit.ftbs.service.impl;


import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.cuit.ftbs.dao.ITicketDao;
import cn.edu.cuit.ftbs.dao.impl.TicketDaolmpl;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.ITicketService;
/**
 * 机票业务逻辑实现类
 * @author邓义
 *
 */
public class TicketServicelmpl implements ITicketService {
	ITicketDao dao = new TicketDaolmpl();
	@Override
	public boolean addTicket(Ticket ticket) {
		try {
			if (dao.findByTicketNum(ticket.getTicketNum()) == null){
				return dao.doCreate(ticket);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTicket(String ticketNum){
		try {
			return dao.doRemove(ticketNum);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTicket(Ticket ticket) {
		try {
			return dao.doUpdate(ticket);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Ticket> queryTicket(String username) {
		try {
			return dao.findByUsername(username);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
}

