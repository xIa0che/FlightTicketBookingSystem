package cn.edu.cuit.ftbs.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.border.EmptyBorder;
import cn.edu.cuit.ftbs.entity.Flight;
import cn.edu.cuit.ftbs.service.impl.FlightServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
/**
 * AdministratoFrame类实现管理航班窗体
 * @author 张玉乾
 */
public class AdministratoFrame extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private FlightServiceImpl ifs = new FlightServiceImpl();
	private Flight flight = new Flight();


	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdministratoFrame frame = new AdministratoFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AdministratoFrame() {
		setBounds(100, 100, 610, 442);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("航空公司：");
		lblNewLabel_1.setBounds(70, 27, 70, 15);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(138, 24, 120, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel label = new JLabel("航班号码：");
		label.setBounds(347, 27, 66, 15);
		contentPane.add(label);

		textField_1 = new JTextField();
		textField_1.setBounds(415, 24, 120, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel = new JLabel("飞机类型：");
		lblNewLabel.setBounds(70, 65, 66, 15);
		contentPane.add(lblNewLabel);

		textField_2 = new JTextField();
		textField_2.setBounds(138, 62, 120, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);

		JLabel lblId = new JLabel("航班ID：");
		lblId.setBounds(359, 65, 54, 15);
		contentPane.add(lblId);

		textField_3 = new JTextField();
		textField_3.setBounds(415, 62, 120, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("出发城市：");
		lblNewLabel_4.setBounds(70, 100, 84, 15);
		contentPane.add(lblNewLabel_4);

		textField_4 = new JTextField();
		textField_4.setBounds(138, 97, 120, 21);
		contentPane.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("出发时间：");
		lblNewLabel_5.setBounds(347, 100, 93, 15);
		contentPane.add(lblNewLabel_5);

		textField_5 = new JTextField();
		textField_5.setBounds(415, 97, 120, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("到达城市：");
		lblNewLabel_2.setBounds(70, 144, 84, 15);
		contentPane.add(lblNewLabel_2);

		textField_6 = new JTextField();
		textField_6.setBounds(138, 141, 120, 21);
		contentPane.add(textField_6);
		textField_6.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("到达时间：");
		lblNewLabel_3.setBounds(347, 144, 85, 15);
		contentPane.add(lblNewLabel_3);

		textField_7 = new JTextField();
		textField_7.setBounds(415, 141, 120, 21);
		contentPane.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("头等舱价格：");
		lblNewLabel_6.setBounds(60, 189, 94, 15);
		contentPane.add(lblNewLabel_6);

		textField_8 = new JTextField();
		textField_8.setBounds(138, 186, 120, 21);
		contentPane.add(textField_8);
		textField_8.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("商务舱价格：");
		lblNewLabel_7.setBounds(60, 225, 113, 15);
		contentPane.add(lblNewLabel_7);

		textField_9 = new JTextField();
		textField_9.setBounds(138, 222, 120, 21);
		contentPane.add(textField_9);
		textField_9.setColumns(10);

		JLabel lblNewLabel_8 = new JLabel("经济舱价格：");
		lblNewLabel_8.setBounds(59, 266, 81, 15);
		contentPane.add(lblNewLabel_8);

		textField_10 = new JTextField();
		textField_10.setBounds(138, 263, 120, 21);
		contentPane.add(textField_10);
		textField_10.setColumns(10);

		JButton btnNewButton = new JButton("修改航班");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flight.setId(textField_3.getText());
				flight.setFlightNum(textField_1.getText());
				flight.setAirline(textField.getText());
				flight.setPlaneType(textField_2.getText());
				flight.setDepartureCity(textField_4.getText());
				flight.setArrivalCity(textField_6.getText());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:hh");
				try {
					flight.setDepartureTime(sdf.parse(textField_5.getText()));
					flight.setArrivalTime(sdf.parse(textField_7.getText()));
					JOptionPane.showMessageDialog(null, "航班信息修改成功");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				flight.setFirstClassCabinPrice(Integer.valueOf(textField_8.getText()));
				flight.setBusinessClassCabinPrice(Integer.valueOf(textField_9.getText()));
				flight.setEconomyClassCabinPrice(Integer.valueOf(textField_10.getText()));
				ifs.updateFlight(flight);
			}
		});
		btnNewButton.setBounds(138, 325, 93, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("增加航班");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flight.setId(textField_3.getText());
				flight.setFlightNum(textField_1.getText());
				flight.setAirline(textField.getText());
				flight.setPlaneType(textField_2.getText());
				flight.setDepartureCity(textField_4.getText());
				flight.setArrivalCity(textField_6.getText());
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				try {
					flight.setDepartureTime(sdf.parse(textField_5.getText()));
					flight.setArrivalTime(sdf.parse(textField_7.getText()));
					JOptionPane.showMessageDialog(null, "航班信息增加成功");
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				flight.setFirstClassCabinPrice(Integer.valueOf(textField_8.getText()));
				flight.setBusinessClassCabinPrice(Integer.valueOf(textField_9.getText()));
				flight.setEconomyClassCabinPrice(Integer.valueOf(textField_10.getText()));
				ifs.addFlight(flight);
			}
		});
		btnNewButton_1.setBounds(284, 325, 93, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("删除航班");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ifs.deleteFlight(textField_3.getText()))
				JOptionPane.showMessageDialog(null, "航班删除成功");
				else
					JOptionPane.showMessageDialog(null, "航班删除失败");
					
			}

		});
		btnNewButton_2.setBounds(427, 325, 93, 23);
		contentPane.add(btnNewButton_2);

	}
}
