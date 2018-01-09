package cn.pingweb.company;

import cn.pingweb.controller.LoginController;
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
public class ProjectController {
	@Resource
	private ProjectService ps;
	
	@ResponseBody
	@RequestMapping("/getProjects")
	public List<Project> getProjects(long resume_id,HttpServletRequest req){
		Project p=new Project();
		p.setResume_id(resume_id);
		return ps.getProjects(p);
	}
	
	@ResponseBody
	@RequestMapping("/updateProject")
	public boolean updateProject(String project,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(project);
		Project p=(Project)JSONObject.toBean(jsStr,Project.class);
		return ps.updateProject(p);
	}
	
	@ResponseBody
	@RequestMapping("/deleteProject")
	public boolean deleteProject(long id,HttpServletRequest req){
		Project p=new Project();
		p.setId(id);
		return ps.deleteProject(p);
	}
	
	@ResponseBody
	@RequestMapping(value={"/addProject"},method= RequestMethod.POST)
	public boolean addProject(String project,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(project);
		Project p=(Project)JSONObject.toBean(jsStr,Project.class);
		return ps.addProject(p);
	}
}
