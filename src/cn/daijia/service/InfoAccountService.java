package cn.daijia.service;

import cn.daijia.service.IInfoAccountService;
import cn.daijia.dao.IInfoAccountDAO;
import cn.daijia.vo.InfoAccount;
public class InfoAccountService implements IInfoAccountService{
	private IInfoAccountDAO infoAccountDAO;
	public void saveAccount(InfoAccount infoAccount){
		infoAccountDAO.saveAccount(infoAccount);
	}
	public InfoAccount getAccount(Integer usernumber){
		return infoAccountDAO.getAccount(usernumber);
	}
	public void updateAccount(String hql){
		infoAccountDAO.updateAccount(hql);
	}
	public InfoAccount getAccountByQuestion(String hql){
		return infoAccountDAO.getAccountByQuestion(hql);
	}
	
	public IInfoAccountDAO getInfoAccountDAO() {
		return infoAccountDAO;
	}
	public void setInfoAccountDAO(IInfoAccountDAO infoAccountDAO) {
		this.infoAccountDAO = infoAccountDAO;
	}
	

}
