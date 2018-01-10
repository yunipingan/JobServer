package cn.pingweb.dao;

import cn.pingweb.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao{

	List<Student> list();
	
	void insert(Student stu);
	
	void update(Student stu);
	
	List<Student> selectById(Student stu);
	
	void delete(Student stu);

}
