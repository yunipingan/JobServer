package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ProjectDao{
	
	public List<Project> getProjects(Project e);
	
	public int updateProject(Project e);

	public int deleteProject(Project e);

	public int addProject(Project e);
	
	public void deleteProjects(Long resume_id);
}
