package cn.pingweb.seeker;

import cn.pingweb.controller.LoginController;
import cn.pingweb.model.*;
import cn.pingweb.service.*;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("msg")
public class MsgController {
	@Resource
	private ResumeDeliverStatusService rdss;
	@Resource
	private JobInvicationService jis;
	@Resource
	private InterviewService is;
	@Resource
	private LoginController lc;
	
	@ResponseBody
	@RequestMapping("/getUnReadLength")
	public Map<String,Integer> getUnReadLength(String openid) throws JSONException {
		int resumeStatusLength=rdss.getUnReadLength(openid);
		int jobInvicationLength=jis.getUnReadLength(openid);
		int interviewLength=is.getUnReadLength(openid);
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("resumeStatusLength", resumeStatusLength);
		map.put("jobInvicationLength", jobInvicationLength);
		map.put("interviewLength", interviewLength);
		return map;
	}
	
}
