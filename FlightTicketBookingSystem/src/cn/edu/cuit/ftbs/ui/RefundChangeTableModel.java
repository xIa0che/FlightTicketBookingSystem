package cn.edu.cuit.ftbs.ui;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.entity.Ticket;

public class RefundChangeTableModel extends AbstractTableModel {
	private List<Ticket> ticketList;
	private String[] columnName = { "机票编号",
									"日期",
									"航班",
									"航空公司",
									"机型",
									"出发城市",
									"到达城市",
									"出发时间",
									"到达时间",
									"舱位价格" };

	public RefundChangeTableModel(List<Ticket> ticketList) {
		this.ticketList = ticketList;
	}

	@Override
	public int getRowCount() {
		return ticketList.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columnName[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Ticket ticket = ticketList.get(rowIndex);
		Flight flight = ticket.getFlightInfo();
		SimpleDateFormat dateFormatTime = new SimpleDateFormat("HH:mm");
		SimpleDateFormat dateFormatDate = new SimpleDateFormat("yyyy/MM/dd");
		switch (columnIndex) {
		case 0:
			return ticket.getTicketNum();
		case 1:
			return dateFormatDate.format(flight.getDepartureTime());
		case 2:
			return flight.getFlightNum();
		case 3:
			return flight.getAirline();
		case 4:
			return flight.getPlaneType();
		case 5:
			return flight.getDepartureCity();
		case 6:
			return flight.getArrivalCity();
		case 7:
			return dateFormatTime.format(flight.getDepartureTime());
		case 8:
			String value = dateFormatTime.format(flight.getArrivalTime());
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
			long betweenDate = (endDate.getTime() - beginDate.getTime()) / (1000 * 60 * 60 * 24);
			if (betweenDate > 0) {
				value = value + " +" + betweenDate + '天';
			}
			return value;
		case 9:
			int price = 0;
			String cabin = null;
			if (ticket.getSeatClass().equals("头等舱")) {
				price = flight.getFirstClassCabinPrice();
				cabin = "头等舱";
			} else if (ticket.getSeatClass().equals("公务舱")) {
				price = flight.getBusinessClassCabinPrice();
				cabin = "公务舱";
			} else {
				price = flight.getEconomyClassCabinPrice();
				cabin = "经济舱";
			}
			return cabin + price;
		}
		return null;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return getValueAt(0, columnIndex).getClass();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}


	public void removeRow(int row){
		ticketList.remove(row);
		fireTableRowsDeleted(row, row);
	}
}
