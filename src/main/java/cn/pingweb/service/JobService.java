package cn.pingweb.service;

import cn.pingweb.dao.JobDao;
import cn.pingweb.model.*;
import net.sf.json.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class JobService {

	@Resource
	private JobDao jd;
	
	public List<Job> getIndexSearch(JSON json,int startIndex,int limitCount){
		return jd.getIndexSearch(json,startIndex,limitCount);
	}

	public List<String> getSearchRecommand(JSON json) {
		return jd.getSearchRecommand(json);
	}
	
	public List<Job> searchJob(JSON json,int startIndex,int limitCount){
		return jd.searchJob(json, startIndex, limitCount);
	}
	
	public Job getJobDetailById(Long id){
		return jd.getJobDetailById(id);
	}
}
