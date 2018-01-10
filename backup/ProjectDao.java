package cn.pingweb.backup;

import cn.pingweb.model.Project;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProjectDao extends BaseDao<Project> {

	@Override
	public Class<Project> getEntityClass() {
		// TODO Auto-generated method stub
		return Project.class;
	}
	
	public List<Project> getProjects(Project e){
		String sn=getIbatisMapperNamespace() + ".getProjects";
		return getSqlSessionTemplate().selectList(sn, e);
	}
	
	public boolean updateProject(Project e){
		String sn=getIbatisMapperNamespace() + ".updateProject";
		return getSqlSessionTemplate().update(sn, e)==1?true:false;
	}
	
	public boolean deleteProject(Project e){
		String sn=getIbatisMapperNamespace() + ".deleteProject";
		return getSqlSessionTemplate().delete(sn, e)==1?true:false;
	}
	
	public boolean addProject(Project e){
		String sn=getIbatisMapperNamespace() + ".addProject";
		return getSqlSessionTemplate().insert(sn, e)==1?true:false;
	}
	
	public void deleteProjects(Long resume_id){
		String sm=getIbatisMapperNamespace()+".deleteProjects";
		getSqlSessionTemplate().delete(sm, resume_id);
	}
}
