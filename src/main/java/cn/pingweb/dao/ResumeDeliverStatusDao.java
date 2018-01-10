package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResumeDeliverStatusDao{

	public int getUnReadLength(String seeker_id);
	
	public List<ResumeDeliverStatus> getUnRead(ResumeDeliverStatus rds);
	
	public ResumeDeliverStatus getDeliverRecodeById(Long id);
	
	public int setRead(Long id);

	public int deliver(ResumeDeliverStatus rds);

	public int hadDelivered(ResumeDeliverStatus rds);

	public List<ResumeDeliverStatus> getAll();

	public int setResumeStatusRead(ResumeDeliverStatus rds);

	public int invicate(ResumeDeliverStatus rds);

	public int reject(ResumeDeliverStatus rds);
}
