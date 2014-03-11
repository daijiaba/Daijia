package cn.daijia.service;

import java.util.List;

import cn.daijia.dao.ITestDao;
import cn.daijia.vo.InfoCustomer;

public class TestService implements ITestService{
	private ITestDao testDao;

	public void saveInfoCustomer(InfoCustomer infoCustomer){
		testDao.saveInfoCustomer(infoCustomer);
	}
	
	
	public ITestDao getTestDao() {
		return testDao;
	}

	public void setTestDao(ITestDao testDao) {
		this.testDao = testDao;
	}

}

