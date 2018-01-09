package cn.pingweb.service;

import cn.pingweb.dao.InterviewDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class InterviewService {

	@Resource
	private InterviewDao rdsd;
	
	public int getUnReadLength(String seeker_id){
		return rdsd.getUnReadLength(seeker_id);
	}
	
	public List<Interview> getUnRead(Interview i){
		return rdsd.getUnRead(i);
	}
	
	public Interview getInterviewById(Long id){
		return rdsd.getInterviewById(id);
	}
	
	public boolean setRead(Long id){
		return rdsd.setRead(id);
	}
	
	public boolean comment(Long id){
		return rdsd.comment(id);
	}
	
	public boolean insertNewInterview(Interview i){
		return rdsd.insertNewInterview(i);
	}
}
