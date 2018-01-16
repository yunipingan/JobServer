package cn.pingweb.controller.company;

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
@RequestMapping("company")
public class CompanyController {
	@Resource
	private CompanyService cs;	
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getCompanys")
	public List<Company> getCompanys(long company_id,HttpServletRequest req){
		Company c=new Company();
		c.setId(company_id);
		return cs.getCompanys(c);
	}
	
	@ResponseBody
	@RequestMapping("/updateCompany")
	public boolean updateCompany(String company,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(company);
		Company c=(Company)JSONObject.toBean(jsStr,Company.class);
		return cs.updateCompany(c);
	}
	
	@ResponseBody
	@RequestMapping("/deleteCompany")
	public boolean deleteEducation(long id,HttpServletRequest req){
		Company c=new Company();
		c.setId(id);
		return cs.deleteCompany(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/addCompany"},method= RequestMethod.POST)
	public boolean addEducation(String company,HttpServletRequest req){
		JSONObject jsStr = JSONObject.fromObject(company);
		Company c=(Company)JSONObject.toBean(jsStr,Company.class);
		return cs.addCompany(c);
	}
}
