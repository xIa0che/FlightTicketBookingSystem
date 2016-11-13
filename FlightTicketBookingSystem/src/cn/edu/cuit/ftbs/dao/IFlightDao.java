package cn.edu.cuit.ftbs.dao;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.cuit.ftbs.entity.Flight;

public interface IFlightDao {

	public boolean doCreate(Flight flight);

	public boolean doUpdate(Flight flight);

	public boolean doRemove(String flightNum);

	public ArrayList<Flight> findByCondition(String departureCity,
			String arrivalCity, Date departureTime);

	public Flight findByFlightNum(String flightNum);

	public Flight findByAirline(String airline);
}
