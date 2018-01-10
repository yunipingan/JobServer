package cn.pingweb.service;

import cn.pingweb.dao.EducationDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EducationService {

	@Resource
	private EducationDao ed;
	
	public List<Education> getEducations(Education e){
		return ed.getEducations(e);
	}
	
	public boolean updateEducation(Education e){
		return ed.updateEducation(e) == 1 ? true : false;
	}
	
	public boolean deleteEducation(Education e){
		return ed.deleteEducation(e) == 1 ? true : false;
	}
	
	public boolean addEducation(Education e){
		return ed.addEducation(e) == 1 ? true : false;
	}
	
	public void deleteEducations(Long resume_id){
		ed.deleteEducations(resume_id);
	}
}
