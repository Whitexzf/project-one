package view;
import java.awt.AlphaComposite;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import javax.swing.*;

import daos.UsersDAOImpl;
import daos.UsersDAOinf;

import beans.UserBean;

import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Logo extends JFrame implements ActionListener{
	public static final String logoon = "登录";
	public static final String helpt = "查询";
	public static final String logooff ="退出";
	public static final String user = "用    户:";
	public static final String password = "密    码:";
	private Dialog d;
	private JTextField userText;
	private JPasswordField userpwd;
	private JPanel jp = new JPanel(){
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(!isOpaque()){return;}
			Graphics2D g2d = (Graphics2D) g;
			AlphaComposite opaque = AlphaComposite.SrcOver;
			int width = getWidth();
			int height = getHeight();
			GradientPaint gradientPaint = new GradientPaint(0,0,Color.blue,width/2,height/2,Color.CYAN,false);
			g2d.setComposite(opaque);
			g2d.setPaint(gradientPaint);
			g2d.fillRect(0, 0, width,height);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	};
	private JButton logoin = null;
	private JFrame logo_Frame = new JFrame();
	public Logo(){
		JFrame.setDefaultLookAndFeelDecorated(true);
		Toolkit tools = logo_Frame.getToolkit();
		Image logo = tools.getImage("C:/jp/res/logo.jpg");
		logo_Frame.setIconImage(logo);
		logo_Frame.setTitle("金鹏印务有限公司立体版库控制管理系统");
		jp.setLayout(new GridBagLayout());
		jp.setBackground(Color.pink);
		ImageIcon pic = new ImageIcon("C:/jp/res/logo1.jpg");
		JLabel picture = new JLabel();
		setupComponent(picture,0,0,GridBagConstraints.ABOVE_BASELINE_LEADING,1,true);
		javax.swing.JLabel users = new javax.swing.JLabel(user);
		setupComponent(users,0,1,1,1,false);
		javax.swing.JLabel pas = new javax.swing.JLabel(password);
		setupComponent(pas,0,2,1,1,false);
		userText = new javax.swing.JTextField(12);
		userText.requestFocus();
		userText.addKeyListener(new KeyListener(){
			public void keyPressed(KeyEvent e){
				if((e.getKeyChar() == KeyEvent.VK_ENTER )&&(!userText.getText().trim().equals(""))){
					userpwd.requestFocus();
				}else{
					userText.requestFocus();
				}
			}
			public void keyTyped(KeyEvent e) {}
			public void keyReleased(KeyEvent e) {}			
		});
		setupComponent(userText,1,1,1,1,false);
		userpwd = new javax.swing.JPasswordField(12);
		userpwd.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			public void keyPressed(KeyEvent e){
				if((e.getKeyChar() == KeyEvent.VK_ENTER) && (userpwd.getText().trim() != "")){
					logoin.requestFocus();
				}
				else{
					userpwd.requestFocus();
				}
			}
			public void keyReleased(KeyEvent e){}
		});
		setupComponent(userpwd,1,2,1,1,false);	
		logoin = new javax.swing.JButton(logoon);
		logoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				boolean b=false;
				UserBean u=new UserBean();
				u.setUser_name(userText.getText());
				u.setUser_pwd(new String(userpwd.getPassword()));
				UsersDAOinf ud=new UsersDAOImpl();
				b=ud.logoon(u);
				if(b==true){
					logo_Frame.dispose();
					new My_MainFrame(userText.getText().trim());
					}else{

				        d = new Dialog(logo_Frame, "提示信息", true);//弹出的对话框
				        d.setBounds(500, 300, 300, 150);//设置弹出对话框的位置和大小
				        d.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
				        Label lab = new Label("--------------------账号或密码错误！-----------------");//创建lab标签填写提示内容
				        Button okBut = new Button("确定");//创建确定按钮
				        okBut.addActionListener(new ActionListener(){
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								d.dispose();
							}
				        	
				        });
				        d.add(lab);//将标签添加到弹出的对话框内
				        d.add(okBut);
				        d.setVisible(true);
//						JOptionPane.showMessageDialog(null, "标题【出错啦】", "年龄请输入数字", JOptionPane.ERROR_MESSAGE);
						userText.setText("");
						userpwd.setText("");
						userText.requestFocus();
				}
			
			}
		});
		logoin.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			public void keyPressed(KeyEvent e){
				if((e.getKeyChar() == KeyEvent.VK_ENTER)){
					boolean b=false;
					UserBean u=new UserBean();
					u.setUser_name(userText.getText());
					u.setUser_pwd(new String(userpwd.getPassword()));
					UsersDAOinf ud=new UsersDAOImpl();
					b=ud.logoon(u);
					if(b==true){
						logo_Frame.dispose();
						new My_MainFrame(userText.getText().trim());
						}else{
							System.out.println(56);
							JOptionPane.showMessageDialog(null, "标题【出错啦】", "年龄请输入数字", JOptionPane.ERROR_MESSAGE);
							userText.setText("");
							userpwd.setText("");
							userText.requestFocus();
					}
				}
			}
			public void keyReleased(KeyEvent e){}
		});
		setupComponent(logoin,0,3,1,1,true);
		javax.swing.JButton help = new javax.swing.JButton(helpt);
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e1){
				logo_Frame.dispose();
				new My_MainFramen(userText.getText().trim());
			}
		});
		setupComponent(help,2,3,1,1,true);
		javax.swing.JButton exit = new javax.swing.JButton(logooff);
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				logo_Frame.dispose();
				System.exit(0);
			}
		});
		setupComponent(exit,1,3,1,1,true);
		java.awt.Dimension d = tools.getScreenSize();
		int width = (int)(d.getWidth()-350) /2;
		int height = (int)(d.getHeight()-240)/2;
		logo_Frame.add(jp);
		logo_Frame.setResizable(false);
		logo_Frame.setAlwaysOnTop(true);
		logo_Frame.setLocation(width, height);
		logo_Frame.pack();
		logo_Frame.setSize(500, 300);
		logo_Frame.validate();
		logo_Frame.setVisible(true);
		logo_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * @param args
	 */
	public void actionPerformed(ActionEvent e){
		
	}
	public static void main(String[] args) {
		new Logo();
	}
	public void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill){
		final GridBagConstraints gridBagConstrains = new GridBagConstraints();
		gridBagConstrains.gridx = gridx;
		gridBagConstrains.gridy = gridy;
		gridBagConstrains.insets = new java.awt.Insets(5,3,3,3);
		if(gridwidth>1)
			gridBagConstrains.gridwidth = gridwidth;
		if(ipadx > 0)
			gridBagConstrains.ipadx = ipadx;
		if(fill)
			gridBagConstrains.fill = GridBagConstraints.HORIZONTAL;
		jp.add(component,gridBagConstrains);
	}
}
