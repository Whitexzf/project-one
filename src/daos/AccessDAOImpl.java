package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import beans.AccessBean;
import db.DBUtil;
public class AccessDAOImpl implements AccessDAOinf {
	   private static Connection con = null;
	   private static Statement sta = null;
	   private static PreparedStatement prs = null;
	   private static ResultSet rs = null;
	   //增添存入记录
	   public boolean StuffInterRecord(AccessBean ab) {
		// TODO Auto-generated method stub
			boolean bool = false;
			con=DBUtil.getConn();
			try {
				String sql = "insert into access_list values(null,?,?,?,?,?,?,?)";
				prs=con.prepareStatement(sql);
				prs.setString(1, ab.getLocation());
				prs.setString(2, ab.getPlate_name());
				prs.setString(3, ab.getPlate_id());
				prs.setString(4, ab.getAdmin_name());
				prs.setTimestamp(5, ab.getDateTime());
				prs.setInt(6, ab.getPrint_num());
				prs.setString(7, ab.getStatus());
				int len = prs.executeUpdate();
				if(len > 0) {
					bool = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return bool;
		}
	 //增添取出记录
	public boolean StuffOuterRecord(AccessBean ab) {
		// TODO Auto-generated method stub
		boolean bool = false;
		con=DBUtil.getConn();
		try {
			String sql = "insert into access_list values(null,?,?,?,?,?,?,?)";
			prs=con.prepareStatement(sql);
			prs.setString(1, ab.getLocation());
			prs.setString(2, ab.getPlate_name());
			prs.setString(3, ab.getPlate_id());
			prs.setString(2, ab.getAdmin_name());
			prs.setTimestamp(3, ab.getDateTime());
			prs.setInt(5, ab.getPrint_num());
			prs.setString(6, ab.getStatus());
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;
	}


}

