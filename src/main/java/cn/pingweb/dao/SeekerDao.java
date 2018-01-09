package cn.pingweb.dao;

import cn.pingweb.model.Config;
import cn.pingweb.model.Seeker;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository
public class SeekerDao extends BaseDao<Seeker>{
	
	@Resource
	private ConfigDao cd;
	
	@Override
	public Class<Seeker> getEntityClass() {
		// TODO Auto-generated method stub
		return Seeker.class;
	}
	
	public void newSeeker(Seeker s){
		String sn=getIbatisMapperNamespace() + ".selectFromOpenid";
		if(getSqlSessionTemplate().selectOne(sn, s)==null){
			sn=getIbatisMapperNamespace() + ".newSeeker";
			getSqlSessionTemplate().insert(sn, s);
			Config c=new Config();
			c.setSeeker_id(s.getOpenid());
			cd.addConfig(c);
			System.out.println("插入成功");
		}
	}
	
	public Seeker getUserInfo(Seeker s){
		String sn=getIbatisMapperNamespace() + ".selectFromOpenid";
		return getSqlSessionTemplate().selectOne(sn, s);
	}
	
	public boolean updateSeeker(Seeker s){
		String sn=getIbatisMapperNamespace() + ".updateSeeker";
		return getSqlSessionTemplate().update(sn, s)==1?true : false;
	}
	
	public boolean updateAvatar(Seeker s){
		String sn=getIbatisMapperNamespace() + ".updateAvatar";
		return getSqlSessionTemplate().update(sn, s)==1?true : false;
	}
	
	public boolean updateSeekerName(Seeker s){
		String sn=getIbatisMapperNamespace() + ".updateSeekerName";
		return getSqlSessionTemplate().update(sn, s)==1?true : false;
	}
	public boolean updateHope_job(Seeker s){
		String sn=getIbatisMapperNamespace() + ".updateHope_job";
		return getSqlSessionTemplate().update(sn, s)==1?true : false;
	}
}
