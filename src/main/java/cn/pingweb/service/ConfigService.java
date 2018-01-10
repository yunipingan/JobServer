package cn.pingweb.service;

import cn.pingweb.dao.ConfigDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ConfigService {

	@Resource
	private ConfigDao cd;
	
	public Config getConfig(Config c){
		return cd.getConfig(c);
	}
	
	public void addConfig(Config c){
		cd.addConfig(c);
	}
	
	public boolean updateConfig(Config c){
		return cd.updateConfig(c) == 1 ? true : false;
	}
}
