package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.AnnouncementMapper;
import com.future.hist.crm.domain.Announcement;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.AnnouncementService;

/**
 * @author 羊羊
 * @date 2016年4月9日
 */
@Service
public class AnnouncementServiceImpl implements AnnouncementService {

	@Autowired
	private AnnouncementMapper announcementMapper;

	@Override
	public void addAnnouncement(Announcement announcement) {
		announcementMapper.addAnnouncement(announcement);
	}

	@Override
	public void deleteAnnouncementById(long id) {
		announcementMapper.deleteAnnouncementById(id);
	}

	@Override
	public void deleteAnnouncementByTitle(String title) {
		announcementMapper.deleteAnnouncementByTitle(title);
	}
	
	@Override
	public void deleteAnnouncementByIssuer(User issuer) {
		announcementMapper.deleteAnnouncementByIssuer(issuer);
	}

	@Override
	public void updateAnnouncement(Announcement announcement) {
		announcementMapper.updateAnnouncement(announcement);
	}
	
	@Override
	public int getAnnouncementCount(){
		return announcementMapper.getAnnouncementCount();
	}
	
	@Override
	public List<Announcement> getAllAnnouncement(){
		return announcementMapper.getAllAnnouncement();
	}
	
	@Override
	public List<Announcement> getAllAnnouncementByPage(BaseSearch baseSearch){
		return announcementMapper.getAllAnnouncementByPage(baseSearch);
	}

	@Override
	public Announcement getAnnouncementById(long id) {
		return announcementMapper.getAnnouncementById(id);
	}

	@Override
	public Announcement getAnnouncementByTitle(String title) {
		return announcementMapper.getAnnouncementByTitle(title);
	}
	
	public List<Announcement> getAnnouncementByTitleLike_(String title){
		return announcementMapper.getAnnouncementByTitleLike_(title);
	}

	@Override
	public List<Announcement> getAnnouncementByIssuer(User issuer) {
		return announcementMapper.getAnnouncementByIssuer(issuer);
	}
	
	public List<Announcement> getAnnouncementByDepartment(Department department){
		return announcementMapper.getAnnouncementByDepartment(department);
	}

}
