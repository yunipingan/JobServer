package cn.pingweb.service;

import cn.pingweb.dao.StudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Student Service
 * @author Cloud Lau
 * @company SZU
 * @date 2016年3月5日
 * @description
 */
@Service
public class UploadService {

	@Resource
	private  StudentDao studentDao;	
}
