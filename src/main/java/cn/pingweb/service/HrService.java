package cn.pingweb.service;

import cn.pingweb.dao.HrDao;
import cn.pingweb.model.Hr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HrService {

	@Resource
	private  HrDao hd;
	
	public void newHr(Hr sk){
		hd.newHr(sk);
	}
	
	public Hr getUserInfo(Hr s){
		return hd.getUserInfo(s);
	}
	
	public boolean updateHr(Hr s){
		return hd.updateHr(s);
	}
	
	public boolean updateAvatar(Hr s){
		return hd.updateAvatar(s);
	}
	
}