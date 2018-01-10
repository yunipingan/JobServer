package cn.pingweb.dao;

import cn.pingweb.model.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CompanyDao{

	List<Company> getCompanys(Company c);
	
	int updateCompany(Company e);
	
	int deleteCompany(Company c);

	int addCompany(Company c);
}
