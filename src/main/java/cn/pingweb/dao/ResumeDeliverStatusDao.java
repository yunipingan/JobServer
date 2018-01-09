package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ResumeDeliverStatusDao extends BaseDao<ResumeDeliverStatus>{

	@Override
	public Class<ResumeDeliverStatus> getEntityClass() {
		// TODO Auto-generated method stub
		return ResumeDeliverStatus.class;
	}
	
	public int getUnReadLength(String seeker_id){
		String sm=getIbatisMapperNamespace()+".getUnReadLength";
		return getSqlSessionTemplate().selectOne(sm, seeker_id);
	}
	
	public List<ResumeDeliverStatus> getUnRead(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".getUnRead";
		return getSqlSessionTemplate().selectList(sm, rds);
	}
	
	public ResumeDeliverStatus getDeliverRecodeById(Long id){
		String sm=getIbatisMapperNamespace()+".getDeliverRecodeById";
		return getSqlSessionTemplate().selectOne(sm, id);
	}
	
	public boolean setRead(Long id){
		String sm=getIbatisMapperNamespace()+".setRead";
		return getSqlSessionTemplate().update(sm, id)==1?true:false;
	}
	
	public boolean deliver(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".deliver";
		return getSqlSessionTemplate().insert(sm, rds)==1?true:false;
	}
	
	public int hadDelivered(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".hadDelivered";
		return getSqlSessionTemplate().selectOne(sm,rds);
	}
	
	public List<ResumeDeliverStatus> getAll(){
		String sm=getIbatisMapperNamespace()+".getAll";
		return getSqlSessionTemplate().selectList(sm);
	}
	
	public boolean setResumeStatusRead(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".setResumeStatusRead";
		return getSqlSessionTemplate().update(sm,rds)==1?true:false;
	}
	
	public boolean invicate(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".invicate";
		return getSqlSessionTemplate().update(sm,rds)==1?true:false;
	}
	
	public boolean reject(ResumeDeliverStatus rds){
		String sm=getIbatisMapperNamespace()+".reject";
		return getSqlSessionTemplate().update(sm,rds)==1?true:false;
	}
}
