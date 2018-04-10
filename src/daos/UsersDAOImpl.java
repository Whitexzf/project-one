package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import beans.UserBean;
import db.DBUtil;

public class UsersDAOImpl implements UsersDAOinf{
	private static Connection con = null;
	private static Statement sta = null;
	private static PreparedStatement prs = null;
	private static ResultSet rs = null;
	@Override
	public boolean addUserInfo(UserBean u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delUserInfoByname(UserBean u) {
		// TODO Auto-generated method stub
		return false;
	}
//  登陆验证
	public boolean logoon(UserBean u) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			con=DBUtil.getConn();
			String sql="select * from admin where Admin_name=? and Admin_pwd=?";
			prs=con.prepareStatement(sql);
			prs.setString(1, u.getUser_name());
			prs.setString(2, u.getUser_pwd());
			rs =prs.executeQuery();
			if(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		return b;
	}

	@Override
	//账号是否存在
	public boolean isexit(String name) {
		// TODO Auto-generated method stub
		boolean b = false;
		try {
			con=DBUtil.getConn();
			String sql="select * from admin where Admin_name='"+name+"'";
			prs=con.prepareStatement(sql);
			rs =prs.executeQuery();
			if(rs.next()){
				b=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		return b;
	
	}

	@Override
	//新增用户
	public boolean update(UserBean u) {
		// TODO Auto-generated method stub
		boolean bool = false;
		con=DBUtil.getConn();
		try {
			String sql = "insert into admin values(null,?,?)";
			prs=con.prepareStatement(sql);
			prs.setString(1, u.getUser_name());
			prs.setString(2, u.getUser_pwd());
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
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
	//依据账号名字删除账号
	public boolean delbyname(String name) {
		// TODO Auto-generated method stub
		boolean bool = false;
		try {
			con=DBUtil.getConn();
			String sql ="delete from admin where Admin_name='"+name+"'";
			prs=con.prepareStatement(sql);
			int len = prs.executeUpdate();
			if(len > 0) {
				bool = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.free(rs, prs, con);
		}
		return bool;
	}

	//获得所有用户的信息
	public List<String> getAllUsers() {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		con=DBUtil.getConn();
		try {
			String sql="select * from admin";
			prs=con.prepareStatement(sql);
			rs=prs.executeQuery();
			String u=null;
			while(rs.next()){
				u=(rs.getString("Admin_name"));
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

}
