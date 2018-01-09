package cn.pingweb.seeker;

import cn.pingweb.controller.LoginController;
import cn.pingweb.model.*;
import cn.pingweb.service.*;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("job")
public class JobController {
	@Resource
	private JobService js;	
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getIndexSearch")
	public List<Job> getIndexSearch(String searchConfig,int startIndex,int limitCount){
		JSON json = JSONObject.fromObject(searchConfig);
		System.out.println(json);
		return js.getIndexSearch(json,startIndex,limitCount);
	}
	
	@ResponseBody
	@RequestMapping("/getSearchRecommand")
	public List<String> getSearchRecommand(String job){
		JSON jsStr = JSONObject.fromObject(job);
		System.out.println(jsStr);
		return js.getSearchRecommand(jsStr);
	}
	
	@ResponseBody
	@RequestMapping("/searchJob")
	public List<Job> searchJob(String searchConfig,int startIndex,int limitCount){
		JSON json = JSONObject.fromObject(searchConfig);
		System.out.println(json);
		return js.searchJob(json, startIndex, limitCount);
	}
	
	@ResponseBody
	@RequestMapping("/getJobDetail")
	public Job getJobDetail(Long id){
		return js.getJobDetailById(id);
	}
}
