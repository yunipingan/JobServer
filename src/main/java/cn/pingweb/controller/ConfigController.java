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

@Controller
@RequestMapping("config")
public class ConfigController {
	@Resource
	private ConfigService cs;	
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getConfig")
	public Config getConfig(String openid){
		Config c=new Config();
		c.setSeeker_id(openid);
		return cs.getConfig(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateConfig"},method= RequestMethod.POST)
	public boolean addConfig(String config,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(config);
		Config c=(Config)JSONObject.toBean(jsStr,Config.class);
		return cs.updateConfig(c);
	}
}
