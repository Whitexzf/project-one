package daos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import view.My_MainFrame;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelDAOimpl implements ExcelDAOinf {

	@Override
	public int[][] read() {
		// TODO Auto-generated method stub
		Cell cell=null;
		try {
			Workbook rwb=Workbook.getWorkbook(new File("c:/jp/plc01.xls"));
			Sheet rs= rwb.getSheet(0);
			for(int i=0;i<10;i=i+2){
				for(int j=0;j<7;j++){
					cell=rs.getCell(j,i);
					if(cell.getContents().trim().equals("")){
						My_MainFrame.a[i][j]=-1;
					}else{
					My_MainFrame.a[i][j]=Integer.parseInt(cell.getContents().trim());
					}
				}
			}
			rwb.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return My_MainFrame.a;
	}

	@Override
	public void writer(int a[][]) {
		// TODO Auto-generated method stub
		WritableWorkbook readwb= null;
		try {
	    	  File file=new File("c:/jp/plc01.xls");
	    	  if(!file.exists()){
	    		  file.createNewFile();
	    	  }
		      readwb =Workbook.createWorkbook(file);
		      WritableSheet ws=readwb.createSheet("Sheet1", 0);
		      try {
		      for(int i=0;i<10;i++){
		    	  for(int j=0;j<7;j++){
		    		  Label row=new Label(j, i, a[i][j]+" ");
						ws.addCell(row);
		    	  }
		      }
		        
		        readwb.write();
		        readwb.removeSheet(0);
				readwb.close();
		      } catch (RowsExceededException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (WriteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	       } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

	@Override
	public void readall() {
		// TODO Auto-generated method stub
		Cell cell=null;
		try {
			Workbook rwb=Workbook.getWorkbook(new File("c:/jp/plc01.xls"));
			Sheet rs= rwb.getSheet(0);
			for(int i=0;i<10;i++){
				for(int j=0;j<7;j++){
					cell=rs.getCell(j,i);
					if(cell.getContents().trim().equals("")){
						My_MainFrame.a[i][j]=-1;
					}else{
					My_MainFrame.a[i][j]=Integer.parseInt(cell.getContents().trim());
					}
					}
			}
			rwb.close();
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
