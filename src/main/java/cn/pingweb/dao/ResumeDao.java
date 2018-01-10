package cn.pingweb.dao;

import cn.pingweb.model.Resume;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ResumeDao{
	
	public List<Resume> getResumesName(Resume r);
	
	public Resume getResumeById(Resume r);
	
	public int updateResumeName(Resume r);

	public int addNewResume(Resume r);

	public int deleteResume(Resume r);
	
	public Resume getNewestResumeName(Resume r);
	
	public boolean updateSelfAssessment(Resume r);

	public boolean updateHope(Resume r);
}
