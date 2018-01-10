package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CollectionDao{

	List<Collection> getCollections(Collection c);

	int deleteCollection(Collection c);

	int addCollection(Collection c);
	
	int getCollectionLength(Collection c);
	
	int isStar(Collection c);
	
	int unStar(Collection c);
}
