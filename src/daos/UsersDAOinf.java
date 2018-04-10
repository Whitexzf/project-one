package daos;

import java.util.List;

import beans.UserBean;

public interface UsersDAOinf {
	 boolean addUserInfo(UserBean u);
     boolean delUserInfoByname(UserBean u);
     boolean logoon(UserBean u);
     boolean isexit(String name);
     boolean update(UserBean u);
     boolean delbyname(String name);
     List<String> getAllUsers();
}
