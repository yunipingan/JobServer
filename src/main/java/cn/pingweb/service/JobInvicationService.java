package cn.pingweb.service;

import cn.pingweb.dao.JobInvicationDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobInvicationService {

	@Resource
	private JobInvicationDao jid;
	
	public int getUnReadLength(String seeker_id){
		return jid.getUnReadLength(seeker_id);
	}
	
	public List<JobInvication> getUnRead(JobInvication ji){
		return jid.getUnRead(ji);
	}
	
	public JobInvication getInvication(Long id){
		return jid.getInvication(id);
	}
	
	public boolean setResult(JobInvication ji){
		return jid.setResult(ji) == 1 ? true : false;
	}
	
	public boolean setSeekerRead(Long id){
		return jid.setSeekerRead(id) == 1 ? true : false;
	}
	
	public boolean job_invicate(JobInvication ji){
		return jid.job_invicate(ji) == 1 ? true : false;
	}
}
