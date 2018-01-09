package cn.pingweb.service;

import cn.pingweb.dao.CollectionDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CollectionService {

	@Resource
	private CollectionDao cd;
	
	public List<Collection> getCollections(Collection c){
		return cd.getCollections(c);
	}
	
	public boolean deleteCollection(Collection c){
		return cd.deleteCollection(c);
	}
	
	public boolean addCollection(Collection c){
		return cd.addCollection(c);
	}
	
	public int getCollectionLength(Collection c){
		return cd.getCollectionLength(c);
	}
	
	public boolean isStar(Collection c){
		return cd.isStar(c)==1?true:false;
	}
	
	public boolean toggleStar(Collection c,boolean star){
		if(star){
			return cd.addCollection(c);
		}else{
			return cd.unStar(c);
		}
	}
}
