package cn.edu.cuit.ftbs.ui;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.IFlightService;
import cn.edu.cuit.ftbs.service.impl.FlightServiceImpl;
import cn.edu.cuit.ftbs.util.DateChooser;
import cn.edu.cuit.ftbs.util.JTextFieldWithIcon;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FlightQueryPanel extends JPanel {
	private IFlightService iFlightService = new FlightServiceImpl();

	private JTextField departureCitytextField;
	private JTextField arrivalCitytextField;
	private JTextFieldWithIcon departureTimeTextField;
	private JTextFieldWithIcon returnDateTextField;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the panel.
	 */
	public FlightQueryPanel(JFrame flightQueryFrame) {
		setOpaque(false);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 175, 199), 6));
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(null);

		JLabel flightIconlabel = new JLabel("");
		flightIconlabel.setIcon(
				new ImageIcon(FlightQueryPanel.class.getResource("/cn/edu/cuit/ftbs/resource/flight_logo.png")));
		flightIconlabel.setBounds(22, 10, 34, 36);
		panel.add(flightIconlabel);

		JLabel flightQueryLabel = new JLabel("机票查询");
		flightQueryLabel.setFont(new Font("微软雅黑", Font.PLAIN, 23));
		flightQueryLabel.setBounds(61, 10, 92, 31);
		panel.add(flightQueryLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 251, 253));
		panel_1.setBounds(22, 64, 576, 240);
		panel.add(panel_1);
		panel_1.setLayout(null);

		JRadioButton oneWayradioButton = new JRadioButton("单程");

		oneWayradioButton.setSelected(true);
		buttonGroup.add(oneWayradioButton);
		oneWayradioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		oneWayradioButton.setOpaque(false);
		oneWayradioButton.setBounds(126, 30, 53, 25);
		panel_1.add(oneWayradioButton);

		JRadioButton roundTripradioButton = new JRadioButton("往返");
		roundTripradioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1){
					returnDateTextField.setEnabled(true);
				}
			}
		});


		buttonGroup.add(roundTripradioButton);
		roundTripradioButton.setFont(new Font("宋体", Font.PLAIN, 14));
		roundTripradioButton.setOpaque(false);
		roundTripradioButton.setBounds(201, 30, 53, 25);
		panel_1.add(roundTripradioButton);

		departureCitytextField = new JTextField();
		departureCitytextField.setBounds(108, 81, 167, 21);
		panel_1.add(departureCitytextField);
		departureCitytextField.setColumns(10);

		arrivalCitytextField = new JTextField();
		arrivalCitytextField.setBounds(108, 141, 167, 21);
		panel_1.add(arrivalCitytextField);
		arrivalCitytextField.setColumns(10);

		JLabel departureTimelabel = new JLabel("出发日期");
		departureTimelabel.setFont(new Font("宋体", Font.PLAIN, 14));
		departureTimelabel.setBounds(310, 83, 56, 16);
		panel_1.add(departureTimelabel);

		DateChooser dateChooser = DateChooser.getInstance();
		departureTimeTextField = new JTextFieldWithIcon("/cn/edu/cuit/ftbs/resource/calendar.png");
		departureTimeTextField.setBounds(387, 81, 167, 21);
		departureTimeTextField.setColumns(10);
		dateChooser.register(departureTimeTextField);
		panel_1.add(departureTimeTextField);

		JLabel lblNewLabel_1 = new JLabel("返回日期");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(310, 143, 56, 16);
		panel_1.add(lblNewLabel_1);

		DateChooser dateChooser2 = DateChooser.getInstance();
		returnDateTextField = new JTextFieldWithIcon("/cn/edu/cuit/ftbs/resource/calendar.png");
		returnDateTextField.setBounds(387, 141, 167, 21);
		returnDateTextField.setColumns(10);

		returnDateTextField.setEnabled(false);

		oneWayradioButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == 1){
					returnDateTextField.setEnabled(false);
				}
			}
		});

		dateChooser2.register(returnDateTextField);
		panel_1.add(returnDateTextField);

		Box verticalBox = Box.createVerticalBox();
		verticalBox.setBounds(20, 30, 60, 144);
		panel_1.add(verticalBox);

		JLabel label = new JLabel("航程类型");
		verticalBox.add(label);
		label.setFont(new Font("宋体", Font.PLAIN, 14));

		Component verticalStrut = Box.createVerticalStrut(35);
		verticalBox.add(verticalStrut);

		JLabel departureCitylabel = new JLabel("出发城市");
		verticalBox.add(departureCitylabel);
		departureCitylabel.setFont(new Font("宋体", Font.PLAIN, 14));

		Component verticalStrut_1 = Box.createVerticalStrut(43);
		verticalBox.add(verticalStrut_1);

		JLabel arrivalCitylabel = new JLabel("到达城市");
		verticalBox.add(arrivalCitylabel);
		arrivalCitylabel.setFont(new Font("宋体", Font.PLAIN, 14));

		JButton bookbutton = new JButton("");
		bookbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String departureCity = departureCitytextField.getText();
				String arrivalCity = arrivalCitytextField.getText();
				String departureTime = departureTimeTextField.getText();
				SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
				Date nowDate = new Date();
				String nowDateString = ft.format(nowDate);
				Date now = null;
				List<Flight> flightList = new ArrayList<Flight>();
				try {
					now = ft.parse(nowDateString);
				} catch (ParseException e3) {
					e3.printStackTrace();
				}
				Date departureDate = null;
				try {
					departureDate = ft.parse(departureTime);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
				if (departureDate.before(now)) {
					JOptionPane.showMessageDialog(null, "请选择正确的日期", "日期错误", JOptionPane.ERROR_MESSAGE);
					return;
				}
				flightList.addAll(iFlightService.queryFlight(departureCity, arrivalCity, departureDate));
				if (roundTripradioButton.isSelected()) {
					String returnTime = returnDateTextField.getText();
					Date returnDate = null;
					try {
						returnDate = ft.parse(returnTime);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (returnDate.before(departureDate)) {
						JOptionPane.showMessageDialog(null, "请选择正确的日期", "日期错误", JOptionPane.ERROR_MESSAGE);
						return;
					}
					flightList.addAll(iFlightService.queryFlight(arrivalCity, departureCity, departureDate));
				}
				FlightDisplayFrame flightDisplayFrame = new FlightDisplayFrame(flightList);
				flightDisplayFrame.setVisible(true);
				flightQueryFrame.setVisible(false);
			}
		});
		bookbutton.setBorderPainted(false);
		bookbutton.setBorder(null);
		bookbutton.setIcon(new ImageIcon(FlightQueryPanel.class.getResource("/cn/edu/cuit/ftbs/resource/an_book.gif")));
		bookbutton.setBounds(465, 188, 89, 29);
		panel_1.add(bookbutton);

	}
}
