package cn.pingweb.company;


import cn.pingweb.controller.LoginController;
import cn.pingweb.model.Hr;
import cn.pingweb.service.HrService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("hr")
public class HrController {
	
	@Resource
	private LoginController lc;
	@Resource
	private HrService hs;
	
	
	@RequestMapping(value = {"" , "/"})
	public String index(){
		return "user";
	}
	
	@ResponseBody
	@RequestMapping("/getUserInfo")
	public Hr getUserInfo(String openid,HttpServletRequest req){
		Hr sk= new Hr();
		sk.setOpenid(openid);
		return hs.getUserInfo(sk);
	}
	
	@ResponseBody
	@RequestMapping(value={"/updateHr"},method= RequestMethod.POST)
	public boolean updateHr(String userInfo,String openid,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(userInfo);
		Hr s=(Hr)JSONObject.toBean(jsStr,Hr.class);
		System.out.println("updateHr"+req.getSession().getId());
		System.out.println(s.getSex());
		s.setOpenid(openid);
		return hs.updateHr(s);
	}

	
}
