package daos;

import beans.AccessBean;

public interface AccessDAOinf {
       //���Ӳ�Ʒ�����¼
	boolean StuffInterRecord(AccessBean ab);
	   //���Ӳ�Ʒȡ����¼
	boolean StuffOuterRecord(AccessBean ab);
}
