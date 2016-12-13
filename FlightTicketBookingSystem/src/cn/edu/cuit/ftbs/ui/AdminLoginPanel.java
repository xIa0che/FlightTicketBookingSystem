package cn.edu.cuit.ftbs.ui;





import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * AdminLoginPanel继承JPanel，为管理员登陆面板初始化背景图片
 * @author 陈星
 */
public class AdminLoginPanel extends JPanel{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Image img;

	public AdminLoginPanel() {
		super();
		URL url = getClass().getResource("/cn/edu/cuit/ftbs/resource/Loginlogo.jpg");
		img = new ImageIcon(url).getImage();
	}
	protected void paintComponent(Graphics g){
		super.paintComponents(g);
		g.drawImage(img, 0, 0, this);
	}


}
