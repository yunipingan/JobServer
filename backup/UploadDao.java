package cn.pingweb.backup;

import cn.pingweb.model.Student;
import org.springframework.stereotype.Repository;


@Repository
public class UploadDao extends BaseDao<Student> {

	@Override
	public Class<Student> getEntityClass() {
		// TODO Auto-generated method stub
		return Student.class;
	}
	
}
