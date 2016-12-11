package cn.edu.cuit.ftbs.service.impl;


import javax.swing.JOptionPane;

import cn.edu.cuit.ftbs.dao.ITicketDao;
import cn.edu.cuit.ftbs.dao.impl.TicketDaolmpl;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.ITicketService;
/**
 * 业务逻辑实现类
 * @author邓义
 *
 */
public class TicketServicelmpl implements ITicketService {
	ITicketDao dao = new TicketDaolmpl();       
	@Override
	public boolean addTicket(Ticket ticket) {
		try {
			if (dao.findByUsername(ticket.getCustomer().getUsername()) == null){
				return dao.doCreate(ticket);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteTicket(String username){
		try {
			return dao.doRemove(username);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTicket(String username) {
		try {
			Ticket ticket= dao.findByUsername(username);
			return dao.doUpdate(ticket);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Ticket queryTicket(String username) {
		try {
			return dao.findByUsername(username);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
}

