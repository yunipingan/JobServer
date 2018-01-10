package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResumeDeliverStatusDao{

	int getUnReadLength(String seeker_id);
	
	List<ResumeDeliverStatus> getUnRead(ResumeDeliverStatus rds);
	
	ResumeDeliverStatus getDeliverRecodeById(Long id);
	
	int setRead(Long id);

	int deliver(ResumeDeliverStatus rds);

	int hadDelivered(ResumeDeliverStatus rds);

	List<ResumeDeliverStatus> getAll();

	int setResumeStatusRead(ResumeDeliverStatus rds);

	int invicate(ResumeDeliverStatus rds);

	int reject(ResumeDeliverStatus rds);
}
