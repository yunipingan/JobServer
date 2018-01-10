package cn.pingweb.service;

import cn.pingweb.dao.ConfigDao;
import cn.pingweb.dao.SeekerDao;
import cn.pingweb.model.Config;
import cn.pingweb.model.Seeker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class SeekerService {

	@Resource
	private SeekerDao sd;

	@Resource
	private ConfigDao cd;

	// TODO 回滚事务
	public boolean newSeeker(Seeker s){
		if(sd.selectFromOpenid(s)==null){
			if (sd.newSeeker(s) == 1) {
				Config c=new Config();
				c.setSeeker_id(s.getOpenid());
				cd.addConfig(c);
				return true;
			}
		}
		return false;
	}
	
	public Seeker getUserInfo(Seeker s){
		return sd.getUserInfo(s);
	}
	
	public boolean updateSeeker(Seeker s){
		return sd.updateSeeker(s) == 1 ? true : false;
	}
	
	public boolean updateAvatar(Seeker s){
		return sd.updateAvatar(s) == 1 ? true : false;
	}
	
	public boolean updateHope_job(Seeker s){
		return sd.updateHope_job(s) == 1 ? true : false;
	}
	
	public boolean updateSeekerName(Seeker s){
		return sd.updateSeekerName(s) == 1 ? true : false;
	}
}
