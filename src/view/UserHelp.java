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
 * @author 春意盎然
 *
 */
public class UserHelp extends JPanel{
	private String st[] = {"按键名","用途"};
	private String data[][] = {
			{"板棍存入","用于将已有档案的板棍存入原有的位置"},
			{"板棍取出","用于将存在仓库中的板棍取出"},
			{"板棍增加","用于增加新的板棍"},
			{"板棍删除","用于删除出现故障货其他原因而不需要的板棍"},
			{"库存查询","用于查询当前仓库中的板棍存放情况"},
			{"存取记录","用于记录存取数据"},
			{"出库入库","用于控制小车"},
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
