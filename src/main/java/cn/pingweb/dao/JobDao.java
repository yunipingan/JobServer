package cn.pingweb.dao;

import cn.pingweb.model.*;
import net.sf.json.JSON;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public interface JobDao {

	List<String> getSearchRecommand(JSON json);
	
	List<String> getSearchRecommandCompany(JSON json);

	List<Job> getIndexSearch(JSON json,int startIndex,int limitCount);

	List<Job> searchJob(JSON json,int startIndex,int limitCount);

	Job getJobDetailById(Long id);
}
