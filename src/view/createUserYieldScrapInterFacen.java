/*
 * createUserYieldScrapInterFacen.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import daos.InventoryBeanDAOimpl;
import daos.InventoryBeanDAOinf;

import beans.InventoryBean;
import db.DBUtil;

/**
 *
 * @author  __USER__
 */
public class createUserYieldScrapInterFacen extends javax.swing.JPanel {
	TableModel m1 = null;
	/** Creates new form createUserYieldScrapInterFacen */
	public createUserYieldScrapInterFacen() {
		initComponents();
		this.setBackground(java.awt.Color.cyan);
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		Connection con = null;
		Statement sta = null;
		PreparedStatement prs = null;
		ResultSet rs = null;
		Object[][] data = null;
		StringBuffer[][] shuzu= new StringBuffer[13][10] ;
		Object[] mc;
		JTable ta1;
		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jComboBox1 = new javax.swing.JComboBox();
		jButton2 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jTextField5 = new javax.swing.JTextField();
		jTextField6 = new javax.swing.JTextField();
		jPanel2 = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jButton3 = new javax.swing.JButton();
		jScrollPane2 = new javax.swing.JScrollPane();
        
		jPanel1.setBackground(Color.CYAN);
		jPanel2.setBackground(Color.CYAN);
		jLabel1.setText("\u677f\u68cd\u8be6\u60c5");

		jTextArea1.setColumns(20);
		jTextArea1.setRows(5);
		jScrollPane1.setViewportView(jTextArea1);

		jLabel2.setText("\u5370\u7248\u67e5\u8be2");

		jLabel3.setText("\u4f4d\u7f6e\u67e5\u8be2");
		
		
		jButton1.setText("\u67e5\u8be2");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				String Plate_name=jComboBox1.getSelectedItem().toString();
				new JTableTest(Plate_name);
			}
		});
		Set<String> set= new HashSet();
	    InventoryBeanDAOinf ib=new InventoryBeanDAOimpl();
	    jTextField3.setText(ib.getin()+"");
	    jTextField4.setText(ib.getout()+"");
	    jTextField5.setText(ib.getnew()+"");
	    jTextField6.setText(ib.getold()+"");
	    set=ib.getName();
	    String[] array=(String[])set.toArray(new String[set.size()]);
		jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(array));

		jButton2.setText("\u67e5\u8be2");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InventoryBean ib=new InventoryBean();
				ib.setLocation(jTextField1.getText());
				InventoryBeanDAOinf ibd=new InventoryBeanDAOimpl();
				String s=ibd.selectall(ib);
				if(s!=null){
					jTextArea1.setText(s);
				}else{
					JOptionPane.showMessageDialog(null, "库位号不存在或没有板棍放置");
				}
				
			}
		});

		jLabel5.setText("\u5728\u5e93\u677f\u68cd");

		jLabel6.setText("\u4e0d\u5728\u5e93\u677f\u68cd");

		jLabel7.setText("\u65b0\u677f\u68cd");

		jLabel8.setText("\u65e7\u677f\u68cd");
		

		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout
				.setHorizontalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(
																jLabel1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																57,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				300,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(63,
																				63,
																				63)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel2,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												57,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jComboBox1,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												132,
																												javax.swing.GroupLayout.PREFERRED_SIZE))
																						.addGroup(
																								jPanel1Layout
																										.createSequentialGroup()
																										.addComponent(
																												jLabel3,
																												javax.swing.GroupLayout.PREFERRED_SIZE,
																												57,
																												javax.swing.GroupLayout.PREFERRED_SIZE)
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addComponent(
																												jTextField1,
																												javax.swing.GroupLayout.DEFAULT_SIZE,
																												132,
																												Short.MAX_VALUE)))
																		.addGap(48,
																				48,
																				48)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addComponent(
																								jButton1)
																						.addComponent(
																								jButton2))))
										.addGap(106, 106, 106)
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING,
																false)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addComponent(
																				jLabel8,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				57,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(18,
																				18,
																				18)
																		.addComponent(
																				jTextField6))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								71,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								71,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel7,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								64,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								false)
																						.addComponent(
																								jTextField5)
																						.addComponent(
																								jTextField4)
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								82,
																								Short.MAX_VALUE))))
										.addGap(38, 38, 38)));
		jPanel1Layout
				.setVerticalGroup(jPanel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel1Layout
										.createSequentialGroup()
										.addGroup(
												jPanel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jLabel1,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				27,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jScrollPane1,
																				javax.swing.GroupLayout.DEFAULT_SIZE,
																				232,
																				Short.MAX_VALUE))
														.addGroup(
																jPanel1Layout
																		.createSequentialGroup()
																		.addGap(35,
																				35,
																				35)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jTextField3,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jLabel5,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								27,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.TRAILING)
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addPreferredGap(
																												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel2,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																27,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jButton1)
																														.addComponent(
																																jComboBox1,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																33,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(61,
																												61,
																												61)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jLabel3,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																27,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jButton2)
																														.addComponent(
																																jTextField1,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																31,
																																javax.swing.GroupLayout.PREFERRED_SIZE)))
																						.addGroup(
																								javax.swing.GroupLayout.Alignment.LEADING,
																								jPanel1Layout
																										.createSequentialGroup()
																										.addGap(28,
																												28,
																												28)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jTextField4,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel6,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																27,
																																javax.swing.GroupLayout.PREFERRED_SIZE))
																										.addGap(36,
																												36,
																												36)
																										.addGroup(
																												jPanel1Layout
																														.createParallelGroup(
																																javax.swing.GroupLayout.Alignment.BASELINE)
																														.addComponent(
																																jTextField5,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																javax.swing.GroupLayout.DEFAULT_SIZE,
																																javax.swing.GroupLayout.PREFERRED_SIZE)
																														.addComponent(
																																jLabel7,
																																javax.swing.GroupLayout.PREFERRED_SIZE,
																																27,
																																javax.swing.GroupLayout.PREFERRED_SIZE))))
																		.addGap(15,
																				15,
																				15)
																		.addGroup(
																				jPanel1Layout
																						.createParallelGroup(
																								javax.swing.GroupLayout.Alignment.BASELINE)
																						.addComponent(
																								jLabel8,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								27,
																								javax.swing.GroupLayout.PREFERRED_SIZE)
																						.addComponent(
																								jTextField6,
																								javax.swing.GroupLayout.PREFERRED_SIZE,
																								javax.swing.GroupLayout.DEFAULT_SIZE,
																								javax.swing.GroupLayout.PREFERRED_SIZE))
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED,
																				44,
																				Short.MAX_VALUE)))
										.addContainerGap()));

		jLabel4.setText("\u67b6\u4f4d\u67e5\u8be2");



		jButton3.setText("\u67e5\u8be2");

		int a1,a2,a3;
		mc = new Object[] { " ","第一列", "第二列", "第三列", "第四列", "第五列"
				, "第六列", "第七列" , "第八列" , "第九列" , "第十列"  };
		m1 = new DefaultTableModel(data,mc){
			public boolean isCellEditable(int rowIndex, int columnIndex) {   
			     return false;
			}} ;
		ta1=new JTable(m1);
		ta1.setBackground(Color.cyan);
		ta1.setRowHeight(21);
		con=DBUtil.getConn();
		for(int i=0;i<13;i++){
			for(int j=0;j<10;j++){
				shuzu[i][j]=new StringBuffer("");
			}
		}
			
		try {
			String sql="select * from inventory_list where Frame_num=1";
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			
			while(rs.next()){
				a1=Integer.parseInt(rs.getString("Row"));
				a2=Integer.parseInt(rs.getString("Col"));
				a3=Integer.parseInt(rs.getString("Status"));	
				if(a3==1)
				shuzu[a2-1][a1-1].append("在库");
				else if(a3==0)
					shuzu[a2-1][a1-1].append("不在");
				else
					shuzu[a2-1][a1-1].append("");
				};
				for(int i=0;i<13;i++){
					for(int j=0;j<10;j++){
						if(i<9){
							if(j<9){
								shuzu[i][j].append("(0"+(j+1)+"0"+(i+1)+"01)");	
							}else{
								shuzu[i][j].append("("+(j+1)+"0"+(i+1)+"01)");
							}
						}else{
							if(j<9){
								shuzu[i][j].append("(0"+(j+1)+""+(i+1)+"01)");
							}else{
								shuzu[i][j].append("("+(j+1)+""+(i+1)+"01)");
							}
						}
					}
				}
				String[] rowValues={"第一层",shuzu[0][0].toString(),shuzu[0][1].toString(),shuzu[0][2].toString(),shuzu[0][3].toString(),
						shuzu[0][4].toString(),shuzu[0][5].toString(),shuzu[0][6].toString(),shuzu[0][7].toString(),shuzu[0][8].toString().toString(),shuzu[0][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues);
				String[] rowValues1={"第二层",shuzu[1][0].toString(),shuzu[1][1].toString(),shuzu[1][2].toString(),shuzu[1][3].toString(),
						shuzu[1][4].toString(),shuzu[1][5].toString(),shuzu[1][6].toString(),shuzu[1][7].toString(),shuzu[1][8].toString(),shuzu[1][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues1);
				String[] rowValues2={"第三层",shuzu[2][0].toString(),shuzu[2][1].toString(),shuzu[2][2].toString(),shuzu[2][3].toString(),
						shuzu[2][4].toString(),shuzu[2][5].toString(),shuzu[2][6].toString(),shuzu[2][7].toString(),shuzu[2][8].toString(),shuzu[2][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues2);
				String[] rowValues3={"第四层",shuzu[3][0].toString(),shuzu[3][1].toString(),shuzu[3][2].toString(),shuzu[3][3].toString(),
						shuzu[3][4].toString(),shuzu[3][5].toString(),shuzu[3][6].toString(),shuzu[3][7].toString(),shuzu[3][8].toString(),shuzu[3][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues3);
				String[] rowValues4={"第五层",shuzu[4][0].toString(),shuzu[4][1].toString(),shuzu[4][2].toString(),shuzu[4][3].toString(),
						shuzu[4][4].toString(),shuzu[4][5].toString(),shuzu[4][6].toString(),shuzu[4][7].toString(),shuzu[4][8].toString(),shuzu[4][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues4);
				String[] rowValues5={"第六层",shuzu[5][0].toString(),shuzu[5][1].toString(),shuzu[5][2].toString(),shuzu[5][3].toString(),
						shuzu[5][4].toString(),shuzu[5][5].toString(),shuzu[5][6].toString(),shuzu[5][7].toString(),shuzu[5][8].toString(),shuzu[5][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues5);
				String[] rowValues6={"第七层",shuzu[6][0].toString(),shuzu[6][1].toString(),shuzu[6][2].toString(),shuzu[6][3].toString(),
						shuzu[6][4].toString(),shuzu[6][5].toString(),shuzu[6][6].toString(),shuzu[6][7].toString(),shuzu[6][8].toString(),shuzu[6][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues6);
				String[] rowValues7={"第八层",shuzu[7][0].toString(),shuzu[7][1].toString(),shuzu[7][2].toString(),shuzu[7][3].toString(),
						shuzu[7][4].toString(),shuzu[7][5].toString(),shuzu[7][6].toString(),shuzu[7][7].toString(),shuzu[7][8].toString(),shuzu[7][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues7);
				String[] rowValues8={"第九层",shuzu[8][0].toString(),shuzu[8][1].toString(),shuzu[8][2].toString(),shuzu[8][3].toString(),
						shuzu[0][4].toString(),shuzu[8][5].toString(),shuzu[8][6].toString(),shuzu[8][7].toString(),shuzu[8][8].toString(),shuzu[8][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues8);
				String[] rowValues9={"第十层",shuzu[9][0].toString(),shuzu[9][1].toString(),shuzu[9][2].toString(),shuzu[9][3].toString(),
						shuzu[9][4].toString(),shuzu[9][5].toString(),shuzu[9][6].toString(),shuzu[9][7].toString(),shuzu[9][8].toString(),shuzu[9][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues9);
				String[] rowValues10={"第十一层",shuzu[10][0].toString(),shuzu[10][1].toString(),shuzu[10][2].toString(),shuzu[10][3].toString(),
						shuzu[10][4].toString(),shuzu[10][5].toString(),shuzu[10][6].toString(),shuzu[10][7].toString(),shuzu[10][8].toString(),shuzu[10][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues10);
				String[] rowValues11={"第十二层",shuzu[11][0].toString(),shuzu[11][1].toString(),shuzu[10][2].toString(),shuzu[11][3].toString(),
						shuzu[11][4].toString(),shuzu[11][5].toString(),shuzu[11][6].toString(),shuzu[11][7].toString(),shuzu[11][8].toString(),shuzu[11][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues11);
				String[] rowValues12={"第十三层",shuzu[12][0].toString(),shuzu[12][1].toString(),shuzu[12][2].toString(),shuzu[12][3].toString(),
						shuzu[12][4].toString(),shuzu[12][5].toString(),shuzu[12][6].toString(),shuzu[12][7].toString(),shuzu[12][8].toString(),shuzu[12][9].toString()};
				((DefaultTableModel) m1).addRow(rowValues12);
			   
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     
		jScrollPane2.setViewportView(ta1);
		jScrollPane2.setBackground(Color.cyan);
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				PreparedStatement prs=null;
				Connection con = null;
				ResultSet rs = null;
				int a1,a2,a3;
				JTable ta1;
				StringBuffer[][] shuzu= new StringBuffer[13][10] ;
				Object[] mc;
				Object[][] data = null;
				int n=1;
				try{
					 n=Integer.parseInt(jTextField2.getText());
				}catch (NumberFormatException e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "请输入正确的架位号");
				}
				mc = new Object[] { " ","第一列", "第二列", "第三列", "第四列", "第五列"
						, "第六列", "第七列" , "第八列" , "第九列" , "第十列"  };
				m1 = new DefaultTableModel(data,mc){
					public boolean isCellEditable(int rowIndex, int columnIndex) {   
					     return false;
					}} ;
				ta1=new JTable(m1);
				ta1.setBackground(Color.cyan);
				ta1.setRowHeight(21);
				con=DBUtil.getConn();
				for(int i=0;i<13;i++){
					for(int j=0;j<10;j++){
						shuzu[i][j]=new StringBuffer("");
					}
				}
				String m=null;
				try {
					String sql="select * from inventory_list where Frame_num="+n+"";
					prs=con.prepareStatement(sql);
					rs=prs.executeQuery();
					if(n<10){
						m="0"+n;
					}else{
						m=n+"";
					}
					while(rs.next()){
						a1=Integer.parseInt(rs.getString("Row"));
						a2=Integer.parseInt(rs.getString("Col"));
						a3=Integer.parseInt(rs.getString("Status"));	
						if(a3==1)
							shuzu[a2-1][a1-1].append("在库");
							else if(a3==0)
								shuzu[a2-1][a1-1].append("不在");
							else
								shuzu[a2-1][a1-1].append("");
							};
							for(int i=0;i<13;i++){
								for(int j=0;j<10;j++){
									if(i<9){
										if(j<9){
											shuzu[i][j].append("(0"+(j+1)+"0"+(i+1)+""+m+")");	
										}else{
											shuzu[i][j].append("("+(j+1)+"0"+(i+1)+""+m+")");
										}
									}else{
										if(j<9){
											shuzu[i][j].append("(0"+(j+1)+""+(i+1)+""+m+")");
										}else{
											shuzu[i][j].append("("+(j+1)+""+(i+1)+""+m+")");
										}
									}
								}
							}
							String[] rowValues={"第一层",shuzu[0][0].toString(),shuzu[0][1].toString(),shuzu[0][2].toString(),shuzu[0][3].toString(),
									shuzu[0][4].toString(),shuzu[0][5].toString(),shuzu[0][6].toString(),shuzu[0][7].toString(),shuzu[0][8].toString().toString(),shuzu[0][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues);
							String[] rowValues1={"第二层",shuzu[1][0].toString(),shuzu[1][1].toString(),shuzu[1][2].toString(),shuzu[1][3].toString(),
									shuzu[1][4].toString(),shuzu[1][5].toString(),shuzu[1][6].toString(),shuzu[1][7].toString(),shuzu[1][8].toString(),shuzu[1][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues1);
							String[] rowValues2={"第三层",shuzu[2][0].toString(),shuzu[2][1].toString(),shuzu[2][2].toString(),shuzu[2][3].toString(),
									shuzu[2][4].toString(),shuzu[2][5].toString(),shuzu[2][6].toString(),shuzu[2][7].toString(),shuzu[2][8].toString(),shuzu[2][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues2);
							String[] rowValues3={"第四层",shuzu[3][0].toString(),shuzu[3][1].toString(),shuzu[3][2].toString(),shuzu[3][3].toString(),
									shuzu[3][4].toString(),shuzu[3][5].toString(),shuzu[3][6].toString(),shuzu[3][7].toString(),shuzu[3][8].toString(),shuzu[3][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues3);
							String[] rowValues4={"第五层",shuzu[4][0].toString(),shuzu[4][1].toString(),shuzu[4][2].toString(),shuzu[4][3].toString(),
									shuzu[4][4].toString(),shuzu[4][5].toString(),shuzu[4][6].toString(),shuzu[4][7].toString(),shuzu[4][8].toString(),shuzu[4][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues4);
							String[] rowValues5={"第六层",shuzu[5][0].toString(),shuzu[5][1].toString(),shuzu[5][2].toString(),shuzu[5][3].toString(),
									shuzu[5][4].toString(),shuzu[5][5].toString(),shuzu[5][6].toString(),shuzu[5][7].toString(),shuzu[5][8].toString(),shuzu[5][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues5);
							String[] rowValues6={"第七层",shuzu[6][0].toString(),shuzu[6][1].toString(),shuzu[6][2].toString(),shuzu[6][3].toString(),
									shuzu[6][4].toString(),shuzu[6][5].toString(),shuzu[6][6].toString(),shuzu[6][7].toString(),shuzu[6][8].toString(),shuzu[6][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues6);
							String[] rowValues7={"第八层",shuzu[7][0].toString(),shuzu[7][1].toString(),shuzu[7][2].toString(),shuzu[7][3].toString(),
									shuzu[7][4].toString(),shuzu[7][5].toString(),shuzu[7][6].toString(),shuzu[7][7].toString(),shuzu[7][8].toString(),shuzu[7][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues7);
							String[] rowValues8={"第九层",shuzu[8][0].toString(),shuzu[8][1].toString(),shuzu[8][2].toString(),shuzu[8][3].toString(),
									shuzu[0][4].toString(),shuzu[8][5].toString(),shuzu[8][6].toString(),shuzu[8][7].toString(),shuzu[8][8].toString(),shuzu[8][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues8);
							String[] rowValues9={"第十层",shuzu[9][0].toString(),shuzu[9][1].toString(),shuzu[9][2].toString(),shuzu[9][3].toString(),
									shuzu[9][4].toString(),shuzu[9][5].toString(),shuzu[9][6].toString(),shuzu[9][7].toString(),shuzu[9][8].toString(),shuzu[9][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues9);
							String[] rowValues10={"第十一层",shuzu[10][0].toString(),shuzu[10][1].toString(),shuzu[10][2].toString(),shuzu[10][3].toString(),
									shuzu[10][4].toString(),shuzu[10][5].toString(),shuzu[10][6].toString(),shuzu[10][7].toString(),shuzu[10][8].toString(),shuzu[10][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues10);
							String[] rowValues11={"第十二层",shuzu[11][0].toString(),shuzu[11][1].toString(),shuzu[10][2].toString(),shuzu[11][3].toString(),
									shuzu[11][4].toString(),shuzu[11][5].toString(),shuzu[11][6].toString(),shuzu[11][7].toString(),shuzu[11][8].toString(),shuzu[11][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues11);
							String[] rowValues12={"第十三层",shuzu[12][0].toString(),shuzu[12][1].toString(),shuzu[12][2].toString(),shuzu[12][3].toString(),
									shuzu[12][4].toString(),shuzu[12][5].toString(),shuzu[12][6].toString(),shuzu[12][7].toString(),shuzu[12][8].toString(),shuzu[12][9].toString()};
							((DefaultTableModel) m1).addRow(rowValues12);
					   
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				jScrollPane2.setViewportView(ta1);
				jScrollPane2.setBackground(Color.cyan);
			}
		});
		javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
				jPanel2);
		jPanel2.setLayout(jPanel2Layout);
		jPanel2Layout
				.setHorizontalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.LEADING)
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addGap(328,
																				328,
																				328)
																		.addComponent(
																				jLabel4,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				63,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addPreferredGap(
																				javax.swing.LayoutStyle.ComponentPlacement.RELATED)
																		.addComponent(
																				jTextField2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				134,
																				javax.swing.GroupLayout.PREFERRED_SIZE)
																		.addGap(38,
																				38,
																				38)
																		.addComponent(
																				jButton3))
														.addGroup(
																jPanel2Layout
																		.createSequentialGroup()
																		.addContainerGap()
																		.addComponent(
																				jScrollPane2,
																				javax.swing.GroupLayout.PREFERRED_SIZE,
																				950,
																				javax.swing.GroupLayout.PREFERRED_SIZE)))
										.addContainerGap(52, Short.MAX_VALUE)));
		jPanel2Layout
				.setVerticalGroup(jPanel2Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								jPanel2Layout
										.createSequentialGroup()
										.addContainerGap()
										.addGroup(
												jPanel2Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jLabel4,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																25,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(
																jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton3))
										.addPreferredGap(
												javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(
												jScrollPane2,
												javax.swing.GroupLayout.PREFERRED_SIZE,
												320,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(
														layout.createSequentialGroup()
																.addGap(12, 12,
																		12)
																.addComponent(
																		jPanel2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(21, 21,
																		21)
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(48, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel2,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JComboBox jComboBox1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	private javax.swing.JTextField jTextField5;
	private javax.swing.JTextField jTextField6;
	// End of variables declaration//GEN-END:variables

}