package view;

import java.util.Iterator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import daos.InventoryBeanDAOimpl;
import daos.InventoryBeanDAOinf;

import beans.InventoryBean;

public class JTableTest extends JFrame  
{  
    public JTableTest(String Plate_name)  
    {  
        intiComponent(Plate_name);
        this.setSize(1200, 800);
    }  
    /** 
     * 初始化窗体组件 
     */  
    private void intiComponent(String Plate_name)  
    { 
    	TableModel m1;
    	Object[] mc;
    	String[][] data = null;
    	mc = new Object[] {"位置号","印版名称", "印版版号", "色别", "色序", "架号（X）"
				, "列号（Z）", "层号（Y）" , "在库" , "金额" , "新旧","首次入库时间","备注"  };
    	m1 = new DefaultTableModel(data,mc){
			public boolean isCellEditable(int rowIndex, int columnIndex) {   
			     return false;
			}} ;
    	InventoryBeanDAOinf ibd=new InventoryBeanDAOimpl();
    	List<InventoryBean> list=ibd.getInventoryBeansbyName(Plate_name);
    	Iterator<InventoryBean> it=list.iterator();
    	while(it.hasNext()){
    		InventoryBean ib=new InventoryBean();
    		ib=it.next();
    		String[] rowValues={ib.getLocation(),ib.getPlate_name(),ib.getPlate_id()
    				,ib.getColor(),ib.getColor_num(),ib.getFrame_num()+"",ib.getCol()+""
    				,ib.getRow()+"",ib.getState()+"",ib.getAmout()+"",ib.getNature(),ib.getFrist_store_time()+"",ib.getComment()};

    		((DefaultTableModel) m1).addRow(rowValues);
    	}
        JTable table = new JTable(m1);  
        JScrollPane scroll = new JScrollPane(table);  
        add(scroll);  
        this.setVisible(true);  
//        this.setDefaultCloseOperation(JP);  
        this.pack();
     
    }  

} 