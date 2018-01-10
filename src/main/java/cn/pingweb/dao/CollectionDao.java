package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollectionDao{

	List<Collection> getCollections(Collection c);

	public int deleteCollection(Collection c);

	public int addCollection(Collection c);
	
	public int getCollectionLength(Collection c);
	
	public int isStar(Collection c);
	
	public int unStar(Collection c);
}
