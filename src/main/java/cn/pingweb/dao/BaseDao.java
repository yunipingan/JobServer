package cn.pingweb.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;

import javax.annotation.Resource;

/**
 * DAO基类
 * @author Cloud Lau
 * @company SZU
 * @date 2016年3月5日
 * @description
 */
abstract class BaseDao<M> {
	
	@Resource
	private SqlSessionFactory sqlSessionFactory;
	
	
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	
	SqlSessionFactory getSqlSessionFactory() {
		return this.sqlSessionFactory;
	}

	void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
		this.sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	}
	
	abstract Class<M> getEntityClass();
	
	String getIbatisMapperNamespace() {
		return this.getClass().getName();
	}
	
	SqlSessionTemplate getSqlSessionTemplate() {
		return this.sqlSessionTemplate;
	}
}
