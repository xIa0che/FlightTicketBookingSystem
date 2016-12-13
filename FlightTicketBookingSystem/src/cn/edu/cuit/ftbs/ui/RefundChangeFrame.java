package cn.edu.cuit.ftbs.ui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import cn.edu.cuit.ftbs.entity.Customer;

/**
 * 退票改签Frame
 * @author xIa0che
 *
 */
public class RefundChangeFrame extends JFrame {

	private static final long serialVersionUID = 4789329843931380744L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RefundChangeFrame frame = new RefundChangeFrame();
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
	public RefundChangeFrame(Customer customer) {
		setBounds(100, 100, 948, 496);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		contentPane.add(new RefundChangePanel(customer, this), BorderLayout.CENTER);
	}

}
