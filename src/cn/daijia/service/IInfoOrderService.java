package cn.daijia.service;
import cn.daijia.vo.InfoOrder;
import java.util.List;
public interface IInfoOrderService {
	public List searchInfoOrder(String hql);
	public List getAllIfoOrder();
	public InfoOrder getOrderByOrdernumber(Integer ordernumber);

}

