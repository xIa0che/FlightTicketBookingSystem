package cn.edu.cuit.ftbs.service.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;

import cn.edu.cuit.ftbs.dao.IFlightDao;
import cn.edu.cuit.ftbs.dao.impl.FlightDaoImpl;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.IFlightService;
import cn.edu.cuit.ftbs.util.DatabaseConnection;

public class FlightServiceImpl implements IFlightService{
	private DatabaseConnection dbc = new DatabaseConnection();

	@Override
	public boolean addFlight(Flight flight) {
		try {
			Connection conn = this.dbc.getConnection();
			IFlightDao dao = new FlightDaoImpl(conn);
			if (dao.findByFlightNum(flight.getFlightNum()) == null){
				return false;
			}
			return true;
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return false;
	}

	@Override
	public boolean deleteFlight(String flightNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateFlight(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Flight> queryFlight(String departureCity, String arrivalCity, Date departureTime) {
		// TODO Auto-generated method stub
		return null;
	}

}
