package cn.daijia.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.daijia.dao.IOrderDao;

@Service
public class OrderService implements IOrderService{
	
	@Resource
	IOrderDao orderDao;

	public List getDriverStatus(){
		return orderDao.getDriverStatus();
	}
	
	
	public IOrderDao getOrderDao() {
		return orderDao;
	}
	public void setOrderDao(IOrderDao orderDao) {
		this.orderDao = orderDao;
	}
}
