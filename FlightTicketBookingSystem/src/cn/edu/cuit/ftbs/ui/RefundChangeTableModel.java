package cn.edu.cuit.ftbs.ui;

import java.util.List;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.entity.Ticket;

public class RefundChangeTableModel implements TableModel{
	private List<Ticket> ticketList;
	private String[] columnName = {"机票编号",
								   "航班",
								   "航空公司",
								   "机型",
								   "出发城市",
								   "到达城市",
								   "出发时间",
								   "到达时间",
								   "舱位价格"};


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
		switch (columnIndex) {
		case 0:
			return ticket.getTicketNum();
		case 1:
			return flight.getFlightNum();
		case 2:
			return flight.getAirline();
		case 3:
			return flight.getPlaneType();
		case 4:
			return flight.getDepatureCity();
		case 5:
			return flight.getArrivalCity();
		case 6:
			return flight.getDepartureTime();
		case 7:
			return flight.getArrivalTime();
		case 8:
			int price = 0;
			if (ticket.getSeatClass().equals("头等舱")){
				price = flight.getFirstClassCabinPrice();
			}else if (ticket.getSeatClass().equals("公务舱")) {
				price = flight.getBusinessClassCabinPrice();
			}else {
				price = flight.getEconomyClassCabinPrice();
			}
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

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

	}

	@Override
	public void addTableModelListener(TableModelListener l) {

	}

	@Override
	public void removeTableModelListener(TableModelListener l) {

	}

}
