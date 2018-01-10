package cn.pingweb.dao;

import cn.pingweb.model.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResumeDao{
	
	List<Resume> getResumesName(Resume r);
	
	Resume getResumeById(Resume r);
	
	int updateResumeName(Resume r);

	int addNewResume(Resume r);

	int deleteResume(Resume r);
	
	Resume getNewestResumeName(Resume r);
	
	boolean updateSelfAssessment(Resume r);

	boolean updateHope(Resume r);
}
