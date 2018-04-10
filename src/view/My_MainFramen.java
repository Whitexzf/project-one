package view;

import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

import daos.UsersDAOImpl;
import daos.UsersDAOinf;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class My_MainFramen {
	private final static javax.swing.ImageIcon icon = new javax.swing.ImageIcon("C:/jp/res/logo1.jpg");
	private JFrame frame = new javax.swing.JFrame();
	private JMenuBar menuBar = null;
	private JToolBar toolBar = null;
	private JSplitPane splitPane = null;
	private JScrollPane scrollPane = null;
	private JPanel panel = null;
	private JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
	private JButton stuff_in = null;//��Ʒ����
	private JButton product_in = null;
	private JButton stuff_quit = null;//��Ʒȡ��
	private JButton stuff_add = null;//��Ʒ����
	private JButton product_stock = null;//��Ʒ���
	private JButton stuff_del = null;//��Ʒɾ��
	private JButton handle_record = null;//��ȡ��¼
	private JButton help = null;//����
	private JButton about = null;//����
	private JButton exit_system = null;//�˳�ϵͳ
	
	
	public My_MainFramen() {
	}
	public My_MainFramen(String name){
		java.awt.Toolkit tool = frame.getToolkit();
		Image image = tool.getImage("C:/jp/res/logo.jpg");
		java.awt.Dimension dimn = tool.getScreenSize();
		String title = "����ӡ�����޹�˾��������ƹ���ϵͳ--"+name;
		frame.setTitle(title);
		frame.setIconImage(image);
		frame.setFocusable(true);
		frame.setLayout(new java.awt.BorderLayout());
		frame.setJMenuBar(createJMenuBar());
		frame.add(createJToolBar(name),"North");
		frame.add(createSplitPane(),"Center");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(dimn);
		frame.setBackground(java.awt.Color.pink);
		frame.pack();
		frame.validate();
		frame.setVisible(true);
	}
	private JMenu createSystem_Manage_Menu(){
		javax.swing.JMenu systemMenu = new javax.swing.JMenu("ϵͳ");
		javax.swing.JMenuItem logoin = new javax.swing.JMenuItem("ע      ��");
		logoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		javax.swing.JMenuItem logoout = new javax.swing.JMenuItem("ɾ���û�");
		logoout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String jp = new JOptionPane().showInputDialog(frame,"������Ҫɾ�����û�����","�����û���",JOptionPane.YES_NO_CANCEL_OPTION).trim();
				UsersDAOinf ud=new UsersDAOImpl();
				if(ud.delbyname(jp)){
					JOptionPane.showConfirmDialog(null, "�û�ɾ���ɹ�!");
				}
				JOptionPane.showConfirmDialog(null, "�û�ɾ��ʧ��!");
			}
		});
		return systemMenu;
	}
	
	private JMenu createHelp_Menu(){
		javax.swing.JMenu helpMenu = new javax.swing.JMenu("����");
		javax.swing.JMenuItem help = new javax.swing.JMenuItem("����");
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddHelp();
			}
		});
		javax.swing.JMenuItem about = new javax.swing.JMenuItem("����");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new UserAbout();
			}
		});
		helpMenu.add(help);
		helpMenu.add(about);
		return helpMenu;
	}
	private JMenu loginout(){
		javax.swing.JMenu outMenu = new javax.swing.JMenu("�˳�");
		javax.swing.JMenuItem out = new javax.swing.JMenuItem("�˳�");
		out.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				System.exit(0);
			}
		});
		outMenu.add(out);
		return outMenu;
	}
	private JMenuBar createJMenuBar(){
		menuBar = new javax.swing.JMenuBar(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				if(!isOpaque()){return;}
				Graphics2D g2d = (Graphics2D) g;
				AlphaComposite opaque = AlphaComposite.SrcOver;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.blue,width/2,height/2,java.awt.Color.CYAN,false);
				g2d.setComposite(opaque);
				g2d.setPaint(gradientPaint);
				g2d.fillRect(0, 0, width,height);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
			}
		};
		menuBar.add(createSystem_Manage_Menu());
		menuBar.add(createHelp_Menu());
		menuBar.add(loginout());
		menuBar.setBackground(java.awt.Color.pink);
		return menuBar;
	}
	private JToolBar createJToolBar(final String name){
		toolBar = new javax.swing.JToolBar(){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				if(!isOpaque()){return;}
				Graphics2D g2d = (Graphics2D) g;
				AlphaComposite opaque = AlphaComposite.SrcOver;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.BLUE,width/2,height/2,java.awt.Color.CYAN,false);
				g2d.setComposite(opaque);
				g2d.setPaint(gradientPaint);
				g2d.fillRect(0, 0, width,height);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
			}
		};
		
		stuff_in = new javax.swing.JButton("�������");
		stuff_in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		stuff_quit = new javax.swing.JButton("���ȡ��");
		stuff_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		stuff_add = new javax.swing.JButton("�������");
		stuff_add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		stuff_del = new javax.swing.JButton("���ɾ��");
		stuff_del.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		product_stock = new javax.swing.JButton("����ѯ");
		product_stock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffnumber("����ѯ");
			}
		});
		handle_record = new javax.swing.JButton("��ȡ��¼");
		handle_record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					AddTable("��ȡ��¼");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		help = new javax.swing.JButton("��     ��");
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddHelp();
			}
		});
		about = new javax.swing.JButton("��     ��");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new UserAbout();
			}
		});
		exit_system = new javax.swing.JButton("�˳�ϵͳ");
		exit_system.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(0);
			}
		});
		toolBar.add(product_stock);
		toolBar.addSeparator();
		toolBar.add(handle_record);
		toolBar.addSeparator();
		toolBar.add(help);
		toolBar.addSeparator();
		toolBar.add(about);
		toolBar.addSeparator();
		toolBar.add(exit_system);
		toolBar.setBackground(java.awt.Color.pink);
		return toolBar;
	}
	private JScrollPane createScrollPane(){
		panel = new javax.swing.JPanel(){
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
		panel.setLayout(new javax.swing.BoxLayout(panel,BoxLayout.Y_AXIS ));
		javax.swing.ImageIcon image6 = new javax.swing.ImageIcon("C:/jp/res/stuffin.jpg");
		stuff_in = new javax.swing.JButton(image6);
		stuff_in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		javax.swing.ImageIcon image7 = new javax.swing.ImageIcon("C:/jp/res/stuffquit.jpg");
		stuff_quit = new javax.swing.JButton(image7);
		stuff_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
			}
		});
		javax.swing.ImageIcon image16 = new javax.swing.ImageIcon("C:/jp/res/help.jpg");
		help = new javax.swing.JButton(image16);
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddHelp();
			}
		});
		javax.swing.ImageIcon image17 = new javax.swing.ImageIcon("C:/jp/res/about.jpg");
		about = new javax.swing.JButton(image17);
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new UserAbout();
			}
		});
		javax.swing.ImageIcon image18 = new javax.swing.ImageIcon("C:/jp/res/cancle.jpg");
		exit_system = new javax.swing.JButton(image18);
		exit_system.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(0);
			}
		});
		panel.add(help);
		panel.add(about);
		panel.add(exit_system);
		panel.setBackground(java.awt.Color.pink);
		scrollPane = new javax.swing.JScrollPane(panel);
		scrollPane.setBackground(java.awt.Color.pink);
		return scrollPane;
	}
	private JTabbedPane createHandlePane(){
		javax.swing.ImageIcon image = new javax.swing.ImageIcon("C:/jp/res/welcome1.jpg");
		javax.swing.JLabel component = new javax.swing.JLabel(image);
		tabbedPane.addTab("��ӭ",icon ,component);
		tabbedPane.setBackgroundAt(0, java.awt.Color.pink);
		return tabbedPane;
	}
	private JSplitPane createSplitPane(){
		splitPane = new javax.swing.JSplitPane(JSplitPane.HORIZONTAL_SPLIT,true,createScrollPane(),createHandlePane()){
			public void paintComponent(Graphics g){
				super.paintComponent(g);
				if(!isOpaque()){return;}
				Graphics2D g2d = (Graphics2D) g;
				AlphaComposite opaque = AlphaComposite.SrcOver;
				int width = getWidth();
				int height = getHeight();
				GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.blue,width/2,height/2,java.awt.Color.CYAN,false);
				g2d.setComposite(opaque);
				g2d.setPaint(gradientPaint);
				g2d.fillRect(0, 0, width,height);
				g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_OFF);
			}
		};
		splitPane.setDividerLocation(138);
		splitPane.setDividerSize(5);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBackground(java.awt.Color.pink);
		return splitPane;
	}
	//��Ʒ����
	private void AddStuffIn(String s,String name){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s, icon,new createUserStuffInterFacen(name));
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	
	//��Ʒɾ��
	private void AddStuffdel(String s){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s, icon,new createUserStuffdelInterFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//��Ʒȡ��
	private void AddStuffQuit(String s,String name){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s,icon ,new createStuffQuitInterFacen(name));
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//��Ʒ����
	private void AddStuffadd(String s){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s,icon ,new createStuffaddInterFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//����ѯ
	private void AddStuffnumber(String title){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(title,icon ,new createUserYieldScrapInterFacen());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//��ȡ��¼
	private void AddTable(String title) throws SQLException{
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(title,icon ,new createUserStuffStoreInterFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	private void AddHelp(){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab("����",icon ,new UserHelp());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
}
