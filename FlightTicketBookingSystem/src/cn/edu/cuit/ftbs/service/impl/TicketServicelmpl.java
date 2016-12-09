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
	public boolean addTicket(Ticket ticket) throws Exception {
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
	public boolean deleteTicket(String ticketNum) throws Exception {
		try {
			return dao.doRemove(ticketNum);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateTicket(Ticket ticket) throws Exception {
		try {
			return dao.doUpdate(ticket);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Ticket queryTicket(String ticketNum) throws Exception {
		try {
			return dao.findByTicketNum(ticketNum);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public boolean bookTicket(String customerId, Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean returnTicket(String CustomerId, Ticket ticket) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean changTicket(String CustomerId, Ticket oldTicket, Ticket newTicket) throws Exception {
		// TODO Auto-generated method stub
		return false;
	}
}

