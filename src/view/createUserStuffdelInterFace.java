/*
 * createUserStuffdelInterFace.java
 *
 * Created on __DATE__, __TIME__
 */

package view;

import javax.swing.JOptionPane;

import daos.InventoryBeanDAOimpl;
import daos.InventoryBeanDAOinf;

import beans.InventoryBean;

/**
 *
 * @author  __USER__
 */
      //板棍删除
public class createUserStuffdelInterFace extends javax.swing.JPanel {

	/** Creates new form createUserStuffdelInterFace */
	public createUserStuffdelInterFace() {
		initComponents();
		this.setBackground(java.awt.Color.cyan);
	}
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		
		panel1 = new java.awt.Panel();
		jTextField1 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		textField1 = new javax.swing.JTextArea();
		button2 =new javax.swing.JButton();
		jTextField1.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jTextField1.setForeground(new java.awt.Color(204, 0, 0));
		jTextField1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField1ActionPerformed(evt);
			}
		});

		jButton1.setText("\u786e\u5b9a");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InventoryBean ib=new InventoryBean();
				ib.setLocation(jTextField1.getText());
				InventoryBeanDAOinf ibd=new InventoryBeanDAOimpl();
				InventoryBean ibb=new InventoryBean();
				ibb=ibd.selectalln(ib);
				if(ibb!=null){
					String s=ibd.selectall(ib);
					textField1.setText(s);
				}else{
					JOptionPane.showMessageDialog(null, "库位号不存在或没有板棍放置");
				}
				
			}
		});

		javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(
				panel1);
		panel1.setLayout(panel1Layout);
		panel1Layout.setHorizontalGroup(panel1Layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				panel1Layout
						.createSequentialGroup()
						.addGap(122, 122, 122)
						.addComponent(jTextField1,
								javax.swing.GroupLayout.DEFAULT_SIZE, 136,
								Short.MAX_VALUE).addGap(69, 69, 69)
						.addComponent(jButton1).addGap(101, 101, 101)));
		panel1Layout
				.setVerticalGroup(panel1Layout
						.createParallelGroup(
								javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(
								panel1Layout
										.createSequentialGroup()
										.addGroup(
												panel1Layout
														.createParallelGroup(
																javax.swing.GroupLayout.Alignment.BASELINE)
														.addComponent(
																jTextField1,
																javax.swing.GroupLayout.PREFERRED_SIZE,
																javax.swing.GroupLayout.DEFAULT_SIZE,
																javax.swing.GroupLayout.PREFERRED_SIZE)
														.addComponent(jButton1))
										.addContainerGap(
												javax.swing.GroupLayout.DEFAULT_SIZE,
												Short.MAX_VALUE)));

		jLabel4.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel4.setText("\u4ea7\u54c1\u8be6\u7ec6\u4fe1\u606f\uff1a");

		jLabel3.setFont(new java.awt.Font("Microsoft YaHei UI", 0, 14));
		jLabel3.setText("\u8bf7\u8f93\u5165\u4ea7\u54c1\u4f4d\u7f6e\u53f7\u7801\uff1a");

		button2.setText("删除");
		button2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				InventoryBean ib=new InventoryBean();
				ib.setLocation(jTextField1.getText());
				InventoryBeanDAOinf ibd=new InventoryBeanDAOimpl();
			    if(ibd.Stuffdel(ib)){
			    	JOptionPane.showMessageDialog(null, "删除成功");
			    }else{
			    	JOptionPane.showMessageDialog(null, "删除成功");
			    }
			}
		});
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
																.addGap(103,
																		103,
																		103)
																.addGroup(
																		layout.createParallelGroup(
																				javax.swing.GroupLayout.Alignment.LEADING,
																				false)
																				.addComponent(
																						jLabel4)
																				.addComponent(
																						panel1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)
																				.addComponent(
																						jLabel3)
																				.addComponent(
																						textField1,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						javax.swing.GroupLayout.DEFAULT_SIZE,
																						Short.MAX_VALUE)))
												.addGroup(
														layout.createSequentialGroup()
																.addGap(298,
																		298,
																		298)
																.addComponent(
																		button2,
																		javax.swing.GroupLayout.PREFERRED_SIZE,
																		68,
																		javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(126, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(jLabel3,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(panel1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel4,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										31,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(
										javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(textField1,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										162,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(25, 25, 25)
								.addComponent(button2,
										javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addContainerGap(98, Short.MAX_VALUE)));
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify

	private javax.swing.JButton button2;
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private java.awt.Panel panel1;
	private javax.swing.JTextArea textField1;
	// End of variables declaration//GEN-END:variables

}