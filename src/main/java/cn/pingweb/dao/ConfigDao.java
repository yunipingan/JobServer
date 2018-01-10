package cn.pingweb.dao;

import cn.pingweb.model.Config;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfigDao {

	
	public void addConfig(Config c);
	
	public int updateConfig(Config c);
	
	public Config getConfig(Config c);
}
