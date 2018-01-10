package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EducationDao{

	public List<Education> getEducations(Education e);
	
	public int updateEducation(Education e);

	public int deleteEducation(Education e);
	
	public int addEducation(Education e);
	
	public void deleteEducations(Long resume_id);
}
