package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HonorDao{
	
	List<Honor> getHonors(Honor e);
	
	int updateHonor(Honor e);

	int deleteHonor(Honor e);

	int addHonor(Honor e);
	
	void deleteHonors(Long resume_id);
}
