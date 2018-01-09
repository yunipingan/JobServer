package cn.pingweb.seeker;

import cn.pingweb.controller.LoginController;
import cn.pingweb.model.*;
import cn.pingweb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("jobInvication")
public class JobInvicationController {
	@Resource
	private JobInvicationService jis;	
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getUnReadLength")
	public int getUnReadLength(String openid){
		return jis.getUnReadLength(openid);
	}
	
	@ResponseBody
	@RequestMapping("/getUnRead")
	public List<JobInvication> getUnRead(String openid){
		JobInvication ji=new JobInvication();
		ji.setSeeker_id(openid);
		return jis.getUnRead(ji);
	}
	
	@ResponseBody
	@RequestMapping("/getInvication")
	public JobInvication getInvication(Long id){
		return jis.getInvication(id);
	}
	
	@ResponseBody
	@RequestMapping("/setResult")
	public boolean setResult(Long id,boolean result,String set_resule_date_time){
		JobInvication ji=new JobInvication();
		ji.setResult(result);
		ji.setId(id);
		ji.setSet_resule_date_time(set_resule_date_time);
		return jis.setResult(ji);
	}
	
	@ResponseBody
	@RequestMapping("/setSeekerRead")
	public boolean setSeekerRead(Long id){
		return jis.setSeekerRead(id);
	}
}
