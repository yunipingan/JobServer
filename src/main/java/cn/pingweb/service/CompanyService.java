package cn.pingweb.service;

import cn.pingweb.dao.CompanyDao;
import cn.pingweb.model.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CompanyService {

	@Resource
	private CompanyDao id;
	
	public List<Company> getCompanys(Company i){
		return id.getCompanys(i);
	}
	
	public boolean updateCompany(Company i){
		return id.updateCompany(i) == 1 ? true : false;
	}
	
	public boolean deleteCompany(Company i){
		return id.deleteCompany(i) == 1 ? true : false;
	}
	
	public boolean addCompany(Company i){
		return id.addCompany(i) == 1 ? true : false;
	}
}
