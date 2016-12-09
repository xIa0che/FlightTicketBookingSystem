package cn.edu.cuit.ftbs.ui;



import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
public class AdminLoginFrame extends JFrame{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPasswordField passwordField;
	private LoginPanel loginpanel = new LoginPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminLoginFrame frame = new AdminLoginFrame();
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
	public AdminLoginFrame() {
		setResizable(false);
		setTitle("管理员登录");
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

		JLabel label = new JLabel("密码：");
		label.setBounds(113, 138, 43, 15);
		loginpanel.add(label);
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 135, 125, 21);
		loginpanel.add(passwordField);

		JButton button_2 = new JButton("重置登陆");
		button_2.setBounds(301, 134, 93, 22);
		loginpanel.add(button_2);
		button_2.setBackground(new Color(204, 255, 255));

		JButton exitButton = new JButton("退出");
		exitButton.setBounds(244, 175, 62, 21);
		loginpanel.add(exitButton);
		exitButton.setBackground(new Color(204, 255, 255));
		JButton loginbutton = new JButton("登陆");
		loginbutton.setBounds(153, 175, 62, 21);
		loginpanel.add(loginbutton);


		loginbutton.setBackground(new Color(204, 255, 255));
		loginbutton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String password = new String(passwordField.getPassword());

				if(password.equals("")){
					JOptionPane.showMessageDialog(AdminLoginFrame.this, "请输入密码！","登陆失败",JOptionPane.ERROR_MESSAGE);
					return;
				}else if(!password.equals("admin")){
					JOptionPane.showMessageDialog(AdminLoginFrame.this, "密码不正确！","登陆失败",JOptionPane.ERROR_MESSAGE);
					return;
				}
				setVisible(false);//关闭登陆窗
				//TODO 调用管理员面板
			}

		});
		exitButton.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int choice = JOptionPane.showConfirmDialog(AdminLoginFrame.this, "确定要退出吗？","提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(choice == 0){
					System.exit(0);
				}
			}
		});
		button_2.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				passwordField.setText("");
				passwordField.requestFocus();

			}});
		passwordField.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				if(e.getKeyChar() == '\n'){
					loginbutton.doClick();
				}
			}
		});
	}



}
