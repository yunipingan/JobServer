package cn.pingweb.dao;

import cn.pingweb.model.Config;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDao {

	void addConfig(Config c);
	
	int updateConfig(Config c);
	
	Config getConfig(Config c);
}
