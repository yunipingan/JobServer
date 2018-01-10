package cn.pingweb.dao;

import cn.pingweb.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentDao{

	public List<Student> list();
	
	public void insert(Student stu);
	
	public void update(Student stu);
	
	public List<Student> selectById(Student stu);
	
	public void delete(Student stu);

}
