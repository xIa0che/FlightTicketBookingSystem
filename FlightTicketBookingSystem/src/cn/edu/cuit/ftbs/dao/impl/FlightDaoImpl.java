package cn.edu.cuit.ftbs.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.edu.cuit.ftbs.dao.IFlightDao;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.util.OracleDbManager;

public class FlightDaoImpl implements IFlightDao{
	private Connection conn;
	private PreparedStatement pstmt;

	@Override
	public boolean doCreate(Flight flight) throws SQLException {
		String sql = "INSERT INTO T_Flight (flightNum, airline, planeType, "
				+ "departureCity, arrivalCity, departureTime, arrivalTime, "
				+ "firstClassCabinPrice, businessClassCabinPrice, "
				+ "economyClassCabinPrice, id) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, flight.getFlightNum());
		pstmt.setString(2, flight.getAirline());
		pstmt.setString(3, flight.getPlaneType());
		pstmt.setString(4, flight.getDepartureCity());
		pstmt.setString(5, flight.getArrivalCity());
		pstmt.setTimestamp(6, new Timestamp(flight.getArrivalTime().getTime()));
		pstmt.setTimestamp(7, new Timestamp(flight.getDepartureTime().getTime()));
		pstmt.setInt(8, flight.getFirstClassCabinPrice());
		pstmt.setInt(9, flight.getBusinessClassCabinPrice());
		pstmt.setInt(10, flight.getEconomyClassCabinPrice());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String id = flight.getFlightNum() + dateFormat.format(new Date());
		pstmt.setString(11, id);
		if (pstmt.executeUpdate() > 0){
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doUpdate(Flight flight) throws SQLException {
		String sql = "UPDATE T_Flight SET airline=?, planeType=?,"
				+ "departureCity=?, arrivalCity=?, departureTime=?"
				+ ", arrivalTime=?, flightNum=? WHERE id=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, flight.getAirline());
		pstmt.setString(2, flight.getPlaneType());
		pstmt.setString(3, flight.getDepartureCity());
		pstmt.setString(4, flight.getArrivalCity());
		pstmt.setDate(5, new java.sql.Date(flight.getDepartureTime().getTime()));
		pstmt.setDate(6, new java.sql.Date(flight.getArrivalTime().getTime()));
		pstmt.setString(7, flight.getFlightNum());
		pstmt.setString(8, flight.getId());
		if (pstmt.executeUpdate() > 0){
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public boolean doRemove(String id) throws SQLException {
		String sql = "DELETE FROM T_Flight WHERE id=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		if (pstmt.executeUpdate() > 0){
			OracleDbManager.closeConnection(pstmt, conn);
			return true;
		}
		OracleDbManager.closeConnection(pstmt, conn);
		return false;
	}

	@Override
	public List<Flight> findByCondition(String departureCity, String arrivalCity, java.util.Date departureTime) throws SQLException {
		List<Flight> all = new ArrayList<Flight>();
		String sql = "SELECT flightNum,airline,planeType,departureCity,arrivalCity,"
				+ "departureTime,arrivalTime,id,firstClassCabinPrice,"
				+ "businessClassCabinPrice, economyClassCabinPrice FROM T_Flight "
				+ "WHERE departureCity=? AND arrivalCity=? "
				+ "AND to_char(departuretime, 'yyyy-mm-dd')=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, departureCity);
		pstmt.setString(2, arrivalCity);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		pstmt.setString(3, dateFormat.format(departureTime));
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			Flight flight = new Flight();
			flight.setFlightNum(rs.getString(1));
			flight.setAirline(rs.getString(2));
			flight.setPlaneType(rs.getString(3));
			flight.setDepartureCity(rs.getString(4));
			flight.setArrivalCity(rs.getString(5));
			flight.setDepartureTime(rs.getTimestamp(6));
			flight.setArrivalTime(rs.getTimestamp(7));
			flight.setId(rs.getString(8));
			flight.setFirstClassCabinPrice(rs.getInt(9));
			flight.setBusinessClassCabinPrice(rs.getInt(10));
			flight.setEconomyClassCabinPrice(rs.getInt(11));
			all.add(flight);
		}
		return all;
	}

	@Override
	public Flight findById(String id) throws SQLException {
		Flight flight = null;
		String sql = "SELECT flightNum,airLine,planeType,departureCity,arrivalCity,"
				+ "departureTime,arrivalTime,firstClassCabinPrice,"
				+ "businessClassCabinPrice,economyClassCabinPrice from T_Flight"
				+ " WHERE id=?";
		conn = OracleDbManager.getConnection();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, id);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()){
			flight = new Flight();
			flight.setId(id);
			flight.setFlightNum(rs.getString(1));
			flight.setAirline(rs.getString(2));
			flight.setPlaneType(rs.getString(3));
			flight.setDepartureCity(rs.getString(4));
			flight.setArrivalCity(rs.getString(5));
			flight.setDepartureTime(rs.getTimestamp(6));
			flight.setArrivalTime(rs.getTimestamp(7));
			flight.setFirstClassCabinPrice(rs.getInt(8));
			flight.setBusinessClassCabinPrice(rs.getInt(9));
			flight.setEconomyClassCabinPrice(rs.getInt(10));
		}
		return flight;
	}

	@Override
	public List<Flight> findByAirline(String airline) {
		// TODO Auto-generated method stub
		return null;
	}

}
