package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import beans.InventoryBean;
import beans.UserBean;
import db.DBUtil;

public class InventoryBeanDAOimpl implements InventoryBeanDAOinf{

	private static DBUtil db = null;
	private static Connection con = null;
	private static Statement sta = null;
	private static PreparedStatement prs = null;
	private static ResultSet rs = null;
	//产品存入，存储状态改变
	public boolean StuffInter(InventoryBean ib) {
		// TODO Auto-generated method stub
		boolean bool=false;
		con=DBUtil.getConn();
		String sql =null;
		if(ib.getPlate_id().equals("")){
			 sql="Update inventory_list set Status=1,nature='旧' where Location='"+ib.getLocation()+"'";
		}else{
			 sql="Update inventory_list set Status=1,nature='新',Plate_id='"+ib.getPlate_id()+"' where Location='"+ib.getLocation()+"'";
		}
		try {
			prs=con.prepareStatement(sql);
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(rs,prs,con);
		}
		return bool;
	}
	@Override
	//产品取出，存储状态改变
	public boolean StuffOut(InventoryBean ib) {
		// TODO Auto-generated method stub
		boolean bool=false;
		con=DBUtil.getConn();
		String sql="Update inventory_list set Status=0 where Location='"+ib.getLocation()+"'";
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
	@Override
	//产品增加
	public boolean Stuffadd(InventoryBean ib) {
		// TODO Auto-generated method stub
		con=DBUtil.getConn();
		boolean bool = false;
		try {
			
			String sql = "insert into inventory_list values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			//获得操作句柄
			
			prs = con.prepareStatement(sql);
			prs.setString(1, ib.getLocation());
			prs.setString(2, ib.getPlate_name());
			prs.setString(3, ib.getPlate_id());
			prs.setString(4, ib.getColor());
			prs.setString(5, ib.getColor_num());
			prs.setInt(6, ib.getCol());
			prs.setInt(7,  ib.getRow());
			prs.setInt(8, ib.getFrame_num());
			prs.setInt(9, ib.getState());
			prs.setFloat(10, ib.getAmout());
			prs.setString(11, "新");
			prs.setTimestamp(12, ib.getFrist_store_time());
			prs.setString(13, ib.getComment());
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(prs,con);
		}
		return bool;
	}
	@Override
//	产品删除
	public boolean Stuffdel(InventoryBean ib) {
		// TODO Auto-generated method stub
		con=DBUtil.getConn();
		boolean bool = false;
		try {
			
			String sql = "delete from inventory_list where Location=?";
			//获得操作句柄
			
			prs = con.prepareStatement(sql);
			prs.setString(1, ib.getLocation());
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		}  catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.free(prs,con);
		}
		return bool;
	}
	@Override
	//获得产品的详细信息
	public String selectall(InventoryBean ib) {
		// TODO Auto-generated method stub
		con=DBUtil.getConn();
		StringBuffer sb=new StringBuffer();
		String s=null;
		try {
			String sql="select * from inventory_list where Location='"+ib.getLocation()+"'";
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			rs.next();
			    sb.append("位置号码："+rs.getString("Location")+"\r\n");
			    sb.append("印版名称："+rs.getString("Plate_name")+"\r\n ");
			    sb.append("印版版号："+rs.getString("Plate_id")+"\r\n");
			    sb.append("色别："+rs.getString("Color")+"\r\n");
			    sb.append("色序："+rs.getString("Color_num")+"\r\n");
			    sb.append("金额："+rs.getFloat("Amount")+"\r\n");
			    sb.append("首次存入时间："+rs.getTimestamp("First_Storage_time")+"\r\n");
			    sb.append("备注："+rs.getString("Comment"));
			    s=sb.toString();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		return s;
	}
	@Override
	//获得板棍的详细信息
	public InventoryBean selectalln(InventoryBean ib) {
		con=DBUtil.getConn();
		InventoryBean itb = null;
		try {
			
			String sql = "select * from inventory_list where Location='"+ib.getLocation()+"'";
			//获得操作句柄
			prs = con.prepareStatement(sql);
			rs = prs.executeQuery();
			while(rs.next()) {
				itb = new InventoryBean();
				itb.setLocation(rs.getString("Location"));
				itb.setPlate_name(rs.getString("Plate_name"));
				itb.setPlate_id(rs.getString("Plate_id"));
				itb.setColor(rs.getString("Color"));
				itb.setRow(rs.getInt("Row"));
				itb.setCol(rs.getInt("Col"));
				itb.setColor_num(rs.getString("Color_num"));
				itb.setAmout(rs.getFloat("Amount"));
				itb.setComment(rs.getString("Comment"));
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
	//通过板棍名称查询所有板棍
	public List<InventoryBean> getInventoryBeansbyName(String Plant_name) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		List<InventoryBean> list=new ArrayList<InventoryBean>();
		con=DBUtil.getConn();
		try {
			String sql="select * from inventory_list where plate_name='"+Plant_name+"' order by Color";
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			InventoryBean u=null;
			while(rs.next()){
				u=new InventoryBean();
				u.setLocation(rs.getString("Location"));
				u.setPlate_name(rs.getString("Plate_name"));
				u.setPlate_id(rs.getString("Plate_id"));
				u.setColor(rs.getString("Color"));
				u.setColor_num(rs.getString("Color_num"));
				u.setFrame_num(rs.getInt("Frame_num"));
				u.setCol(rs.getInt("Col"));
				u.setRow(rs.getInt("Row"));
				u.setState(rs.getInt("Status"));
				u.setAmout(rs.getFloat("Amount"));
				u.setNature(rs.getString("nature"));
				u.setFrist_store_time(rs.getTimestamp("First_Storage_time"));
				u.setComment(rs.getString("Comment"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		return list;
	
	}
	@Override
	//获得产品名称
	public Set<String> getName() {
		// TODO Auto-generated method stub
		Set<String> set= new HashSet();
		con=DBUtil.getConn();
		String sql="select Plate_name from inventory_list";
		String ss=null;
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				ss=rs.getString(1);
				set.add(ss);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return set;
	}
	@Override
	public int getin() {
		// TODO Auto-generated method stub
		int sum=0;
		con=DBUtil.getConn();
		String sql="select Status from inventory_list";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==1){
					sum++;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return sum;
	
	}
	@Override
	public int getout() {
		// TODO Auto-generated method stub
		int sum=0;
		con=DBUtil.getConn();
		String sql="select Status from inventory_list";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==0){
					sum++;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return sum;
	}
	@Override
	public int getnew() {
		// TODO Auto-generated method stub
		int sum=0;
		con=DBUtil.getConn();
		String sql="select Nature from inventory_list where Status=1";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals("新")){
					sum++;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return sum;
	}
	@Override
	public int getold() {
		// TODO Auto-generated method stub
		int sum=0;
		con=DBUtil.getConn();
		String sql="select Nature from inventory_list where Status=1";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getString(1).equals("旧")){
					sum++;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return sum;
	}
	@Override
	public boolean isin(InventoryBean ib) {
		// TODO Auto-generated method stub
		boolean bool=false;
		con=DBUtil.getConn();
		String sql="select Status from inventory_list where Location="+ib.getLocation()+"";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==1){
					bool=true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return bool;
	}
	@Override
	public Boolean isout(InventoryBean ib) {
		// TODO Auto-generated method stub
		boolean bool=false;
		con=DBUtil.getConn();
		String sql="select Status from inventory_list where Location="+ib.getLocation()+"";
		try {
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			while(rs.next()){
				if(rs.getInt(1)==0){
					bool=true;
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		
		return bool;
	}

}
