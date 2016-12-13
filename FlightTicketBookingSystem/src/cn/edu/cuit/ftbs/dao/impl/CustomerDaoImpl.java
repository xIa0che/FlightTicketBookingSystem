package cn.edu.cuit.ftbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.edu.cuit.ftbs.dao.ICustomerDao;
import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.util.OracleDbManager;
/**
 * Customer数据访问接口实现类
 * @author 陈星
 */
public class CustomerDaoImpl implements ICustomerDao {
	private Connection conn;
	private PreparedStatement pstmt = null;

	@Override
	public boolean doCreate(Customer customer){
		boolean flag = false;
		conn = OracleDbManager.getConnection();
		String sql = "INSERT INTO T_Customer(name,"
				+ "sex,telephone,idCardNumber,email,address,"
				+ "username,password) VALUES (?,?,?,?,?,?,?,?)";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, customer.getName());
			this.pstmt.setString(2, customer.getSex());
			this.pstmt.setString(3, customer.getTelephone());
			this.pstmt.setString(4, customer.getIdCardNumber());
			this.pstmt.setString(5, customer.geteMail());
			this.pstmt.setString(6, customer.getAddress());
			this.pstmt.setString(7, customer.getUsername());
			this.pstmt.setString(8, customer.getPassword());
			if(this.pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OracleDbManager.closeConnection(pstmt, conn);
		}

		return flag;
	}

	@Override
	public boolean doUpdate(Customer customer){
		boolean flag = false;
		conn = OracleDbManager.getConnection();
		String sql = "UPDATE T_Customer SET name=?,"
				+ "sex=?,telephone=?,idCardNumber=?,email=?,address=?,"
				+ "password=? WHERE username=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, customer.getName());
			this.pstmt.setString(2, customer.getSex());
			this.pstmt.setString(3, customer.getTelephone());
			this.pstmt.setString(4, customer.getIdCardNumber());
			this.pstmt.setString(5, customer.geteMail());
			this.pstmt.setString(6, customer.getAddress());
			this.pstmt.setString(7, customer.getPassword());
			this.pstmt.setString(8, customer.getUsername());
			if(this.pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OracleDbManager.closeConnection(pstmt, conn);
		}

		return flag;
	}

	@Override
	public boolean doRemove(String username){
		boolean flag = false;
		conn = OracleDbManager.getConnection();
		String sql = "DELETE FROM T_Customer WHERE username=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			if (this.pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OracleDbManager.closeConnection(pstmt, conn);
		}

		return flag;
	}

	@Override
	public Customer findByusername(String username){
		Customer customer = null;
		conn = OracleDbManager.getConnection();
		String sql = "SELECT name,"
				+ "sex,telephone,idCardNumber,email,address,"
				+ "password FROM T_Customer WHERE username=?" ;
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			ResultSet rs = this.pstmt.executeQuery();
			if(rs.next()){
				customer = new Customer();
				customer.setName(rs.getString(1));
				customer.setSex(rs.getString(2));
				customer.setTelephone(rs.getString(3));
				customer.setIdCardNumber(rs.getString(4));
				customer.seteMail(rs.getString(5));
				customer.setAddress(rs.getString(6));
				customer.setPassword(rs.getString(7));
				customer.setUsername(username);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OracleDbManager.closeConnection(pstmt, conn);
		}
		return customer;
	}
	@Override
	public boolean checkCustomer(String username, String password){
		boolean flag = false;
		conn = OracleDbManager.getConnection();
		String sql = "SELECT * FROM T_Customer WHERE username=? and password=?";
		try {
			this.pstmt = this.conn.prepareStatement(sql);
			this.pstmt.setString(1, username);
			this.pstmt.setString(2, password);
			if(this.pstmt.executeUpdate() > 0){
				flag = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			OracleDbManager.closeConnection(pstmt, conn);
		}

		return flag;
	}

}
