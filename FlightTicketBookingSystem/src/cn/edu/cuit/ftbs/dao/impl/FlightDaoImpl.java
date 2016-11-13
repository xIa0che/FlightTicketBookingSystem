package cn.edu.cuit.ftbs.dao.impl;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.cuit.ftbs.dao.IFlightDao;
import cn.edu.cuit.ftbs.entity.Flight;

public class FlightDaoImpl implements IFlightDao{

	@Override
	public boolean doCreate(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(Flight flight) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doRemove(String flightNum) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Flight> findByCondition(String departureCity, String arrivalCity, Date departureTime) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight findByFlightNum(String flightNum) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flight findByAirline(String airline) {
		// TODO Auto-generated method stub
		return null;
	}

}
