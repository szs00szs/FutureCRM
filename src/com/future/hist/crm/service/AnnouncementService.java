package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.Announcement;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;

/**
 * @author 羊羊
 * @date 2016年4月9日
 */
public interface AnnouncementService {
	/**
	 * 添加公告
	 * 
	 * @param announcement
	 */
	void addAnnouncement(Announcement announcement);

	/**
	 * 通过ID 删除公告
	 * 
	 * @param id
	 */
	void deleteAnnouncementById(long id);

	/**
	 * 通过title删除公告
	 * 
	 * @param title
	 */
	void deleteAnnouncementByTitle(String title);

	/**
	 * 通过issuer删除公告
	 * 
	 * @param issuer
	 */
	void deleteAnnouncementByIssuer(User issuer);

	/**
	 * 更新公告
	 * 
	 * @param announcement
	 */
	void updateAnnouncement(Announcement announcement);

	/**
	 * 得到全部的公告
	 * @return
	 */
	List<Announcement> getAllAnnouncement();
	
	/**
	 * 通过ID得到公告
	 * 
	 * @param id
	 * @return
	 */
	Announcement getAnnouncementById(long id);

	/**
	 * 通过title得到公告
	 * 
	 * @param title
	 * @return
	 */
	Announcement getAnnouncementByTitle(String title);
	
	/**
	 * 通过title模糊查询得到公告
	 * @param title
	 * @return
	 */
	List<Announcement> getAnnouncementByTitleLike_(String title);

	/**
	 * 通过issuer得到公告
	 * 
	 * @param issuer
	 * @return
	 */
	List<Announcement> getAnnouncementByIssuer(User issuer);
	
	/**
	 * 通过部门得到公告
	 * @param department
	 * @return
	 */
	List<Announcement> getAnnouncementByDepartment(Department department);
}