package cn.edu.cuit.ftbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		String id=ticket.getFlightInfo().getId();
		pstmt.setString(3, id);
		System.out.println(ticket.getFlightInfo().getId());
		String username = ticket.getCustomer().getUsername();
		pstmt.setString(4,username );
        System.out.println(ticket.getCustomer().getUsername());
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		System.out.println("false");
		return false;
	}

	@Override
	public boolean doUpdate(Ticket ticket) throws SQLException{
		String sql = "UPDATE T_Ticket SET ticketNum=?,seatClass=?,id=?,userName=? where ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, ticket.getTicketNum());
		this.pstmt.setString(2, ticket.getSeatClass());
		this.pstmt.setString(3, ticket.getFlightInfo().getId());
		this.pstmt.setString(4, ticket.getCustomer().getUsername());
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doRemove(String ticketNum) throws SQLException {
		String sql = "DELETE FROM T_Ticket WHERE ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, ticketNum);
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public Ticket findByUsername(String username) throws SQLException{
		Ticket ticket = null;
		ICustomerService iCustomerService =new CustomerServiceImpl();
		IFlightService iFlightService = new FlightServiceImpl();
		String sql = "SELECT ticketNum,seatClass,id,username FROM T_Ticket WHERE ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(1, username);
		//TODO 数据库错误，无效列索引
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ticket = new Ticket();
			ticket.setTicketNum(rs.getString(1));
			ticket.setSeatClass(rs.getString(2));
			ticket.setFlightInfo(iFlightService.queryFlight((rs.getString(3))));
			try {
				ticket.setCustomer(iCustomerService.qureyCustomer(rs.getString(4)));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ticket;
	}
}
