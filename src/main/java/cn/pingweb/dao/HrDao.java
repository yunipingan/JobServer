package cn.pingweb.dao;

import cn.pingweb.model.Hr;
import org.springframework.stereotype.Repository;


@Repository
public interface HrDao{
	
//	void newHr(Hr sk){
//		String sn=getIbatisMapperNamespace() + ".selectFromOpenid";
//		if(getSqlSessionTemplate().selectOne(sn, sk)==null){
//			sn=getIbatisMapperNamespace() + ".newHr";
//			getSqlSessionTemplate().insert(sn, sk);
//			System.out.println("插入成功");
//		}
//	}
	int newHr(Hr sk);
	
	Hr getUserInfo(Hr s);
	
	int updateHr(Hr s);

	int updateAvatar(Hr s);

}
