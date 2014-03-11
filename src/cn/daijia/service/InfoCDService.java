package cn.daijia.service;

import java.util.List;

import cn.daijia.dao.IInfoCDDAO;
import cn.daijia.service.IInfoCDService;
import cn.daijia.vo.InfoCD;
public class InfoCDService implements IInfoCDService{
	private IInfoCDDAO infoCDDAO;
	public void saveInfoCD(InfoCD infoCD){
		infoCDDAO.saveInfoCD(infoCD);
	}
	public InfoCD searchInfoCD(String hql){
		return infoCDDAO.searchInfoCD(hql);
	}
	public List getAllInfoCD(){
		return infoCDDAO.getAllInfoCD();
	}
	public List searchInfoCDByHql(String hql){
		return infoCDDAO.searchInfoCDByHql(hql);
	}
	
	public IInfoCDDAO getInfoCDDAO() {
		return infoCDDAO;
	}
	public void setInfoCDDAO(IInfoCDDAO infoCDDAO) {
		this.infoCDDAO = infoCDDAO;
	}
	

}
