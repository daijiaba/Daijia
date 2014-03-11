package cn.daijia.service;

import cn.daijia.vo.InfoAccount;

public interface IInfoAccountService {
	public void saveAccount(InfoAccount infoAccount);
	public InfoAccount getAccount(Integer usernumber);
	public void updateAccount(String hql);
	public InfoAccount getAccountByQuestion(String hql);

}
