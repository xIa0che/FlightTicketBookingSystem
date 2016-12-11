package cn.edu.cuit.ftbs.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cn.edu.cuit.ftbs.entity.Flight;

public class FlightDisplayTableModel implements TableModel {
	private List<Flight> flightList;
	private String[] columnName = {"航班",
			                       "出发城市",
			                       "到达城市",
								   "出发时间",
								   "到达时间",
								   "机型",
								   "头等舱",
								   "公务舱",
								   "经济舱"};


	public FlightDisplayTableModel(List<Flight> flightList) {
		this.flightList = flightList;
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public int getRowCount() {
		return flightList.size();
	}

	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex){
		Flight flight = flightList.get(rowIndex);
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
		switch (columnIndex) {
		case 0:
			return flight.getFlightNum();
		case 1:
			return flight.getDepartureCity();
		case 2:
			return flight.getArrivalCity();
		case 3:
			return dateFormat.format(flight.getDepartureTime());
		case 4:
			String value = dateFormat.format(flight.getArrivalTime());
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String beginDateString = df.format(flight.getDepartureTime());
			Date beginDate = null;
			try {
				beginDate = df.parse(beginDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			String endDateString = df.format(flight.getArrivalTime());
			Date endDate = null;
			try {
				endDate = df.parse(endDateString);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			long betweenDate = (endDate.getTime() - beginDate.getTime()) / (1000*60*60*24);
			if (betweenDate > 0){
				value = value + " +" + betweenDate + '天';
			}
			return value;
		case 5:
			return flight.getPlaneType();
		case 6:
			return flight.getFirstClassCabinPrice();
		case 7:
			return flight.getBusinessClassCabinPrice();
		case 8:
			return flight.getEconomyClassCabinPrice();
		default:
			return null;
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		if (columnIndex == 3 || columnIndex == 4){
			return String.class;
		}
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
	}

}
