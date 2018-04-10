package view;

import java.awt.event.*;

import java.awt.*;

import javax.swing.*;

import view.createOutInFace.MyThred;

import daos.ExcelDAOimpl;
import daos.ExcelDAOinf;
import daos.UsersDAOImpl;
import daos.UsersDAOinf;


import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class My_MainFrame {
	public static int a[][]=new int[10][7];
	public static int d[][]=new int[10][7];
	public static int b=0;
	private final static javax.swing.ImageIcon icon = new javax.swing.ImageIcon("C:/jp/res/logo1.jpg");
	private JFrame frame = new javax.swing.JFrame();
	private JMenuBar menuBar = null;
	private JToolBar toolBar = null;
	private JSplitPane splitPane = null;
	private JScrollPane scrollPane = null;
	private JPanel panel = null;
	private JTabbedPane tabbedPane = new javax.swing.JTabbedPane();
	private JButton stuff_in = null;//产品存入
	private JButton product_in = null;
	private JButton stuff_quit = null;//产品取出
	private JButton stuff_add = null;//产品增加
	private JButton product_stock = null;//产品库存
	private JButton stuff_del = null;//产品删除
	private JButton handle_record = null;//存取记录
	private JButton help = null;//帮助
	private JButton inout=null;
	private JButton about = null;//关于
	private JButton exit_system = null;//退出系统
	private String sql = null;
	public My_MainFrame() {
	}
	public My_MainFrame(String name){
		java.awt.Toolkit tool = frame.getToolkit();
		Image image = tool.getImage("C:/jp/res/logo.jpg");
		java.awt.Dimension dimn = tool.getScreenSize();
		String title = "金鹏印务有限公司立体版库控制管理系统--"+name;
		ExcelDAOinf ed=new ExcelDAOimpl();
		ed.readall();
		Thread thread=new Thread(new MyThread());
		thread.start();
		Thread threadw=new Thread(new MyThreadW());
		threadw.start();
		frame.setTitle(title);
		frame.setIconImage(image);
		frame.setFocusable(true);
		frame.setLayout(new java.awt.BorderLayout());
		frame.setJMenuBar(createJMenuBar());
		frame.add(createJToolBar(name),"North");
		frame.add(createSplitPane(),"Center");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setPreferredSize(dimn);
		frame.setBackground(java.awt.Color.cyan);
		frame.pack();
		frame.validate();
		frame.setVisible(true);
	}
	public static class MyThread implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int A1=0;
			while(true){
				Date dNow = new Date();   //当前时间
				int s=dNow.getSeconds();
				if(s%2==1){
					if(A1==0){
					A1=1;
					ExcelDAOinf ed=new ExcelDAOimpl();
					My_MainFrame.d=ed.read();
					}
				}else{
					A1=0;
							
				}
				}
			}
		}
	public static class MyThreadW implements Runnable{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int A1=0;
			while(true){
				Date dNow = new Date();   //当前时间
				int s=dNow.getSeconds();
				if(s%2==1){
					if(A1==0){
					A1=1;
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ExcelDAOinf ed=new ExcelDAOimpl();
					ed.writer(My_MainFrame.a);
					}
				}else{
					A1=0;
							
				}
				}
			}
		}
	private JMenu createSystem_Manage_Menu(){
		javax.swing.JMenu systemMenu = new javax.swing.JMenu("系统");
		javax.swing.JMenuItem logoin = new javax.swing.JMenuItem("注      册");
		logoin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new AddUser();
			}
		});
		javax.swing.JMenuItem logoout = new javax.swing.JMenuItem("删除用户");
		logoout.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String jp = new JOptionPane().showInputDialog(frame,"请输入要删除的用户名！","输入用户名",JOptionPane.YES_NO_CANCEL_OPTION).trim();
				UsersDAOinf ud=new UsersDAOImpl();
				if(ud.delbyname(jp)){
					JOptionPane.showConfirmDialog(null, "用户删除成功!");
				}
				JOptionPane.showConfirmDialog(null, "用户删除失败!");
			}
		});
		javax.swing.JMenuItem set = new javax.swing.JMenuItem("系统设置");
		set.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Set();
			}
		});
		systemMenu.add(logoin);
		systemMenu.add(logoout);
		systemMenu.add(set);
		return systemMenu;
	}
	
	private JMenu createHelp_Menu(){
		javax.swing.JMenu helpMenu = new javax.swing.JMenu("帮助");
		javax.swing.JMenuItem help = new javax.swing.JMenuItem("帮助");
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddHelp();
			}
		});
		javax.swing.JMenuItem about = new javax.swing.JMenuItem("关于");
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
		javax.swing.JMenu outMenu = new javax.swing.JMenu("退出");
		javax.swing.JMenuItem out = new javax.swing.JMenuItem("退出");
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
		menuBar.setBackground(java.awt.Color.cyan
				);
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
		
		stuff_in = new javax.swing.JButton("板棍存入");
		stuff_in.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffIn("板棍存入",name);
			}
		});
		stuff_quit = new javax.swing.JButton("板棍取出");
		stuff_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffQuit("板棍取出",name);
			}
		});
		stuff_add = new javax.swing.JButton("板棍新增");
		stuff_add.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffadd("板棍新增");
			}
		});
		stuff_del = new javax.swing.JButton("板棍删除");
		stuff_del.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffdel("板棍删除");
			}
		});
		product_stock = new javax.swing.JButton("库存查询");
		product_stock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffnumber("库存查询");
			}
		});
		handle_record = new javax.swing.JButton("存取记录");
		handle_record.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try {
					AddTable("存取记录");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		help = new javax.swing.JButton("帮     助");
		help.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddHelp();
			}
		});
		inout = new JButton("入库出库");
		inout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddStuffinout("入库出库");
			}
		});
		about = new javax.swing.JButton("关     于");
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new UserAbout();
			}
		});
		exit_system = new javax.swing.JButton("退出系统");
		exit_system.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				frame.dispose();
				System.exit(0);
			}
		});
		toolBar.add(stuff_in);
		toolBar.addSeparator();
		toolBar.add(stuff_quit);
		toolBar.addSeparator();
		toolBar.add(product_stock);
		toolBar.addSeparator();
		toolBar.add(handle_record);
		toolBar.addSeparator();
		toolBar.add(inout);
		toolBar.addSeparator();
		toolBar.add(help);
		toolBar.addSeparator();
		toolBar.add(about);
		toolBar.addSeparator();
		toolBar.add(exit_system);
		toolBar.setBackground(java.awt.Color.cyan);
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
				GradientPaint gradientPaint = new GradientPaint(0,0,java.awt.Color.green,width/2,height/2,java.awt.Color.cyan
						,false);
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
				AddStuffadd("板棍新增");
			}
		});
		javax.swing.ImageIcon image7 = new javax.swing.ImageIcon("C:/jp/res/stuffquit.jpg");
		stuff_quit = new javax.swing.JButton(image7);
		stuff_quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				AddStuffdel("板棍删除");
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
		panel.add(stuff_in);
		panel.add(stuff_quit);
		panel.add(help);
		panel.add(about);
		panel.add(exit_system);
		panel.setBackground(java.awt.Color.cyan);
		scrollPane = new javax.swing.JScrollPane(panel);
		scrollPane.setBackground(java.awt.Color.cyan);
		return scrollPane;
	}
	private JTabbedPane createHandlePane(){
		javax.swing.ImageIcon image = new javax.swing.ImageIcon("C:/jp/res/welcome1.jpg");
		javax.swing.JLabel component = new javax.swing.JLabel(image);
		tabbedPane.addTab("欢迎",icon ,component);
		tabbedPane.setBackgroundAt(0, java.awt.Color.cyan);
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
		splitPane.setDividerLocation(180);
		splitPane.setDividerSize(1);
		splitPane.setOneTouchExpandable(true);
		splitPane.setBackground(java.awt.Color.cyan);
		return splitPane;
	}
	//产品存入
	private void AddStuffIn(String s,String name){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s, icon,new createUserStuffInterFacen(name));
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//产品删除
	private void AddStuffdel(String s){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s, icon,new createUserStuffdelInterFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//产品取出
	private void AddStuffQuit(String s,String name){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s,icon ,new createStuffQuitInterFacen(name));
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	private void AddStuffinout(String s){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s,icon ,new createOutInFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//产品增加
	private void AddStuffadd(String s){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(s,icon ,new createStuffaddInterFace());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//库存查询
	private void AddStuffnumber(String title){
		int i = tabbedPane.getTabCount();
		if(i>0)tabbedPane.removeAll();
		tabbedPane.addTab(title,icon ,new createUserYieldScrapInterFacen());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
	//存取记录
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
		tabbedPane.addTab("帮助",icon ,new UserHelp());
		int b = tabbedPane.getTabCount();
		tabbedPane.setSelectedIndex(b-1);
	}
}
