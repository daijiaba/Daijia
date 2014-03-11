package cn.daijia.service;

import java.util.List;

import cn.daijia.vo.InfoCD;
public interface IInfoCDService {
	public void saveInfoCD(InfoCD infoCD); 
	public InfoCD searchInfoCD(String hql);
	public List getAllInfoCD();
	public List searchInfoCDByHql(String hql);

}
