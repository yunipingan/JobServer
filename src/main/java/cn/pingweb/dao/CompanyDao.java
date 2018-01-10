package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyDao{

	public List<Company> getCompanys(Company c);
	
	public int updateCompany(Company e);
	
	public int deleteCompany(Company c);

	public int addCompany(Company c);
}
