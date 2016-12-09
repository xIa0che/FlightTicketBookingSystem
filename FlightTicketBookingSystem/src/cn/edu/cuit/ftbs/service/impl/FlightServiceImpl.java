package cn.edu.cuit.ftbs.service.impl;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import cn.edu.cuit.ftbs.dao.IFlightDao;
import cn.edu.cuit.ftbs.dao.impl.FlightDaoImpl;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.IFlightService;

public class FlightServiceImpl implements IFlightService{
	IFlightDao dao = new FlightDaoImpl();

	@Override
	public boolean addFlight(Flight flight) {
		try {
			if (dao.findById(flight.getId()) == null){
				return dao.doCreate(flight);
			}
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteFlight(String flightNum) {
		try {
			return dao.doRemove(flightNum);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateFlight(Flight flight) {
		try {
			return dao.doUpdate(flight);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Flight> queryFlight(String departureCity, String arrivalCity, Date departureTime) {
		try {
			return dao.findByCondition(departureCity, arrivalCity, departureTime);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}

	public Flight queryFlight(String id) {
		try {
			return dao.findById(id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "数据库错误", null, JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		return null;
	}
}
