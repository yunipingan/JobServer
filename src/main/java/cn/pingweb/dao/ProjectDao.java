package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectDao{
	
	List<Project> getProjects(Project e);
	
	int updateProject(Project e);

	int deleteProject(Project e);

	int addProject(Project e);
	
	void deleteProjects(Long resume_id);
}
