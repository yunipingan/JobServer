package cn.pingweb.service;

import cn.pingweb.dao.HonorDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HonorService {

	@Resource
	private HonorDao hd;
	
	public List<Honor> getHonors(Honor e){
		return hd.getHonors(e);
	}
	
	public boolean updateHonor(Honor e){
		return hd.updateHonor(e);
	}
	
	public boolean deleteHonor(Honor e){
		return hd.deleteHonor(e);
	}
	
	public boolean addHonor(Honor e){
		return hd.addHonor(e);
	}
	
	public void deleteHonors(Long resume_id){
		hd.deleteHonors(resume_id);
	}
}
