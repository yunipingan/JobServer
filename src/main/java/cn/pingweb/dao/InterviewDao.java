package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InterviewDao{
	
	public int getUnReadLength(String seeker_id);
	
	public List<Interview> getUnRead(Interview i);
	
	public Interview getInterviewById(Long id);
	
	public int setRead(Long id);

	public int comment(Long id);

	public int insertNewInterview(Interview i);
}
