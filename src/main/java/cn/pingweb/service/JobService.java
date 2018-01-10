package cn.pingweb.service;

import cn.pingweb.dao.*;
import cn.pingweb.model.*;
import net.sf.json.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobService {

	@Resource
	private JobDao jd;

	@Resource
	private JobDutyDao jdd;
	@Resource
	private JobSkillDao jsd;
	@Resource
	private CampusTalkDao ctd;
	@Resource
	private HrDao hd;
	
	public List<Job> getIndexSearch(JSON json,int startIndex,int limitCount){
		return jd.getIndexSearch(json,startIndex,limitCount);
	}

	public List<String> getSearchRecommand(JSON json) {
		List<String> jl=jd.getSearchRecommand(json);
		List<String> cl=jd.getSearchRecommandCompany(json);
		for(int i=0;i<cl.size();i++){
			jl.add(cl.get(i));
		}
		return jl;
	}
	
	public List<Job> searchJob(JSON json,int startIndex,int limitCount){
		return jd.searchJob(json, startIndex, limitCount);
	}
	
	public Job getJobDetailById(Long id){
		Job j = jd.getJobDetailById(id);
		Hr h=new Hr();
		h.setOpenid(j.getHr_id());
		j.setHr(hd.getUserInfo(h));
		j.setJobduty(jdd.getJobDuty(id));
		j.setJobskill(jsd.getJobSkill(id));
		j.setCampustalk(ctd.getCampusTalk(id));
		return j;
	}
}
