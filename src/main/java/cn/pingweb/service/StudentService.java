package cn.pingweb.service;

import cn.pingweb.dao.StudentDao;
import cn.pingweb.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Student Service
 * @author Cloud Lau
 * @company SZU
 * @date 2016年3月5日
 * @description
 */
@Service
public class StudentService {

	@Resource
	private  StudentDao studentDao;
	
	public List<Student> list(){
		return studentDao.list();
	}
	public void edit(Student stu){
		if(studentDao.selectById(stu).isEmpty()){
			studentDao.insert(stu);
		}else{
			studentDao.update(stu);
		}
	}
	public void delete(Student stu){
		studentDao.delete(stu);
	}
	
}
