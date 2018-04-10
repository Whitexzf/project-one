package daos;

import beans.AccessBean;

public interface AccessDAOinf {
       //增加产品存入记录
	boolean StuffInterRecord(AccessBean ab);
	   //增加产品取出记录
	boolean StuffOuterRecord(AccessBean ab);
}
