package cn.daijia.dao;

import cn.daijia.vo.InfoCD;
import java.util.List;
public interface IInfoCDDAO {
	public void saveInfoCD(InfoCD infoCD); 
	public InfoCD searchInfoCD(String hql);
	public List getAllInfoCD();
	public List searchInfoCDByHql(String hql);

}
