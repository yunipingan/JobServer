package cn.pingweb.service;

import cn.pingweb.dao.SeekerDao;
import cn.pingweb.model.Seeker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SeekerService {

	@Resource
	private SeekerDao sd;
	
	public void newSeeker(Seeker s){
		sd.newSeeker(s);
	}
	
	public Seeker getUserInfo(Seeker s){
		return sd.getUserInfo(s);
	}
	
	public boolean updateSeeker(Seeker s){
		return sd.updateSeeker(s);
	}
	
	public boolean updateAvatar(Seeker s){
		return sd.updateAvatar(s);
	}
	
	public boolean updateHope_job(Seeker s){
		return sd.updateHope_job(s);
	}
	
	public boolean updateSeekerName(Seeker s){
		return sd.updateSeekerName(s);
	}
}
