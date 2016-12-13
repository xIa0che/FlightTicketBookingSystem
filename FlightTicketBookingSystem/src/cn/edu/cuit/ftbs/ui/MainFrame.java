package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.util.JImagePane;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 程序主界面
 *
 * @author xIa0che
 *
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -3455978589878253469L;
	private FlightQueryFrame flightQueryFrame = null;
	private JPanel contentPane;
	private UserInfoFrame userInfoFrame = null;
	private RefundChangeFrame refundChangeFrame = null;
	private AdminLoginFrame adminLoginFrame = null;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { MainFrame frame = new MainFrame();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * }); }
	 */

	/**
	 * Create the frame.
	 */
	public MainFrame(Customer customer) {
		this.userInfoFrame = new UserInfoFrame(customer);
		this.flightQueryFrame = new FlightQueryFrame(customer);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		Image iamge =
				new ImageIcon(LoginFrame.class.getResource("/cn/edu/cuit/ftbs/resource/giphy.gif")).getImage();
		JImagePane imagePane = new JImagePane(iamge, JImagePane.SCALED);
		contentPane.add(imagePane);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JLabel label = new JLabel("机票预订系统");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(label, BorderLayout.NORTH);
		label.setFont(new Font("微软雅黑", Font.PLAIN, 40));

		Component verticalStrut = Box.createVerticalStrut(130);
		panel_1.add(verticalStrut, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("Flight Tickets Booking System");
		lblNewLabel.setFont(new Font("微软雅黑", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel, BorderLayout.CENTER);

		JPanel panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel.add(panel_2);

		JButton btnNewButton = new JButton("个人信息");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				userInfoFrame.setVisible(true);
			}
		});

		JButton btnNewButton_1 = new JButton("退票改签");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refundChangeFrame = new RefundChangeFrame(customer);
				refundChangeFrame.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("系统管理");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminLoginFrame = new AdminLoginFrame();
				adminLoginFrame.setVisible(true);
			}
		});

		JButton btnNewButton_3 = new JButton("查询预订");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flightQueryFrame.setVisible(true);
			}
		});

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup().addGap(30)
						.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(btnNewButton_2)
										.addPreferredGap(ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
										.addComponent(btnNewButton_1))
								.addGroup(gl_panel_2.createSequentialGroup().addComponent(btnNewButton)
										.addPreferredGap(ComponentPlacement.RELATED, 548, Short.MAX_VALUE)
										.addComponent(btnNewButton_3)))
						.addContainerGap()));
		gl_panel_2
				.setVerticalGroup(
						gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup().addGap(89)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNewButton).addComponent(btnNewButton_3))
										.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
										.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
												.addComponent(btnNewButton_2).addComponent(btnNewButton_1))
										.addGap(40)));
		panel_2.setLayout(gl_panel_2);

		imagePane.add(panel);
	}
}
