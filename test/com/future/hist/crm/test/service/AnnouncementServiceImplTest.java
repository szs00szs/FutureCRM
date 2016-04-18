package com.future.hist.crm.test.service;

import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.hist.crm.domain.Announcement;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.AnnouncementService;
import com.future.hist.crm.service.DepartmentService;
import com.future.hist.crm.service.UserService;

public class AnnouncementServiceImplTest {

	ApplicationContext applicationContext;
	UserService userService;
	DepartmentService departmentService;
	AnnouncementService announcementService;

	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:springbeans.xml");
		userService = applicationContext.getBean(UserService.class);
		departmentService = applicationContext.getBean(DepartmentService.class);
		announcementService = applicationContext.getBean(AnnouncementService.class);
	}

	@Test
	public void testAddAnnouncement() throws ParseException {
		Announcement announcement = new Announcement();
		announcement.setContent("危险公告");
		Department department = departmentService.getDepartmentById(2l);
		announcement.setDepartment(department);
		announcement.setIssue_date(new Date());
		User issuer = userService.getUserById(1l);
		announcement.setIssuer(issuer);
		announcement.setTitle("危险警示");
		
		announcementService.addAnnouncement(announcement);
	}

	@Test
	public void testDeleteAnnouncementById() {
		announcementService.deleteAnnouncementById(8l);
	}

	@Test
	public void testDeleteAnnouncementByTitle() {
		announcementService.deleteAnnouncementByTitle("公告警示");
	}

	@Test
	public void testDeleteAnnouncementByIssuer() {
		announcementService.deleteAnnouncementByIssuer(userService.getUserById(1l));
	}

	@Test
	public void testUpdateAnnouncement() {
		Announcement announcement = announcementService.getAnnouncementById(11l);
		announcement.setDepartment(departmentService.getDepartmentById(1l));;
		
		announcementService.updateAnnouncement(announcement);
	}

	@Test
	public void testGetAllAnnouncement(){
		List<Announcement> list = announcementService.getAllAnnouncement();
		for(Announcement announcement : list){
			System.out.println(announcement);
		}
	}
	
	@Test
	public void testGetAnnouncementById() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAnnouncementByTitle() {
		System.out.println(announcementService.getAnnouncementByTitle("危险警示"));
	}

	@Test
	public void testGetAnnouncementByTitleLike_(){
		List<Announcement> list = announcementService.getAnnouncementByTitleLike_("警");
		for(Announcement announcement : list){
			System.out.println(announcement);
		}
	}
	
	@Test
	public void testGetAnnouncementByIssuer() {
		List<Announcement> list = announcementService.getAnnouncementByIssuer(userService.getUserById(1l));
		for(Announcement announcement : list){
			System.out.println(announcement);
		}
	}

}
