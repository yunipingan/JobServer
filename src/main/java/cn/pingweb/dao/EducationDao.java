package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EducationDao{

	List<Education> getEducations(Education e);
	
	int updateEducation(Education e);

	int deleteEducation(Education e);
	
	int addEducation(Education e);
	
	void deleteEducations(Long resume_id);
}
