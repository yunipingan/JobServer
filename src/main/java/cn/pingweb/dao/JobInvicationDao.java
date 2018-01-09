package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class JobInvicationDao extends BaseDao<JobInvication>{

	@Override
	public Class<JobInvication> getEntityClass() {
		// TODO Auto-generated method stub
		return JobInvication.class;
	}
	
	public int getUnReadLength(String seeker_id){
		String sm=getIbatisMapperNamespace()+".getUnReadLength";
		return getSqlSessionTemplate().selectOne(sm, seeker_id);
	}
	
	public List<JobInvication> getUnRead(JobInvication ji){
		String sm=getIbatisMapperNamespace()+".getUnRead";
		return getSqlSessionTemplate().selectList(sm, ji);
	}
	
	public JobInvication getInvication(Long id){
		String sm=getIbatisMapperNamespace()+".getInvication";
		return getSqlSessionTemplate().selectOne(sm, id);
	}
	
	public boolean setResult(JobInvication ji){
		String sm=getIbatisMapperNamespace()+".setResult";
		return getSqlSessionTemplate().update(sm, ji)==1?true:false;
	}
	
	public boolean setSeekerRead(Long id){
		String sm=getIbatisMapperNamespace()+".setSeekerRead";
		return getSqlSessionTemplate().update(sm, id)==1?true:false;
	}
	
	public boolean job_invicate(JobInvication ji){
		String sm=getIbatisMapperNamespace()+".job_invicate";
		return getSqlSessionTemplate().insert(sm, ji)==1?true:false;
	}
}
