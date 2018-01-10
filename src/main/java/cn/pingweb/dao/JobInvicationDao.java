package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface JobInvicationDao{
	
	public int getUnReadLength(String seeker_id);
	
	public List<JobInvication> getUnRead(JobInvication ji);
	
	public JobInvication getInvication(Long id);
	
	public int setResult(JobInvication ji);

	public int setSeekerRead(Long id);

	public int job_invicate(JobInvication ji);
}
