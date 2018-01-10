package cn.pingweb.dao;

import cn.pingweb.model.JobDuty;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobDutyDao {
	public List<JobDuty> getJobDuty(Long job_id);
}
