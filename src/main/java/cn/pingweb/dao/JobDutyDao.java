package cn.pingweb.dao;

import cn.pingweb.model.JobDuty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class JobDutyDao extends BaseDao<JobDuty> {
	@Override
	public Class<JobDuty> getEntityClass() {
		// TODO Auto-generated method stub
		return JobDuty.class;
	}
	public List<JobDuty> getJobDuty(Long job_id){
		String sm=getIbatisMapperNamespace()+".getJobDuty";
		List<JobDuty> jobduty=getSqlSessionTemplate().selectList(sm, job_id);
		return jobduty;
	}
}
