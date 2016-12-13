package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;

import cn.edu.cuit.ftbs.entity.Customer;

/**
 * 航班查询Frame
 * @author xIa0che
 *
 */
public class FlightQueryFrame extends JFrame {

	private static final long serialVersionUID = -3925199921216372331L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlightQueryFrame frame = new FlightQueryFrame();
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
	public FlightQueryFrame(Customer customer) {
		setBounds(100, 100, 678, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(new FlightQueryPanel(this, customer), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(5, 6, 0, 6, (Color) new Color(0, 175, 199)));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FlightQueryFrame.class.getResource("/cn/edu/cuit/ftbs/resource/first-active-air.gif")));

		JLabel lblNewLabel_1 = new JLabel("查询搜索");

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FlightQueryFrame.class.getResource("/cn/edu/cuit/ftbs/resource/default-before (1).gif")));

		JLabel lblNewLabel_2 = new JLabel("航班选择");

		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FlightQueryFrame.class.getResource("/cn/edu/cuit/ftbs/resource/last-before.gif")));

		JLabel lblNewLabel_4 = new JLabel("预订完成");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(114, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(67))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(49)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(35)
							.addComponent(lblNewLabel_2))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(102)
							.addComponent(lblNewLabel_4))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(84)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)))
					.addGap(133))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(label)
						.addComponent(lblNewLabel))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
}
