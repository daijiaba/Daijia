package cn.daijia.dao;
import cn.daijia.vo.InfoCustomer;
public interface IInfoCustomerDAO {
	public InfoCustomer validateInfoCustomer(String username,String password);
	public InfoCustomer getUserByUsertel(String usertel);
	public InfoCustomer getUserByEmail(String hql);

}
