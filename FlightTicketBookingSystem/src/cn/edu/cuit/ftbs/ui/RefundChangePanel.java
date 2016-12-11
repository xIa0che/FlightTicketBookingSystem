package cn.edu.cuit.ftbs.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

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
import java.util.List;
import java.awt.event.ActionEvent;

public class RefundChangePanel extends JPanel {
	private JTable table;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Customer customer;
	private ITicketService ticketService = new TicketServicelmpl();
	private IFlightService flightService = new FlightServiceImpl();

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

		RefundChangeTableModel refundChangeTableModel =
				new RefundChangeTableModel(ticketService.queryTicket(customer.getUsername()));
		table.setModel(refundChangeTableModel);

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

		Component horizontalStrut_1 = Box.createHorizontalStrut(100);
		panel_2.add(horizontalStrut_1);

		JRadioButton changeRadioButton = new JRadioButton("改签");
		buttonGroup.add(changeRadioButton);


		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (refundRadioButton.isSelected()) {
					ticketService.deleteTicket(customer.getUsername());
				}else if (changeRadioButton.isSelected()){
					Ticket ticket =
							ticketService.queryTicket(customer.getUsername());
					List<Flight> flightList =
							flightService.queryFlightByAirline(ticket.getFlightInfo().getAirline());
					FlightDisplayFrame flightDisplayFrame = new FlightDisplayFrame(flightList);
					flightDisplayFrame.setVisible(true);
				}
			}
		});

		panel_2.add(changeRadioButton);

	}

}
