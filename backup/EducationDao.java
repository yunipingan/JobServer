package cn.pingweb.backup;

import cn.pingweb.model.Education;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class EducationDao extends BaseDao<Education> {

	@Override
	public Class<Education> getEntityClass() {
		// TODO Auto-generated method stub
		return Education.class;
	}
	
	public List<Education> getEducations(Education e){
		String sn=getIbatisMapperNamespace() + ".getEducations";
		return getSqlSessionTemplate().selectList(sn, e);
	}
	
	public boolean updateEducation(Education e){
		String sn=getIbatisMapperNamespace() + ".updateEducation";
		return getSqlSessionTemplate().update(sn, e)==1?true:false;
	}
	
	public boolean deleteEducation(Education e){
		String sn=getIbatisMapperNamespace() + ".deleteEducation";
		return getSqlSessionTemplate().delete(sn, e)==1?true:false;
	}
	
	public boolean addEducation(Education e){
		String sn=getIbatisMapperNamespace() + ".addEducation";
		return getSqlSessionTemplate().insert(sn, e)==1?true:false;
	}
	
	public void deleteEducations(Long resume_id){
		String sm=getIbatisMapperNamespace()+".deleteEducations";
		getSqlSessionTemplate().delete(sm, resume_id);
	}
}
