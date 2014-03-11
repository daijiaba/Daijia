package cn.daijia.service;

import cn.daijia.vo.InfoCustomer;
public interface IInfoCustomerService {
	public InfoCustomer validateInfoCustomer(String username,String password);
	public InfoCustomer getUserByUsertel(String usertel);
	public InfoCustomer getUserByEmail(String hql);

}
