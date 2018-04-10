/*
 * createUserStuffStoreInterFace.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import beans.SetBean;

import daos.SetDAOimpl;
import daos.SetDAOinf;
import db.DBUtil;

/**
 *
 * @author  __USER__
 */
public class createUserStuffStoreInterFace extends javax.swing.JPanel {
	
	public createUserStuffStoreInterFace() throws SQLException {
		SetBean s=new SetBean();
		s.setName("storetime");
		SetDAOinf sd=new SetDAOimpl();
		SetBean sb=new SetBean();
		sb=sd.select(s);
		sd.del(sb);
		initComponents();
		this.setBackground(java.awt.Color.cyan);
	}
	private void initComponents() throws SQLException {
		TableModel m1 = null;
		ResultSet rs = null;
		Object[][] data = null;
		final Object[] mc;
		JTable ta1 = null;
		jPanel1 = new javax.swing.JPanel();
		jTable1 = new javax.swing.JTable();
		jLabel1 = new javax.swing.JLabel();
		mc = new Object[] { "±àºÅ", "Î»ÖÃºÅ", "°å¹÷Ãû³Æ", "°å¹÷ºÅÂë", "²Ù×÷Ô±"
				, "Ê±¼ä", "Ó¡Êý","×´Ì¬"  };
		m1 = new DefaultTableModel(data,mc){
			public boolean isCellEditable(int rowIndex, int columnIndex) {   
			     return false;
			}} ;
		ta1=new JTable(m1);
		ta1.getTableHeader().setBackground(new Color(112,225,240));
		ta1.setBackground(Color.cyan);
		jScrollPane1 = new javax.swing.JScrollPane();
		jScrollPane1.setBackground(Color.cyan);
		String a1,a2,a3,a4,a5,a6,a7,a8;
		Connection con = DBUtil.getConn();
			String sql="select * from access_list";
			PreparedStatement prs = con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				a1=rs.getInt("Id")+"";
				a2=rs.getString("Location");
				a3=rs.getString("Plate_name");
				a4=rs.getString("Plate_id");
				a5=rs.getString("Admin_name");
				a6=rs.getString("Datatime");		
				a7=rs.getString("Print_num");	
				a8=rs.getString("Status");	
				String[] rowValues={a1,a2,a3,a4,a5,a6,a7,a8};
				((DefaultTableModel) m1).addRow(rowValues);
			}
		jScrollPane1.setViewportView(ta1);
		javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
				jPanel1);
		jPanel1.setLayout(jPanel1Layout);
		jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				javax.swing.GroupLayout.Alignment.TRAILING,
				jPanel1Layout
						.createSequentialGroup()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 598,
								Short.MAX_VALUE).addContainerGap()));
		jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				jPanel1Layout
						.createSequentialGroup()
						.addComponent(jScrollPane1,
								javax.swing.GroupLayout.PREFERRED_SIZE,560,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(213, Short.MAX_VALUE)));
		jLabel1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 18));
		jLabel1.setText("´æÈ¡¼ÇÂ¼");
		jScrollPane1.setBackground(Color.cyan);
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
																.addGap(258,
																		258,
																		258)
																.addComponent(
																		jLabel1,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		103,
																		javax.swing.GroupLayout.PREFERRED_SIZE))
												.addGroup(
														layout.createSequentialGroup()
																.addContainerGap()
																.addComponent(
																		jPanel1,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		javax.swing.GroupLayout.DEFAULT_SIZE,
																		Short.MAX_VALUE)))
								.addContainerGap()));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						javax.swing.GroupLayout.Alignment.TRAILING,
						layout.createSequentialGroup()
								.addGap(24, 24, 24)
								.addComponent(jLabel1,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jPanel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)));
	}
	
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable jTable1;
	// End of variables declaration//GEN-END:variables

}