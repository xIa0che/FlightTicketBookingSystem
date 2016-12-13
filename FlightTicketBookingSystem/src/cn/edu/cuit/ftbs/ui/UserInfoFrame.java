package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.entity.Customer;
import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;

/**
 * UserinfoFrame类实现用户信息显示窗体，并可在窗体中修改用户信息
 *
 * @author 陈星
 */
public class UserInfoFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField realnameTextField;
	private JTextField telTextField;
	private JTextField emailTextField;
	private JTextField idcardTextField;
	private JTextField addressTextField;
	private JPasswordField passwordField2;
	private JPasswordField passwordField1;
	private Customer customer = new Customer();
	private ICustomerService cs = new CustomerServiceImpl();

	/**
	 * Create the frame.
	 */
	public UserInfoFrame(Customer cus) {
		customer = cus;
		setResizable(false);
		setTitle(customer.getUsername());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 436);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel passwordLabel1 = new JLabel("修改密码：");
		passwordLabel1.setBounds(88, 269, 73, 15);
		panel.add(passwordLabel1);

		JLabel passwordLabel2 = new JLabel("确认密码：");
		passwordLabel2.setBounds(340, 269, 73, 15);
		panel.add(passwordLabel2);

		JLabel realnameLabel = new JLabel("真实姓名：");
		realnameLabel.setBounds(88, 92, 73, 15);
		panel.add(realnameLabel);

		realnameTextField = new JTextField(customer.getName());
		realnameTextField.setBounds(171, 89, 138, 21);
		panel.add(realnameTextField);
		realnameTextField.setColumns(10);

		JLabel telLabel = new JLabel("电话号码：");
		telLabel.setBounds(88, 135, 73, 15);
		panel.add(telLabel);

		telTextField = new JTextField(customer.getTelephone());
		telTextField.setBounds(171, 132, 138, 21);
		panel.add(telTextField);
		telTextField.setColumns(10);

		JLabel emailLabel = new JLabel("邮         箱：");
		emailLabel.setBounds(88, 181, 73, 15);
		panel.add(emailLabel);

		emailTextField = new JTextField(customer.geteMail());
		emailTextField.setBounds(171, 178, 138, 21);
		panel.add(emailTextField);
		emailTextField.setColumns(10);

		JLabel sexLabel = new JLabel("性         别：");
		sexLabel.setBounds(340, 92, 73, 15);
		panel.add(sexLabel);

		JRadioButton manRadioButton = new JRadioButton("男");
		manRadioButton.setSelected(true);

		manRadioButton.setBounds(446, 88, 48, 23);
		manRadioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				customer.setSex(e.getActionCommand());
			}
		});
		panel.add(manRadioButton);

		JRadioButton womanRadioButton = new JRadioButton("女");
		womanRadioButton.setBounds(496, 88, 48, 23);
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
		if (customer.getSex().equals("男")) {
			manRadioButton.setSelected(true);
		} else {
			womanRadioButton.setSelected(true);
		}

		JLabel idcardLabel = new JLabel("身份证号：");
		idcardLabel.setBounds(340, 135, 73, 15);
		panel.add(idcardLabel);

		idcardTextField = new JTextField(customer.getIdCardNumber());
		idcardTextField.setBounds(423, 132, 138, 21);
		panel.add(idcardTextField);
		idcardTextField.setColumns(10);

		JLabel addressLabel = new JLabel("地         址：");
		addressLabel.setBounds(88, 226, 73, 15);
		panel.add(addressLabel);

		addressTextField = new JTextField(customer.getAddress());
		addressTextField.setBounds(171, 223, 390, 21);
		panel.add(addressTextField);
		addressTextField.setColumns(10);

		passwordField2 = new JPasswordField(customer.getPassword());
		passwordField2.setBounds(423, 266, 138, 21);
		panel.add(passwordField2);

		passwordField1 = new JPasswordField(customer.getPassword());
		passwordField1.setBounds(171, 266, 138, 21);
		panel.add(passwordField1);

		JButton button1 = new JButton("确认");
		button1.setBounds(240, 332, 93, 23);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String temp;
				String password1 = new String(passwordField1.getPassword());
				String password2 = new String(passwordField2.getPassword());
				if (password1.equals("") || password2.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "密码不能为空！请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					if (password1.equals(password2)) {
						customer.setPassword(password1);
					} else {
						JOptionPane.showMessageDialog(UserInfoFrame.this, "两次输入密码不一致！请重新输入！", "警告",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
				temp = realnameTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "真实姓名不能为空！请重新输入！", "警告",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setName(temp);
				}
				temp = customer.getSex();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "请选择性别！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				}
				temp = telTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "电话号码不能为空！请重新输入！", "警告",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setTelephone(temp);
				}
				temp = idcardTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "身份证号不能为空！请重新输入！", "警告",
							JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setIdCardNumber(temp);
				}
				temp = emailTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "邮箱不能为空！请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.seteMail(temp);
				}
				temp = addressTextField.getText();
				if (temp.equals("")) {
					JOptionPane.showMessageDialog(UserInfoFrame.this, "地址不能为空！请重新输入！", "警告", JOptionPane.ERROR_MESSAGE);
					return;
				} else {
					customer.setAddress(temp);
				}

				try {
					if (!cs.updateCustomer(customer)) {
						JOptionPane.showMessageDialog(UserInfoFrame.this, "修改失败！", "警告", JOptionPane.ERROR_MESSAGE);
						return;
					}

				} catch (Exception e1) {

					e1.printStackTrace();
				}
				setVisible(false);// 关闭信息窗
			}
		});
		panel.add(button1);

		JButton button2 = new JButton("取消");
		button2.setBounds(360, 332, 93, 23);
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);// 关闭信息窗
			}
		});
		panel.add(button2);
	}
}
