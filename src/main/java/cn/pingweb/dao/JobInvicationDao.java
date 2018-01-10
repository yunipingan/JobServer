package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobInvicationDao{
	
	int getUnReadLength(String seeker_id);
	
	List<JobInvication> getUnRead(JobInvication ji);
	
	JobInvication getInvication(Long id);
	
	int setResult(JobInvication ji);

	int setSeekerRead(Long id);

	int job_invicate(JobInvication ji);
}
