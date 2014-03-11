package cn.daijia.action;

import java.util.Map;

public class AdminAction {

	public String [*1](){
		[*2] [*3] = [**]Service.[*1]([*4]);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("[*3]", [*3]);
		return SUCCESS;	
	}

	public String getSkljklJlkdByJsdsdid(){
		asdas 4654 = asdasdasdService.getSkljklJlkdByJsdsdid(4654,4654);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("4654", 4654);
		String hql = "from SkljklJlkd sj where sj.jsdsdid=?";
		return SUCCESS;
	}

	public String getHssfsdfKsdfsd(){
		sdfsd 5464 = fgdgService.getHssfsdfKsdfsd(4654,465);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("5464", 5464);
		String hql = "from HssfsdfKsdfsd hk";
		return SUCCESS;
	}

	public String getInfoDriver(){
		List infoDriver = DriverService.getInfoDriver();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("infoDriver", infoDriver);
		return SUCCESS;
	}
}