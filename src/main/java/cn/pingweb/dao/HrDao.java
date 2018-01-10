package cn.pingweb.dao;

import cn.pingweb.model.Hr;
import org.springframework.stereotype.Repository;


@Repository
public interface HrDao{
	
//	public void newHr(Hr sk){
//		String sn=getIbatisMapperNamespace() + ".selectFromOpenid";
//		if(getSqlSessionTemplate().selectOne(sn, sk)==null){
//			sn=getIbatisMapperNamespace() + ".newHr";
//			getSqlSessionTemplate().insert(sn, sk);
//			System.out.println("插入成功");
//		}
//	}
	public int newHr(Hr sk);
	
	public Hr getUserInfo(Hr s);
	
	public int updateHr(Hr s);

	public int updateAvatar(Hr s);

}
