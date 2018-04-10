package daos;

import java.util.List;
import java.util.Set;

import beans.InventoryBean;

public interface InventoryBeanDAOinf {
		boolean StuffInter(InventoryBean ib);
		boolean StuffOut(InventoryBean ib);
		boolean Stuffadd(InventoryBean ib);
		boolean Stuffdel(InventoryBean ib);
		String selectall(InventoryBean ib);
		List<InventoryBean> getInventoryBeansbyName(String Plant_name);
		InventoryBean selectalln(InventoryBean ib);
		Boolean isout(InventoryBean ib);
		Set<String> getName();
		boolean isin(InventoryBean ib);
		int getin();
		int getout();
		int getnew();
		int getold();
}
