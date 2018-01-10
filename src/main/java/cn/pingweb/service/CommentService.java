package cn.pingweb.service;

import cn.pingweb.dao.CommentDao;
import cn.pingweb.model.Comment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {

	@Resource
	private CommentDao cd;
	
	public List<Comment> getComment(Long job_id, int start, int limit){
		return cd.getComment(job_id,start,limit);
	}
	
	public boolean newComment(Comment c){
		return cd.newComment(c) == 1 ? true : false;
	}
}
