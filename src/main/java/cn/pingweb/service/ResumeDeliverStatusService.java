package cn.pingweb.service;

import cn.pingweb.dao.ResumeDeliverStatusDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeDeliverStatusService {

	@Resource
	private ResumeDeliverStatusDao rdsd;
	
	public int getUnReadLength(String seeker_id){
		return rdsd.getUnReadLength(seeker_id);
	}
	
	public List<ResumeDeliverStatus> getUnRead(ResumeDeliverStatus rds){
		return rdsd.getUnRead(rds);
	}
	
	public ResumeDeliverStatus getDeliverRecodeById(Long id){
		return rdsd.getDeliverRecodeById(id);
	}
	
	public boolean setRead(Long id){
		return rdsd.setRead(id);
	}
	
	public boolean deliver(ResumeDeliverStatus rds){
		return rdsd.deliver(rds);
	}
	
	public boolean hadDelivered(ResumeDeliverStatus rds){
		return rdsd.hadDelivered(rds)>0?true:false;
	}
	
	public List<ResumeDeliverStatus> getAll(){
		return rdsd.getAll();
	}
	
	public boolean setResumeStatusRead(ResumeDeliverStatus rds){
		return rdsd.setResumeStatusRead(rds);
	}
	
	public boolean invicate(ResumeDeliverStatus rds){
		return rdsd.invicate(rds);
	}
	
	public boolean reject(ResumeDeliverStatus rds){
		return rdsd.reject(rds);
	}
}
