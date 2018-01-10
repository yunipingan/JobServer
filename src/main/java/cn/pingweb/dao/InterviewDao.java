package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface InterviewDao{
	
	int getUnReadLength(String seeker_id);
	
	List<Interview> getUnRead(Interview i);
	
	Interview getInterviewById(Long id);
	
	int setRead(Long id);

	int comment(Long id);

	int insertNewInterview(Interview i);
}
