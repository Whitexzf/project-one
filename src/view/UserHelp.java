/**
 * 
 */
package view;
import java.awt.AlphaComposite;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/**
 * @author ���ⰻȻ
 *
 */
public class UserHelp extends JPanel{
	private String st[] = {"������","��;"};
	private String data[][] = {
			{"�������","���ڽ����е����İ������ԭ�е�λ��"},
			{"���ȡ��","���ڽ����ڲֿ��еİ��ȡ��"},
			{"�������","���������µİ��"},
			{"���ɾ��","����ɾ�����ֹ��ϻ�����ԭ�������Ҫ�İ��"},
			{"����ѯ","���ڲ�ѯ��ǰ�ֿ��еİ��������"},
			{"��ȡ��¼","���ڼ�¼��ȡ����"},
			{"�������","���ڿ���С��"},
			};;
	/**
	 * 
	 */
	public UserHelp() {
		java.awt.Toolkit tools = this.getToolkit();
		java.awt.Dimension dimension = tools.getScreenSize();

		 TableModel dataModel = new AbstractTableModel() { 
             public int getColumnCount() { return st.length; } 
             public int getRowCount() { return data.length;} 
             public Object getValueAt(int row, int col) {return data[row][col];} 
             public String getColumnName(int column) {return st[column];} 
             public Class getColumnClass(int c) {return getColumnName(c).getClass();} 
 	    public boolean isCellEditable(int row, int col) {return col != 5;} 
             public void setValueAt(Object aValue, int row, int column) { data[row][column] = aValue.toString(); } 
          }; 
         TableRowSorter trs = new TableRowSorter(dataModel);
		JTable table = new JTable(dataModel);
		table.setRowSorter(trs);
		table.getTableHeader().setReorderingAllowed(false);
		table.setRowHeight(30);
		table.setRowMargin(5);
		table.setShowGrid(true);
		table.setShowHorizontalLines(true);
		table.setShowVerticalLines(true);
		table.doLayout();
		table.setSize(dimension);
		table.setVisible(true);
		javax.swing.JScrollPane scrollPane = new javax.swing.JScrollPane(table);
		this.setLayout(new java.awt.BorderLayout());
		this.add(scrollPane,"Center");
		this.setSize(480,320);
		this.validate();
	}

}
