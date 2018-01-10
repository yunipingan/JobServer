package cn.pingweb.service;

import cn.pingweb.dao.HopeDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HopeService {

	@Resource
	private HopeDao hd;
	
	public Hope getHope(Hope h){
		return hd.getHope(h);
	}
	
	public boolean updateHope(Hope h){
		return hd.updateHope(h) == 1 ? true : false;
	}
	
	public boolean newHope(Hope h){
		return hd.newHope(h) == 1 ? true : false;
	}
	
	public void deleteHope(Long resume_id){
		hd.deleteHope(resume_id);
	}
}
