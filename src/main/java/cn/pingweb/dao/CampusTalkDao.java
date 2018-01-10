package cn.pingweb.dao;

import cn.pingweb.model.CampusTalk;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampusTalkDao {

	List<CampusTalk> getCampusTalk(Long job_id);
}
