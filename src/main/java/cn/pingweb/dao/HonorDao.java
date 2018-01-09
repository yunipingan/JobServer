package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class HonorDao extends BaseDao<Honor>{

	@Override
	public Class<Honor> getEntityClass() {
		// TODO Auto-generated method stub
		return Honor.class;
	}
	
	public List<Honor> getHonors(Honor e){
		String sn=getIbatisMapperNamespace() + ".getHonors";
		return getSqlSessionTemplate().selectList(sn, e);
	}
	
	public boolean updateHonor(Honor e){
		String sn=getIbatisMapperNamespace() + ".updateHonor";
		return getSqlSessionTemplate().update(sn, e)==1?true:false;
	}
	
	public boolean deleteHonor(Honor e){
		String sn=getIbatisMapperNamespace() + ".deleteHonor";
		return getSqlSessionTemplate().delete(sn, e)==1?true:false;
	}
	
	public boolean addHonor(Honor e){
		String sn=getIbatisMapperNamespace() + ".addHonor";
		return getSqlSessionTemplate().insert(sn, e)==1?true:false;
	}
	
	public void deleteHonors(Long resume_id){
		String sm=getIbatisMapperNamespace()+".deleteHonors";
		getSqlSessionTemplate().delete(sm, resume_id);
	}
}
