package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;


@Repository
public interface HopeDao{
	
	Hope getHope(Hope h);
	
	int updateHope(Hope h);

	int newHope(Hope h);
	
	void deleteHope(Long resume_id);
}
