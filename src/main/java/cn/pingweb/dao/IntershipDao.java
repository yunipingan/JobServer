package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class IntershipDao extends BaseDao<Intership>{

	@Override
	public Class<Intership> getEntityClass() {
		// TODO Auto-generated method stub
		return Intership.class;
	}
	
	public List<Intership> getInterships(Intership i){
		String sn=getIbatisMapperNamespace() + ".getInterships";
		return getSqlSessionTemplate().selectList(sn, i);
	}
	
	public boolean updateIntership(Intership i){
		String sn=getIbatisMapperNamespace() + ".updateIntership";
		return getSqlSessionTemplate().update(sn, i)==1?true:false;
	}
	
	public boolean deleteIntership(Intership i){
		String sn=getIbatisMapperNamespace() + ".deleteIntership";
		return getSqlSessionTemplate().delete(sn, i)==1?true:false;
	}
	
	public boolean addIntership(Intership i){
		String sn=getIbatisMapperNamespace() + ".addIntership";
		return getSqlSessionTemplate().insert(sn, i)==1?true:false;
	}
	
	public void deleteInterships(Long resume_id){
		String sm=getIbatisMapperNamespace()+".deleteInterships";
		getSqlSessionTemplate().delete(sm, resume_id);
	}
}
