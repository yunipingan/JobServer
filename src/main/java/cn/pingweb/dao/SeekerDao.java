package cn.pingweb.dao;

import cn.pingweb.model.Config;
import cn.pingweb.model.Seeker;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public interface SeekerDao{

	Seeker selectFromOpenid(Seeker s);
	
	int newSeeker(Seeker s);
	
	Seeker getUserInfo(Seeker s);
	
	int updateSeeker(Seeker s);
	
	int updateAvatar(Seeker s);
	
	int updateSeekerName(Seeker s);

	int updateHope_job(Seeker s);
}
