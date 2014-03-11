package cn.daijia.dao;

import cn.daijia.vo.InfoOrder;
import java.util.List;
public interface IInfoOrderDAO {
	public List searchInfoOrder(String hql);
	public List getAllIfoOrder();
	public InfoOrder getOrderByOrdernumber(Integer ordernumber);

}
