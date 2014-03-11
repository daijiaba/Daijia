package cn.daijia.service;

import cn.daijia.dao.IInfoCustomerDAO;
import cn.daijia.service.IInfoCustomerService;
import cn.daijia.vo.InfoCustomer;

public class InfoCustomerService implements IInfoCustomerService{
	public IInfoCustomerDAO infoCustomerDAO;
	public InfoCustomer validateInfoCustomer(String username,String password){
		return infoCustomerDAO.validateInfoCustomer(username, password);
	}
	public InfoCustomer getUserByUsertel(String usertel){
		return infoCustomerDAO.getUserByUsertel(usertel);
	}
	public InfoCustomer getUserByEmail(String hql){
		return infoCustomerDAO.getUserByEmail(hql);
	}
	public IInfoCustomerDAO getInfoCustomerDAO() {
		return infoCustomerDAO;
	}
	public void setInfoCustomerDAO(IInfoCustomerDAO infoCustomerDAO) {
		this.infoCustomerDAO = infoCustomerDAO;
	}
	

}
