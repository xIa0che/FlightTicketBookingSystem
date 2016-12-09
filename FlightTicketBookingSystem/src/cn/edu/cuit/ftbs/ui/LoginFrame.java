package cn.edu.cuit.ftbs.ui;



import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.service.ICustomerService;
import cn.edu.cuit.ftbs.service.impl.CustomerServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

/**
 * LoginFrame类实现登录窗体
 * @author 陈星
 */
public class LoginFrame extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private AdminLoginPanel loginpanel = new AdminLoginPanel();
	private ICustomerService cs = new CustomerServiceImpl();
	private RegisterFrame register = new RegisterFrame(this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setTitle("系统登录");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		loginpanel.setBounds(0, 0, 420, 248);
		loginpanel.setBackground(new Color(0xD8DDC7));
		loginpanel.setOpaque(false);

		contentPane.add(loginpanel);
		loginpanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("用户名：");
		loginpanel.add(lblNewLabel);
		lblNewLabel.setBounds(109, 132, 54, 15);

		JLabel label = new JLabel("密    码：");
		loginpanel.add(label);
		label.setBounds(109, 174, 54, 15);

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(e.getKeyChar() == '\n'){
					passwordField.requestFocus();
				}
			}
		});
		loginpanel.add(textField);
		textField.setBounds(157, 129, 125, 21);
		textField.setColumns(10);

		JButton loginbutton = new JButton("登陆");
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(e.getKeyChar() == '\n'){
					loginbutton.doClick();
				}
			}
		});
		loginpanel.add(passwordField);
		passwordField.setBounds(157, 171, 125, 21);


		loginbutton.setBackground(new Color(204, 255, 255));
		loginbutton.setBounds(157, 214, 62, 21);
		loginbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String username = textField.getText();
				String password = new String(passwordField.getPassword());
				if(username.equals("")){
					JOptionPane.showMessageDialog(LoginFrame.this, "请输入用户名！","登陆失败",JOptionPane.ERROR_MESSAGE);
					return;
				}else if(password.equals("")){
					JOptionPane.showMessageDialog(LoginFrame.this, "请输入密码！","登陆失败",JOptionPane.ERROR_MESSAGE);
					return;
				}else{
					try {
					if(!cs.login(username, password)){
						JOptionPane.showMessageDialog(LoginFrame.this, "用户名或密码不正确！","登陆失败",JOptionPane.ERROR_MESSAGE);
						return;
					}
				} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
				setVisible(false);//关闭登陆窗
				//mainFrame.setVisible(true);//显示主窗体
			}

		});
		loginpanel.add(loginbutton);

		JButton button_1 = new JButton("注册用户");
		button_1.setBackground(new Color(204, 255, 255));
		loginpanel.add(button_1);
		button_1.setBounds(292, 128, 93, 22);
		button_1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);//关闭登陆窗
				register.setVisible(true);
			}
		});

		JButton button_2 = new JButton("重置密码");
		button_2.setBackground(new Color(204, 255, 255));
		loginpanel.add(button_2);
		button_2.setBounds(292, 170, 93, 22);
		button_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setText("");
				passwordField.requestFocus();

			}});

		JButton exitButton = new JButton("退出");
		exitButton.setBackground(new Color(204, 255, 255));
		loginpanel.add(exitButton);
		exitButton.setBounds(220, 214, 62, 21);
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(LoginFrame.this, "确定要退出吗？","提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(choice == 0){
					System.exit(0);
				}
			}
		});
	}



}
