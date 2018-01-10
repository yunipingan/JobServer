package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IntershipDao{
	
	public List<Intership> getInterships(Intership i);
	
	public int updateIntership(Intership i);

	public int deleteIntership(Intership i);

	public int addIntership(Intership i);
	
	public int deleteInterships(Long resume_id);
}
