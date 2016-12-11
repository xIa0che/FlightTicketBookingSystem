package cn.edu.cuit.ftbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.edu.cuit.ftbs.dao.ITicketDao;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.IFlightService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;
import cn.edu.cuit.ftbs.service.impl.FlightServiceImpl;
import cn.edu.cuit.ftbs.util.OracleDbManager;

/**
 * 数据访问实现类
 *
 * @author邓义
 *
 */

public class TicketDaolmpl implements ITicketDao {
	private Connection conn;
	private PreparedStatement pstmt;


	@Override
	public boolean doCreate(Ticket ticket) throws SQLException{
		String sql = "INSERT INTO T_Ticket(ticketNum,seatClass,id,username) values(?,?,?,?)";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, ticket.getTicketNum());
		pstmt.setString(2, ticket.getSeatClass());
		pstmt.setString(3, ticket.getFlightInfo().getId());
		pstmt.setString(4,ticket.getCustomer().getUsername());
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doUpdate(Ticket ticket) throws SQLException{
		String sql = "UPDATE T_Ticket SET ticketNum=?,seatClass=?,id=?,userName=? where userName=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, ticket.getTicketNum());
		this.pstmt.setString(2, ticket.getSeatClass());
		this.pstmt.setString(3, ticket.getFlightInfo().getId());
		this.pstmt.setString(4, ticket.getCustomer().getUsername());
		this.pstmt.setString(5, ticket.getCustomer().getUsername());
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doRemove(String username) throws SQLException {
		String sql = "DELETE FROM T_Ticket WHERE username=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public Ticket findByTicketNum(String ticketNum) throws SQLException{
		Ticket ticket = null;
		ICustomerService iCustomerService =new CustomerServiceImpl();
		IFlightService iFlightService = new FlightServiceImpl();
		String sql = "SELECT ticketNum,seatClass,id,username FROM T_Ticket WHERE ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, ticketNum);
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ticket = new Ticket();
			ticket.setTicketNum(rs.getString(1));
			ticket.setSeatClass(rs.getString(2));
			ticket.setFlightInfo(iFlightService.queryFlight((rs.getString(3))));
			try {
				ticket.setCustomer(iCustomerService.qureyCustomer(rs.getString(4)));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ticket;
	}

	@Override
	public List<Ticket> findByUsername(String username) throws SQLException {
		// TODO Auto-generated method stub
		List<Ticket> all = new ArrayList<Ticket>();
		ICustomerService iCustomerService =new CustomerServiceImpl();
		IFlightService iFlightService = new FlightServiceImpl();
		String sql = "SELECT ticketNum,seatClass,id,username FROM T_Ticket WHERE username=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, username );
		ResultSet rs = this.pstmt.executeQuery();
		while (rs.next()) {
			Ticket ticket = new Ticket();
			ticket.setTicketNum(rs.getString(1));
			ticket.setSeatClass(rs.getString(2));
			ticket.setFlightInfo(iFlightService.queryFlight((rs.getString(3))));
			try {
				ticket.setCustomer(iCustomerService.qureyCustomer(rs.getString(4)));
			} catch (Exception e) {
				e.printStackTrace();
			}
			all.add(ticket);
		}
		return all;
	}
	
}
