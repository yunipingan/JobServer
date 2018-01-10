package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HonorDao{
	
	public List<Honor> getHonors(Honor e);
	
	public int updateHonor(Honor e);

	public int deleteHonor(Honor e);

	public int addHonor(Honor e);
	
	public void deleteHonors(Long resume_id);
}
