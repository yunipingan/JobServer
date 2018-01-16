package cn.pingweb.controller.company;

import cn.pingweb.model.*;
import cn.pingweb.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("collection")
public class CollectionController {
	@Resource
	private CollectionService cs;
	
	@ResponseBody
	@RequestMapping("/getCollections")
	public List<Collection> getCollections(String openid,HttpServletRequest req){
		Collection c=new Collection();
		c.setSeeker_id(openid);
		return cs.getCollections(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/deleteCollection"},method= RequestMethod.POST)
	public boolean deleteCollection(long id,HttpServletRequest req){
		Collection c=new Collection();
		c.setId(id);
		return cs.deleteCollection(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/addCollection"},method= RequestMethod.POST)
	public boolean addCollection(String openid,Long job_id,HttpServletRequest req){
		Collection c=new Collection();
		c.setJob_id(job_id);
		c.setSeeker_id(openid);
		return cs.addCollection(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/getCollectionLength"},method= RequestMethod.GET)
	public int getCollectionLength(String openid,HttpServletRequest req){
		Collection c=new Collection();
		c.setSeeker_id(openid);
		return cs.getCollectionLength(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/isStar"},method= RequestMethod.GET)
	public boolean isStar(String openid,Long job_id,HttpServletRequest req){
		Collection c=new Collection();
		c.setSeeker_id(openid);
		c.setJob_id(job_id);
		return cs.isStar(c);
	}
	
	@ResponseBody
	@RequestMapping(value={"/toggleStar"},method= RequestMethod.POST)
	public boolean star(String openid,Long job_id,boolean star,HttpServletRequest req){
		Collection c=new Collection();
		c.setSeeker_id(openid);
		c.setJob_id(job_id);
		return cs.toggleStar(c, star);
	}
}
