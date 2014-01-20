package cn.daijia.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;

import cn.daijia.dao.ITestDao;
import cn.daijia.vo.InfoCustomer;

@Service
public class TestService implements ITestService{
	@Resource
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

