package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import db.DBUtil;
import beans.InventoryBean;
import beans.SetBean;

public class SetDAOimpl implements SetDAOinf{
	private static DBUtil db = null;
	private static Connection con = null;
	private static Statement sta = null;
	private static PreparedStatement prs = null;
	private static ResultSet rs = null;
	@Override
	public SetBean select(SetBean s) {
		con=DBUtil.getConn();
		SetBean itb = null;
		try {
			
			String sql = "select * from system where NAME='"+s.getName()+"'";
			//��ò������
			prs = con.prepareStatement(sql);
			rs = prs.executeQuery();
			while(rs.next()) {
				itb = new SetBean();
				itb.setName(rs.getString("NAME"));
				itb.setValue(rs.getString("NO"));
			}
			
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs,prs,con);
		}
		return itb;
	}
	@Override
	public boolean del(SetBean s) {
		// TODO Auto-generated method stub
        boolean bool=false;
		con=DBUtil.getConn();
		SetBean itb = null;
		try {
			Date dNow = new Date();   //��ǰʱ��
			Date dBefore = new Date();
			Calendar calendar = Calendar.getInstance(); //�õ�����
			calendar.setTime(dNow);//�ѵ�ǰʱ�丳������
			int n=Integer.parseInt(s.getValue());
			calendar.add(calendar.MONTH, -n);  //����Ϊǰ3��
			dBefore = calendar.getTime();   //�õ�ǰ3�µ�ʱ��

			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //����ʱ���ʽ
			String defaultStartDate = sdf.format(dBefore);
			String sql = "delete from access_list where Datatime < '"+defaultStartDate+"'";
			//��ò������
			prs = con.prepareStatement(sql);
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs,prs,con);
		}
		return bool;
	}
	@Override
	public boolean Update(SetBean s) {
		boolean bool=false;
		con=DBUtil.getConn();
		String sql="Update system set NO='"+s.getValue()+"' where NAME='"+s.getName()+"'";
		try {
			prs=con.prepareStatement(sql);
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs,prs,con);
		}
		
		return bool;
	}

}
