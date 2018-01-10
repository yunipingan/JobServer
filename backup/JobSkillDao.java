package cn.pingweb.backup;

import cn.pingweb.model.JobSkill;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobSkillDao extends BaseDao<JobSkill> {
	@Override
	public Class<JobSkill> getEntityClass() {
		// TODO Auto-generated method stub
		return JobSkill.class;
	}
	public List<JobSkill> getJobSkill(Long job_id){
		String sm=getIbatisMapperNamespace()+".getJobSkill";
		return getSqlSessionTemplate().selectList(sm, job_id);
	}
}
