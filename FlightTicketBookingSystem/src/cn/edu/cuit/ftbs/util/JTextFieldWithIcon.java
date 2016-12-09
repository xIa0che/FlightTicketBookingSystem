package cn.edu.cuit.ftbs.util;

import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 * 带icon的jtextfield
 * @author xIa0che
 *
 */
public class JTextFieldWithIcon extends JTextField {
    /**
	 *
	 */
	private static final long serialVersionUID = -304571909145154332L;
	private ImageIcon icon;

    public JTextFieldWithIcon(String path) {
        //获取当前路径下的图片
        icon = new ImageIcon(getClass().getResource(path));
        Insets insets = new Insets(0, 20, 0, 0);
        //设置文本输入距左边20
        this.setMargin(insets);
    }

    @Override
    public void paintComponent(Graphics g) {
        Insets insets = getInsets();
        super.paintComponent(g);
        int iconWidth = icon.getIconWidth();
        int iconHeight = icon.getIconHeight();
        int Height = this.getHeight();
        //在文本框中画上之前图片
        icon.paintIcon(this, g, (insets.left - iconWidth)/2, (Height - iconHeight) / 2);
    }
}

