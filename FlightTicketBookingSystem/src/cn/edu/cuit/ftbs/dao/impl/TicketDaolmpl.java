package cn.edu.cuit.ftbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sun.xml.internal.fastinfoset.sax.SAXDocumentSerializerWithPrefixMapping;

import cn.edu.cuit.ftbs.dao.ICustomerDao;
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
	public boolean doCreate(Ticket ticket) throws Exception {
		String sql = "INSERT INTO T_Ticket(ticketNum,seatClass,id,username) values(?,?,?,?)";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(3, ticket.getTicketNum());
		pstmt.setString(2, ticket.getSeatClass());
		pstmt.setString(4, ticket.getFlightInfo().getId());
		pstmt.setString(1, ticket.getCustomer().getUsername());

		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doUpdate(Ticket ticket) throws Exception {
		String sql = "UPDATE T_Ticket SET ticketNum=?,seatClass=?,id=?,userName=? where ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(3, ticket.getTicketNum());
		this.pstmt.setString(2, ticket.getSeatClass());
		this.pstmt.setString(4, ticket.getFlightInfo().getId());
		this.pstmt.setString(1, ticket.getCustomer().getUsername());
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doRemove(String ticketNum) throws Exception {
		String sql = "DELETE FROM T_Ticket WHERE ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(3, ticketNum);
		if (pstmt.executeUpdate() > 0) {
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public Ticket findByTicketNum(String ticketNum) throws Exception {
		Ticket ticket = null;
		ICustomerService iCustomerService =new CustomerServiceImpl();
		IFlightService iFlightService = new FlightServiceImpl();
		String sql = "SELECT * FROM T_Ticket WHERE ticketNum=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		this.pstmt.setString(3, ticketNum);
		//TODO 数据库错误，无效列索引
		ResultSet rs = this.pstmt.executeQuery();
		if (rs.next()) {
			ticket = new Ticket();
			ticket.setTicketNum(rs.getString(3));
			ticket.setSeatClass(rs.getString(2));
			ticket.setCustomer(iCustomerService.qureyCustomer(rs.getString(1)));
			ticket.setFlightInfo(iFlightService.queryFlight((rs.getString(4))));
		}
		return ticket;
	}
}
