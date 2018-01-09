package cn.pingweb.controller;

import cn.pingweb.model.*;
import cn.pingweb.service.*;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("resume")
public class EducationController {
	@Resource
	private EducationService es;	
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getEducations")
	public List<Education> getEducations(long resume_id,HttpServletRequest req){
		Education e=new Education();
		e.setResume_id(resume_id);
		return es.getEducations(e);
	}
	
	@ResponseBody
	@RequestMapping("/updateEducation")
	public boolean updateEducation(String education,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(education);
		Education e=(Education)JSONObject.toBean(jsStr,Education.class);
		return es.updateEducation(e);
	}
	
	@ResponseBody
	@RequestMapping("/deleteEducation")
	public boolean deleteEducation(long id,HttpServletRequest req){
		Education e=new Education();
		e.setId(id);
		return es.deleteEducation(e);
	}
	
	@ResponseBody
	@RequestMapping(value={"/addEducation"},method= RequestMethod.POST)
	public boolean addEducation(String education,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(education);
		Education e=(Education)JSONObject.toBean(jsStr,Education.class);
		return es.addEducation(e);
	}
}
