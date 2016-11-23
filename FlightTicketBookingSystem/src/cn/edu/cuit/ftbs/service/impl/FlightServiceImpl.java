package cn.edu.cuit.ftbs.service.impl;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.cuit.ftbs.dao.IFlightDao;
import cn.edu.cuit.ftbs.dao.impl.FlightDaoImpl;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.IFlightService;

public class FlightServiceImpl implements IFlightService{
	IFlightDao dao = new FlightDaoImpl();

	@Override
	public boolean addFlight(Flight flight) {
		try {
			if (dao.findByFlightNum(flight.getFlightNum()) == null){
				dao.doCreate(flight);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean deleteFlight(String flightNum) {
		try {
			return dao.doRemove(flightNum);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public boolean updateFlight(Flight flight) {
		try {
			return dao.doUpdate(flight);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ArrayList<Flight> queryFlight(String departureCity, String arrivalCity, Date departureTime) {
		return dao.findByCondition(departureCity, arrivalCity, departureTime);
	}

}
