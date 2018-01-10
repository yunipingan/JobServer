package cn.pingweb.service;

import cn.pingweb.dao.ResumeDao;
import cn.pingweb.model.Resume;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ResumeService {

	@Resource
	private ResumeDao rd;
	
	public List<Resume> getResumesName(Resume r){
		return rd.getResumesName(r);		
	}
	
	public Resume getResumeById(Resume r){
		return rd.getResumeById(r);
	}
	
	public boolean updateResume(Resume r){
		return rd.updateResumeName(r) == 1 ? true : false;
	}
	
	public boolean addNewResume(Resume r){
		return rd.addNewResume(r) == 1 ? true : false;
	}
	
	public boolean deleteResume(Resume r){
		return rd.deleteResume(r) == 1 ? true : false;
	}
	
	public Resume getNewestResumeName(Resume r){
		return rd.getNewestResumeName(r);
	}
	
	public boolean updateSelfAssessment(Resume r){
		return rd.updateSelfAssessment(r);
	}
	
	public boolean updateHope(Resume r){
		return rd.updateHope(r);
	}
}
