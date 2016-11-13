package cn.edu.cuit.ftbs.service;

import java.util.ArrayList;
import java.util.Date;

import cn.edu.cuit.ftbs.entity.Flight;

public interface IFlightService {

	public boolean addFlight(Flight flight);

	public boolean deleteFlight(String flightNum);

	public boolean updateFlight(Flight flight);

	public ArrayList<Flight> queryFlight(String departureCity,
			String arrivalCity, Date departureTime);
}
