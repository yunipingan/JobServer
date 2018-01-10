package cn.pingweb.service;

import cn.pingweb.dao.HrDao;
import cn.pingweb.model.Hr;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HrService {

	@Resource
	private  HrDao hd;
	
	public boolean newHr(Hr sk){
		return hd.newHr(sk) == 1 ? true : false;
	}
	
	public Hr getUserInfo(Hr s){
		return hd.getUserInfo(s);
	}
	
	public boolean updateHr(Hr s){
		return hd.updateHr(s) == 1 ? true : false;
	}
	
	public boolean updateAvatar(Hr s){
		return hd.updateAvatar(s) == 1 ? true : false;
	}
	
}