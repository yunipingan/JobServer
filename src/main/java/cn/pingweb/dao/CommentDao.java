package cn.pingweb.dao;

import cn.pingweb.model.Comment;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentDao{
	
	public List<Comment> getComment(Long job_id,int start,int limit);
	
	public int newComment(Comment c);
}
