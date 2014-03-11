package cn.daijia.service;
import java.util.List;

import cn.daijia.dao.IInfoOrderDAO;
import cn.daijia.service.IInfoOrderService;
import cn.daijia.vo.InfoOrder;
public class InfoOrderService implements IInfoOrderService{
	public IInfoOrderDAO infoOrderDAO;
	public List searchInfoOrder(String hql){
		return infoOrderDAO.searchInfoOrder(hql);
	}
	public List getAllIfoOrder(){
		return infoOrderDAO.getAllIfoOrder();
	}
	public InfoOrder getOrderByOrdernumber(Integer ordernumber){
		return infoOrderDAO.getOrderByOrdernumber(ordernumber);
	}
	public IInfoOrderDAO getInfoOrderDAO() {
		return infoOrderDAO;
	}
	public void setInfoOrderDAO(IInfoOrderDAO infoOrderDAO) {
		this.infoOrderDAO = infoOrderDAO;
	}
	

}
