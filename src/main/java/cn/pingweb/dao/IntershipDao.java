package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IntershipDao{
	
	List<Intership> getInterships(Intership i);
	
	int updateIntership(Intership i);

	int deleteIntership(Intership i);

	int addIntership(Intership i);
	
	int deleteInterships(Long resume_id);
}
