package view;

import java.awt.AlphaComposite;


import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import daos.SetDAOimpl;
import daos.SetDAOinf;
import daos.UsersDAOImpl;
import daos.UsersDAOinf;

import beans.SetBean;
import beans.UserBean;
import db.DBUtil;


public class  Set {
	private static final String logoon = "系统设置";
	private static final String helpt = "确定";
	private static final String logooff ="退出";
	private static final String user = "存取报障（分）:";
	private static final String password = "存储时间（月）:";
	private static final String enterpwd ="出入库报障（分）:";
	private Dialog d;
	private javax.swing.JTextField scantime=null;
	private javax.swing.JTextField storetime=null;
	private javax.swing.JTextField spare=null;
	private javax.swing.JPanel jp = new javax.swing.JPanel(){
		final static long serialVersionUID = 2309585L;
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			if(!isOpaque()){return;}
			Graphics2D g2d = (Graphics2D) g;
			
			AlphaComposite opaque = AlphaComposite.SrcOver;
			//AlphaComposite blend = AlphaComposite.getInstance(rule, 0.6f);
			//AlphaComposite set = AlphaComposite.Src;
			int width = getWidth();
			int height = getHeight();
			GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.green,width/2,height/2,java.awt.Color.yellow,false);
			g2d.setComposite(opaque);
			g2d.setPaint(gradientPaint);
			g2d.fillRect(0, 0, width,height);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	};
	private javax.swing.JButton add = new javax.swing.JButton(helpt);
	private javax.swing.JButton cancle = new javax.swing.JButton(logooff);
	private JFrame logo_Frame = new JFrame(logoon);
	public Set() {
		// TODO 自动生成构造函数存根
		try{
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch(Exception exe){System.err.print(exe.getMessage());}
		JFrame.setDefaultLookAndFeelDecorated(true);
		Toolkit tools = logo_Frame.getToolkit();
		Image logo = tools.getImage("res/logo.jpg");
		logo_Frame = new JFrame(logoon);
		logo_Frame.setIconImage(logo);
		
		
		jp.setLayout(new GridBagLayout());
		javax.swing.ImageIcon pic = new javax.swing.ImageIcon("res/logo1.jpg");
		javax.swing.JLabel picture = new javax.swing.JLabel(pic);
		setupComponent(picture,0,0,GridBagConstraints.ABOVE_BASELINE_LEADING,1,true);
		javax.swing.JLabel users = new javax.swing.JLabel(user);
		setupComponent(users,0,1,1,1,false);
		javax.swing.JLabel pas = new javax.swing.JLabel(password);
		setupComponent(pas,0,2,1,1,false);
		javax.swing.JLabel enpas = new javax.swing.JLabel(enterpwd);
		setupComponent(enpas,0,3,1,1,false);
		scantime = new javax.swing.JTextField(12);
		setupComponent(scantime,1,1,1,1,false);
		storetime = new javax.swing.JTextField(12);
		setupComponent(storetime,1,2,1,1,false);
		spare = new javax.swing.JTextField(12);
		setupComponent(spare,1,3,1,1,false);
		SetBean sb=new SetBean();
		sb.setName("scantime");
		SetDAOinf sd=new SetDAOimpl();
		SetBean sbb=new SetBean();
		sbb=sd.select(sb);
		scantime.setText(sbb.getValue());
		
		SetBean ssb=new SetBean();
		ssb.setName("storetime");
		SetBean ssbb=new SetBean();
		ssbb=sd.select(ssb);
		storetime.setText(ssbb.getValue());
		
		SetBean s=new SetBean();
		s.setName("inouttime");
		SetBean bb=new SetBean();
		bb=sd.select(s);
		spare.setText(bb.getValue());
		//logoin = new javax.swing.JButton(logoon);
		add.addKeyListener(new KeyListener(){
			public void keyTyped(KeyEvent e){}
			public void keyReleased(KeyEvent e){}
			public void keyPressed(KeyEvent e){
				String scan=scantime.getText();
				String store=storetime.getText();
				String inout=spare.getText();
				SetBean s=new SetBean();
				s.setName("inouttime");
				s.setValue(inout);
				SetBean ss=new SetBean();
				ss.setName("scantime");
				ss.setValue(scan);
				SetBean sss=new SetBean();
				sss.setName("storetime");
				sss.setValue(store);
				SetDAOinf sd=new SetDAOimpl();
				if(sd.Update(s)&&sd.Update(ss)&&sd.Update(sss)){
					d = new Dialog(logo_Frame, "提示信息", true);//弹出的对话框
			        d.setBounds(500, 300, 300, 150);//设置弹出对话框的位置和大小
			        d.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
			        Label lab = new Label("--------------------更新成功！-----------------");//创建lab标签填写提示内容
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
				}else{
					d = new Dialog(logo_Frame, "提示信息", true);//弹出的对话框
			        d.setBounds(500, 300, 300, 150);//设置弹出对话框的位置和大小
			        d.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
			        Label lab = new Label("--------------------更新失败请重新输入！-----------------");//创建lab标签填写提示内容
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
				}
				
				
				
			}
		});
		add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String scan=scantime.getText();
				String store=storetime.getText();
				String inout=spare.getText();
				SetBean s=new SetBean();
				s.setName("inouttime");
				s.setValue(inout);
				SetBean ss=new SetBean();
				ss.setName("scantime");
				ss.setValue(scan);
				SetBean sss=new SetBean();
				sss.setName("storetime");
				sss.setValue(store);
				SetDAOinf sd=new SetDAOimpl();
				if(sd.Update(s)&&sd.Update(ss)&&sd.Update(sss)){
					d = new Dialog(logo_Frame, "提示信息", true);//弹出的对话框
			        d.setBounds(500, 300, 300, 150);//设置弹出对话框的位置和大小
			        d.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
			        Label lab = new Label("-----------------------更新成功！---------------------");//创建lab标签填写提示内容
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
				}else{
					d = new Dialog(logo_Frame, "提示信息", true);//弹出的对话框
			        d.setBounds(500, 300, 300, 150);//设置弹出对话框的位置和大小
			        d.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
			        Label lab = new Label("-----------------------更新失败请重新输入！-------------------");//创建lab标签填写提示内容
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
				}
				
				
				
			}
		});
		setupComponent(add,0,4,1,1,true);
		
		//javax.swing.JButton exit = new javax.swing.JButton(logooff);
		cancle.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e2){
				logo_Frame.dispose();
				//System.exit(0);
			}
		});
		setupComponent(cancle,1,4,1,1,true);
		java.awt.Dimension d = tools.getScreenSize();
		int width = (int)(d.getWidth()-350) /2;
		int height = (int)(d.getHeight()-240)/2;
		logo_Frame.add(jp);
		logo_Frame.setAlwaysOnTop(true);
		logo_Frame.setLocation(width, height);
		logo_Frame.setSize(350, 240);
		logo_Frame.pack();
		logo_Frame.validate();
		logo_Frame.setVisible(true);
	}
	private void setupComponent(JComponent component,int gridx,int gridy,int gridwidth,int ipadx,boolean fill){
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
