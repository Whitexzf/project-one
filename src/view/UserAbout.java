/**
 * 
 */
package view;
import java.awt.AlphaComposite;

import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.*;
/**
 * @author 
 *
 */
public class UserAbout extends JFrame{
	private final static long serialVersionUID=2309008900L;
	private static final String s = "\n\t        金鹏印务有限公司立体版库控制管理系统                    \t\n"+
									"\t   本系统由广州柏能自动化工程有限公司设计开发，于\t\n"+
									"\t2017年4月投入运行。本系统提供终身运行指导及技术支持。\t\t \n"+
									"\t          联系电话：18711632916    唐工\t\t "+
									"\t\t\t\n\n\n";
	/**
	 * 
	 */
	public UserAbout() {
		setTitle("关于");
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				if(!isOpaque()){return;}
				Graphics2D g2d = (Graphics2D) g;
				AlphaComposite opaque = AlphaComposite.SrcOver;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.green,width/2,height/2,java.awt.Color.yellow,false);
				g2d.setComposite(opaque);
				g2d.setPaint(gradientPaint);
				g2d.fillRect(0, 0, width,height);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
			}
		};
		JTextArea textArea = new JTextArea(s);
		textArea.setEditable(false);
		textArea.setFont(new Font("宋体", Font.BOLD, 16));
		panel.add(textArea,"Center");
		this.add(panel,"Center");
		Toolkit tools = this.getToolkit();
		Image logo = tools.getImage("C:/jp/res/logo.jpg");
		setIconImage(logo);
		java.awt.Dimension d = tools.getScreenSize();
		int width = (int)(d.getWidth()-450) /2;
		int height = (int)(d.getHeight()-240)/2;
		setAlwaysOnTop(true);
		setLocation(width, height);
		setSize(350, 240);
		pack();
//		validate();
		setVisible(true);
	}
	public void paint(Graphics g){
		super.paint(g);
		if(!isOpaque()){return;}
		Graphics2D g2d = (Graphics2D) g;
		AlphaComposite opaque = AlphaComposite.SrcOver;
		int width = getWidth();
		int height = getHeight();
		GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.green,width/2,height/2,java.awt.Color.yellow,false);
		g2d.setComposite(opaque);
		g2d.setPaint(gradientPaint);
		g2d.fillRect(0, 0, width,height);
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
	}
	
}
