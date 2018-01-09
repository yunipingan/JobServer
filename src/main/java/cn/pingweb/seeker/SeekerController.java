package cn.pingweb.seeker;


import cn.pingweb.controller.LoginController;
import cn.pingweb.model.*;
import cn.pingweb.service.SeekerService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("seeker")
public class SeekerController {
	
	@Resource
	private LoginController lc;
	@Resource
	private SeekerService ss;
	
	
	
	@ResponseBody
	@RequestMapping("/getUserInfo")
	public Seeker getUserInfo(String openid,HttpServletRequest req){
		Seeker sk= new Seeker();
		sk.setOpenid(openid);
		return ss.getUserInfo(sk);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateSeeker"},method= RequestMethod.POST)
	public boolean updateSeeker(String userInfo,String openid,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(userInfo);
		Seeker s=(Seeker)JSONObject.toBean(jsStr,Seeker.class);
		System.out.println("updateSeeker"+req.getSession().getId());
		System.out.println(s.getSex());
		s.setOpenid(openid);
		return ss.updateSeeker(s);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateSeekerName"},method= RequestMethod.POST)
	public boolean updateSeekerName(String name,String openid,HttpServletRequest req){
		Seeker s=new Seeker();
		s.setName(name);
		s.setOpenid(openid);
		return ss.updateSeekerName(s);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateSeekerAvatar"},method= RequestMethod.POST)
	public boolean updateSeekerAvatar(String avatarUrl,String openid,HttpServletRequest req){
		Seeker s=new Seeker();
		s.setAvatarUrl(avatarUrl);
		s.setOpenid(openid);
		return ss.updateAvatar(s);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateHope_job"},method= RequestMethod.POST)
	public boolean updateHope_job(String hope_job,String openid,HttpServletRequest req){
		Seeker s=new Seeker();
		s.setOpenid(openid);
		s.setHope_job(hope_job);
		return ss.updateHope_job(s);
	}
}
