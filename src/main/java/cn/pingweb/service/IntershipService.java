package cn.pingweb.service;

import cn.pingweb.dao.IntershipDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class IntershipService {

	@Resource
	private IntershipDao id;
	
	public List<Intership> getInterships(Intership i){
		return id.getInterships(i);
	}
	
	public boolean updateIntership(Intership i){
		return id.updateIntership(i);
	}
	
	public boolean deleteIntership(Intership i){
		return id.deleteIntership(i);
	}
	
	public boolean addIntership(Intership i){
		return id.addIntership(i);
	}
	public void deleteInterships(Long resume_id){
		id.deleteInterships(resume_id);
	}
}
