package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Announcement;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.AnnouncementService;
import com.future.hist.crm.service.DepartmentService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {

	@Autowired
	private AnnouncementService announcementService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/announcement_list")
	public String announcementList(Model model){
		List<Announcement> announcementList = announcementService.getAllAnnouncement();
		model.addAttribute(announcementList);
		return "announcement/announcement_list";
	}
	
	@RequestMapping("/announcement_detail/{id}")
	public String announcementDetail(@PathVariable("id") long id , Model model){
		Announcement annoucement = announcementService.getAnnouncementById(id);
		model.addAttribute(annoucement);
		return "announcement/announcement_detail";
	}
	
	@RequestMapping(value = "/announcement_saveUI")
	public String saveUI(){
		return "announcement/saveUI";
	}
	@RequestMapping(value = "/announcement_save" )
	public String save(Announcement announcement){
		System.out.println(announcement);
		System.out.println("the issuer.name is ： " + announcement.getIssuer().getName());
		User issuer = userService.getUserByName(announcement.getIssuer().getName());
		announcement.setIssuer(issuer);
		Department department = departmentService.getDepartmentById(1l);
//		departmentService.getDepartmentByName(announcement.getDepartment().getName());
		announcement.setDepartment(department);
		announcementService.addAnnouncement(announcement);;
		return "redirect:/announcement/announcement_list";
	}
	
	@RequestMapping(value = "/announcement_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		Announcement announcement = announcementService.getAnnouncementById(id);
		map.put("announcement" , announcement);
		return "announcement/saveUI";
	}
	
	@RequestMapping(value = "/announcement_update" )
	public String update(Announcement announcement){
		System.out.println("announcement : " + announcement);
			System.out.println("the issuer.name is : " + announcement.getIssuer().getName()); 
			User issuer = userService.getUserByName(announcement.getIssuer().getName());
			announcement.setIssuer(issuer);
			Department department = departmentService.getDepartmentById(1l);
//			Department department = departmentService.getDepartmentByName(announcement.getDepartment().getName());
			announcement.setDepartment(department);
			announcementService.updateAnnouncement(announcement);;
			return "redirect:/announcement/announcement_list";
	}
				
	@RequestMapping(value = "/announcement_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		announcementService.deleteAnnouncementById(id);
		return "redirect:/announcement/announcement_list";
	}
	
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		System.out.println("the selectType is :" + selectType);
		System.out.println("the selectContent is : " + selectContent);
		List<Announcement> announcementList = new ArrayList<Announcement>();
		switch (selectType) {
		case "title":
			announcementList = announcementService.getAnnouncementByTitleLike_(selectContent);
			break;

		case "issuer":
			List<User> issuerList = userService.getUserByNameLike_(selectContent);
			for(User issuer : issuerList){
				announcementList.addAll(announcementService.getAnnouncementByIssuer(issuer));
			}
			break;
			
		case "department": 
			List<Department> departmentList = departmentService.getAllDepartment();
//			List<Department> departmentList = departmentService.getDepartmentByNameLike_(selectContent);
			for(Department department : departmentList){
				announcementList.addAll(announcementService.getAnnouncementByDepartment(department));
			}
			break;
		default:
			announcementList = announcementService.getAllAnnouncement();
			break;
		}
		map.put("announcementList", announcementList);
		return "announcement/announcement_list";
	}
	
}
