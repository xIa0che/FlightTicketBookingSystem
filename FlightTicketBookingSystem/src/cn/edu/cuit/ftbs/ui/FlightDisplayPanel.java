package cn.edu.cuit.ftbs.ui;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.entity.Ticket;
import cn.edu.cuit.ftbs.service.ITicketService;
import cn.edu.cuit.ftbs.service.impl.TicketServicelmpl;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class FlightDisplayPanel extends JPanel {
	private JTable table;
	private List<Flight> flightList;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Date date = new Date();
	private SimpleDateFormat dataFormat = new SimpleDateFormat("yyyymmdd");
	private String flightNum = dataFormat.format(date);
	private long num = 0;

	/*
	 * private ITicketService iTicketService = new TicketServiceImpl(); private
	 * IOrderService iOrderService = new OrderServiceImpl();
	 */
	/**
	 * Create the panel.
	 */
	public FlightDisplayPanel(List<Flight> flightList) {
		this.flightList = flightList;

		setBackground(Color.WHITE);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();// 设置table内容居中
		tcr.setHorizontalAlignment(SwingConstants.CENTER);
		table.setDefaultRenderer(Object.class, tcr);

		table.setSelectionBackground(new Color(64, 181, 226));
		table.setFont(new Font("宋体", Font.PLAIN, 19));
		table.setRowHeight(50);
		table.setBorder(new MatteBorder(0, 1, 0, 1, (Color) new Color(64, 181, 226)));
		table.setAutoCreateRowSorter(true);
		table.setGridColor(new Color(64, 181, 226));
		table.setShowVerticalLines(false);
		table.setBackground(new Color(240, 250, 253));
		/*
		 * table.setModel(new DefaultTableModel( new Object[][] { {"ca132124",
		 * null, null}, {"ca734513", null, null}, {"ca765379", null, null},
		 * {"ca765379", null, null}, }, new String[] { "New column",
		 * "New column", "New column" } ));
		 */

		FlightDisplayTableModel flightDisplayTableModel = new FlightDisplayTableModel(flightList);
		table.setModel(flightDisplayTableModel);

		scrollPane.setViewportView(table);
		setLayout(new BorderLayout(0, 0));
		add(scrollPane, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel cabinPanel = new JPanel();
		panel.add(cabinPanel, BorderLayout.CENTER);

		JLabel cabinLabel = new JLabel("舱位选择：");
		cabinPanel.add(cabinLabel);

		JRadioButton radioButton1 = new JRadioButton("头等舱");
		buttonGroup.add(radioButton1);
		cabinPanel.add(radioButton1);

		JRadioButton radioButton2 = new JRadioButton("公务舱");
		buttonGroup.add(radioButton2);
		cabinPanel.add(radioButton2);

		JRadioButton radioButton3 = new JRadioButton("经济舱");
		buttonGroup.add(radioButton3);
		cabinPanel.add(radioButton3);

		JPanel buttonPanel = new JPanel();
		panel.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Component horizontalStrut = Box.createHorizontalStrut(500);
		buttonPanel.add(horizontalStrut);

		JButton nextStepButton = new JButton("");
		nextStepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ticket ticket = new Ticket();
				ITicketService iTicketService = new TicketServicelmpl();
				ticket.setFlightInfo(flightList.get(table.getSelectedRow()));
				if (radioButton1.isSelected()) {
					ticket.setSeatClass("头等舱");
				} else if (radioButton2.isSelected()) {
					ticket.setSeatClass("公务舱");
				} else if (radioButton3.isSelected()) {
					ticket.setSeatClass("经济舱");
				}
				num = num + 1;
				flightNum = flightNum + num;
				ticket.setTicketNum(flightNum);
				try {
					iTicketService.addTicket(ticket);
				} catch (Exception e1) {
					//iTicketService异常javadoc
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "机票预订成功", null, JOptionPane.PLAIN_MESSAGE);
			}
		});
		buttonPanel.add(nextStepButton);
		nextStepButton.setBorder(null);
		nextStepButton.setIcon(
				new ImageIcon(FlightDisplayPanel.class.getResource("/cn/edu/cuit/ftbs/resource/nextStep.PNG")));

	}
}
