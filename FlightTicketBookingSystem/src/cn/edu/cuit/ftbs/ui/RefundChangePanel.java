package cn.edu.cuit.ftbs.ui;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;

public class RefundChangePanel extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	public RefundChangePanel() {
		setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.SOUTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.SOUTH);
		
		Component horizontalStrut = Box.createHorizontalStrut(500);
		panel_1.add(horizontalStrut);
		
		JButton button = new JButton("");
		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setIcon(new ImageIcon(RefundChangePanel.class.getResource("/cn/edu/cuit/ftbs/resource/nextStep.PNG")));
		panel_1.add(button);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		
		JRadioButton refundRadioButton = new JRadioButton("退票");
		panel_2.add(refundRadioButton);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(100);
		panel_2.add(horizontalStrut_1);
		
		JRadioButton changeRadioButton = new JRadioButton("改签");
		panel_2.add(changeRadioButton);

	}

}
