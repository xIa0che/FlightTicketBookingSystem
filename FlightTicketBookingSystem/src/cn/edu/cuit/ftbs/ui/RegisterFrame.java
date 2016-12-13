package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JButton;

/**
 * RegisterFrame类实现注册窗体
 *
 * @author 陈星
 */
public class RegisterFrame extends JFrame {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTextField;
	private JTextField realnameTextField;
	private JTextField telTextField;
	private JTextField emailTextField;
	private JTextField idcardTextField;
	private JTextField addressTextField;
	private JPasswordField passwordField2;
	private JPasswordField passwordField1;
	private Customer customer = new Customer();
	private ICustomerService cs = new CustomerServiceImpl();
	private MainFrame mainFrame;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { RegisterFrame frame = new
	 * RegisterFrame(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */
	/**
	 * Create the frame.
	 */
	public RegisterFrame(LoginFrame loginFrame) {
		setResizable(false);
		setTitle("用户注册");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel usernameLabel = new JLabel("用  户  名：");
		usernameLabel.setBounds(88, 39, 73, 15);
		panel.add(usernameLabel);

		usernameTextField = new JTextField();
		usernameTextField.setBounds(171, 36, 138, 21);
		panel.add(usernameTextField);
		usernameTextField.setColumns(10);

		JLabel passwordLabel1 = new JLabel("输入密码：");
		passwordLabel1.setBounds(88, 70, 73, 15);
		panel.add(passwordLabel1);

		JLabel passwordLabel2 = new JLabel("确认密码：");
		passwordLabel2.setBounds(88, 101, 73, 15);
		panel.add(passwordLabel2);

		JLabel realnameLabel = new JLabel("真实姓名：");
		realnameLabel.setBounds(88, 132, 73, 15);
		panel.add(realnameLabel);

		realnameTextField = new JTextField();
		realnameTextField.setBounds(171, 129, 138, 21);
		panel.add(realnameTextField);
		realnameTextField.setColumns(10);

		JLabel telLabel = new JLabel("电话号码：");
		telLabel.setBounds(88, 190, 73, 15);
		panel.add(telLabel);

		telTextField = new JTextField();
		telTextField.setBounds(171, 187, 138, 21);
		panel.add(telTextField);
		telTextField.setColumns(10);

		JLabel emailLabel = new JLabel("邮         箱：");
		emailLabel.setBounds(88, 260, 73, 15);
		panel.add(emailLabel);

		emailTextField = new JTextField();
		emailTextField.setBounds(171, 257, 138, 21);
		panel.add(emailTextField);
		emailTextField.setColumns(10);

		JLabel sexLabel = new JLabel("性         别：");
		sexLabel.setBounds(88, 165, 73, 15);
		panel.add(sexLabel);

		JRadioButton manRadioButton = new JRadioButton("男");
		manRadioButton.setBounds(181, 158, 48, 23);
		manRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				customer.setSex(e.getActionCommand());
			}
		});
		panel.add(manRadioButton);

		JRadioButton womanRadioButton = new JRadioButton("女");
		womanRadioButton.setBounds(261, 158, 48, 23);
		womanRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customer.setSex(e.getActionCommand());
			}
		});
		panel.add(womanRadioButton);
		ButtonGroup group = new ButtonGroup();
		group.add(womanRadioButton);
		group.add(manRadioButton);

		JLabel idcardLabel = new JLabel("身份证号：");
		idcardLabel.setBounds(88, 224, 73, 15);
		panel.add(idcardLabel);

		idcardTextField = new JTextField();
		idcardTextField.setBounds(171, 221, 138, 21);
		panel.add(idcardTextField);
		idcardTextField.setColumns(10);

		JLabel addressLabel = new JLabel("地         址：");
		addressLabel.setBounds(88, 289, 73, 15);
		panel.add(addressLabel);

		addressTextField = new JTextField();
		addressTextField.setBounds(171, 288, 186, 21);
		panel.add(addressTextField);
		addressTextField.setColumns(10);

		passwordField2 = new JPasswordField();
		passwordField2.setBounds(171, 98, 138, 21);
		panel.add(passwordField2);

		passwordField1 = new JPasswordField();
		passwordField1.setBounds(171, 67, 138, 21);
		panel.add(passwordField1);

		JButton button1 = new JButton("提交");
		button1.setBounds(136, 333, 93, 23);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String temp;
				String password1 = new String(passwordField1.getPassword());
				String password2 = new String(passwordField2.getPassword());
				temp = usernameTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "用户名不能为空！请输入用户名！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					try {
						if (cs.qureyCustomer(temp) == null) {
							customer.setUsername(temp);
						} else {
							JOptionPane.showMessageDialog(RegisterFrame.this, "用户名已存在！", "注册失败",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				if (password1.equals("") || password2.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "密码不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if (password1.equals(password2)) {
						customer.setPassword(password1);
					} else {
						JOptionPane.showMessageDialog(RegisterFrame.this, "两次输入密码不一致！请重新输入！", "注册失败",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				temp = realnameTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "真实姓名不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setName(temp);
				}
				temp = customer.getSex();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "请选择性别！", "注册失败", JOptionPane.ERROR_MESSAGE);
					return;
				}
				temp = telTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "电话号码不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setTelephone(temp);
				}
				temp = idcardTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "省份证号不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setIdCardNumber(temp);
				}
				temp = emailTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "邮箱不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.seteMail(temp);
				}
				temp = addressTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(RegisterFrame.this, "地址不能为空！请重新输入！", "注册失败",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setAddress(temp);
				}

				try {
					if (!cs.register(customer)) {
						JOptionPane.showMessageDialog(RegisterFrame.this, "注册出错！", "注册失败", JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				setVisible(false);// 关闭登陆窗
				mainFrame = new MainFrame(customer);
				mainFrame.setVisible(true);
			}
		});
		panel.add(button1);

		JButton button2 = new JButton("取消");
		button2.setBounds(239, 333, 93, 23);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);// 关闭注册窗
				loginFrame.setVisible(true);
			}
		});
		panel.add(button2);
	}
}
