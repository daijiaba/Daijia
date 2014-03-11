package cn.daijia.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import cn.daijia.service.IServEvaluationService;
import cn.daijia.vo.InfoOrder;
import cn.daijia.vo.ServiceEvaluation;
import cn.daijia.action.InfoOrderAction;
import cn.daijia.action.ServEvaluationAction;

public class AutoEvaluation {
	public ServiceEvaluation servEvaluation;
	public IServEvaluationService servEvaluationService;
	public Integer ordernumber;
	public String evaluationtime;
	public void calculateTime() throws ParseException{
		ServEvaluationAction serv=new ServEvaluationAction();
		InfoOrderAction ifoa=new InfoOrderAction();
		List evas=serv.searchServEvaByStatu();
		for(Iterator it = evas.iterator();it.hasNext();){
			ServiceEvaluation eva=(ServiceEvaluation)it.next();
			ordernumber=eva.getOrdernumber();
			InfoOrder ifod=ifoa.searchOrderByOrdernumber(ordernumber);
			String time=ifod.getOrdertime();
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			evaluationtime=sdf.format(date);
			Date ordertime=sdf.parse(time);
			Date now=sdf.parse(evaluationtime);
			long l=now.getTime()-ordertime.getTime();
			long day=l/(24*60*60*1000);
			if(day>5){
				StringBuffer hql=new StringBuffer("update ServiceEvaluation s set s.status=1, s.score=5, s.information='非常好，我感觉很满意。', s.evaluationtime='"+evaluationtime+"' where s.ordernumber="+ordernumber);
				serv.autoSaveServEva(hql.toString());
			}

	    }
		
	}

}
