package cn.edu.cuit.ftbs.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.sun.org.apache.bcel.internal.generic.NEW;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.IFlightService;
import cn.edu.cuit.ftbs.service.ITicketService;
import cn.edu.cuit.ftbs.service.impl.FlightServiceImpl;
import cn.edu.cuit.ftbs.service.impl.TicketServicelmpl;

import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RefundChangePanel extends JPanel {
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Customer customer;
	private ITicketService ticketService = new TicketServicelmpl();
	private IFlightService flightService = new FlightServiceImpl();
	private List<Ticket> ticketList = null;
	private JTextField changeTextField;

	/**
	 * Create the panel.
	 */
	public RefundChangePanel(Customer customer) {
		this.customer = customer;

		setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.setRowHeight(50);
		table.setShowVerticalLines(false);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setSelectionBackground(new Color(64, 181, 226));
		table.setGridColor(new Color(64, 181, 226));
		table.setBackground(new Color(240, 250, 253));
		table.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(64, 181, 226)));
		table.setFont(new Font("宋体", Font.PLAIN, 19));

		/*	table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		)); */

		ticketList = ticketService.queryTicket(customer.getUsername());
		RefundChangeTableModel refundChangeTableModel =
				new RefundChangeTableModel(ticketList);
		table.setModel(refundChangeTableModel);

		TableColumn column0 = table.getColumnModel().getColumn(0);
		column0.setPreferredWidth(145);
		TableColumn column1 = table.getColumnModel().getColumn(1);
		column1.setPreferredWidth(115);
		TableColumn column3 = table.getColumnModel().getColumn(3);
		column3.setPreferredWidth(160);
		TableColumn column4 = table.getColumnModel().getColumn(4);
		column4.setPreferredWidth(40);
		TableColumn column5 = table.getColumnModel().getColumn(5);
		column5.setPreferredWidth(50);
		TableColumn column6 = table.getColumnModel().getColumn(6);
		column6.setPreferredWidth(50);
		TableColumn column8 = table.getColumnModel().getColumn(8);
		column8.setPreferredWidth(110);
		TableColumn column9 = table.getColumnModel().getColumn(9);
		column9.setPreferredWidth(100);


		scrollPane.setViewportView(table);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);

		Component horizontalStrut = Box.createHorizontalStrut(500);
		panel_1.add(horizontalStrut);

		JButton button = new JButton("");

		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setIcon(new ImageIcon(RefundChangePanel.class.getResource("/cn/edu/cuit/ftbs/resource/nextStep.PNG")));
		panel_1.add(button);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);

		JRadioButton refundRadioButton = new JRadioButton("退票");
		buttonGroup.add(refundRadioButton);
		panel_2.add(refundRadioButton);

		Component horizontalStrut_1 = Box.createHorizontalStrut(60);
		panel_2.add(horizontalStrut_1);

		JRadioButton changeRadioButton = new JRadioButton("改签");
		buttonGroup.add(changeRadioButton);

		panel_2.add(changeRadioButton);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_2.add(horizontalStrut_2);

		JLabel label = new JLabel("改签日期：");
		panel_2.add(label);

		changeTextField = new JTextField();
		panel_2.add(changeTextField);
		changeTextField.setColumns(8);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = table.getSelectedRow();
				Ticket ticket = ticketList.get(index);
				if (refundRadioButton.isSelected()) {
					if (ticketService.deleteTicket(ticket.getTicketNum())){
						JOptionPane.showMessageDialog(null, "退票成功", null, JOptionPane.INFORMATION_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "退票失败", null, JOptionPane.ERROR_MESSAGE);
					}
					return;
				}else if (changeRadioButton.isSelected()){
					Flight flight = ticket.getFlightInfo();
					String departureCity = flight.getDepartureCity();
					String arrivalCity = flight.getArrivalCity();
					String departureDateString = changeTextField.getText();
					SimpleDateFormat df = new SimpleDateFormat("yy-MM-dd");
					Date departureTime = null;
					try {
						departureTime = df.parse(departureDateString);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					String airline = flight.getAirline();
					List<Flight> flightList =
							flightService.queryFlight(departureCity, arrivalCity, departureTime, airline);
					//ticketService.deleteTicket(ticket.getTicketNum());
					FlightDisplayFrame flightDisplayFrame = new FlightDisplayFrame(flightList, customer);
					flightDisplayFrame.setVisible(true);
				}
			}
		});

	}

}
