package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.entity.Flight;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class FlightDisplayFrame extends JFrame {

	private JPanel contentPane;


	/**
	 * Create the frame.
	 */
	public FlightDisplayFrame(List<Flight> flightList) {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(new FlightDisplayPanel(flightList), BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel.add(panel_1);
						panel_1.setLayout(null);

						JLabel lblNewLabel = new JLabel("查询搜索");
						lblNewLabel.setBounds(57, 0, 48, 15);
						panel_1.add(lblNewLabel);

				JLabel label = new JLabel("");
				label.setBounds(22, 20, 138, 30);
				panel_1.add(label);
				label.setIcon(new ImageIcon(FlightDisplayFrame.class.getResource("/cn/edu/cuit/ftbs/resource/first-after.gif")));

						JPanel panel_2 = new JPanel();
						panel_2.setBackground(Color.WHITE);
						panel.add(panel_2);
								panel_2.setLayout(null);

								JLabel label_1 = new JLabel("");
								label_1.setBounds(84, 15, 87, 35);
								panel_2.add(label_1);
								label_1.setIcon(new ImageIcon(FlightDisplayFrame.class.getResource("/cn/edu/cuit/ftbs/resource/default-active-air.gif")));

										JLabel lblNewLabel_1 = new JLabel("航班选择");
										lblNewLabel_1.setBounds(123, 0, 48, 15);
										panel_2.add(lblNewLabel_1);

										JPanel panel_3 = new JPanel();
										panel_3.setBackground(Color.WHITE);
										panel.add(panel_3);
												panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

												JLabel label_3 = new JLabel("预订完成");
												panel_3.add(label_3);

														JLabel label_2 = new JLabel("");
														panel_3.add(label_2);
														label_2.setIcon(new ImageIcon(FlightDisplayFrame.class.getResource("/cn/edu/cuit/ftbs/resource/last-before.gif")));

	}

}
