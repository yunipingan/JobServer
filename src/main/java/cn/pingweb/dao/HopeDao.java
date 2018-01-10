package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;


@Repository
public interface HopeDao{
	
	public Hope getHope(Hope h);
	
	public int updateHope(Hope h);

	public int newHope(Hope h);
	
	public void deleteHope(Long resume_id);
}
