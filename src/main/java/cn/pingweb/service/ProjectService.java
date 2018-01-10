package cn.pingweb.service;

import cn.pingweb.dao.ProjectDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProjectService {

	@Resource
	private ProjectDao pd;
	
	public List<Project> getProjects(Project e){
		return pd.getProjects(e);
	}
	
	public boolean updateProject(Project e){
		return pd.updateProject(e) == 1 ? true : false;
	}
	
	public boolean deleteProject(Project e){
		return pd.deleteProject(e) == 1 ? true : false;
	}
	
	public boolean addProject(Project e){
		return pd.addProject(e) == 1 ? true : false;
	}
	
	public void deleteProjects(Long resume_id){
		pd.deleteProjects(resume_id);
	}
}
