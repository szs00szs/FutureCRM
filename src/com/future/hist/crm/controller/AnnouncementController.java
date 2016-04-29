package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
	
	@RequiresPermissions("announcement:list")
	@RequestMapping("/announcement_list")
	public String announcementList(Model model){
		List<Announcement> announcementList = announcementService.getAllAnnouncement();
		model.addAttribute(announcementList);
		return "announcement/announcement_list";
	}
	
	@RequiresPermissions("announcement:detail")
	@RequestMapping("/announcement_detail/{id}")
	public String announcementDetail(@PathVariable("id") long id , Model model){
		Announcement annoucement = announcementService.getAnnouncementById(id);
		model.addAttribute(annoucement);
		return "announcement/announcement_detail";
	}
	
	@RequiresPermissions("announcement:save")
	@RequestMapping(value = "/announcement_saveUI")
	public String saveUI(Map<String, Object> map){
		List<User> userList	 = userService.getAllUser();
		map.put("userList", userList);
		List<Department> departmentList	 = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		return "announcement/saveUI";
	}
	
	@RequiresPermissions("announcement:save")
	@RequestMapping(value = "/announcement_save" )
	public String save(Announcement announcement){
		System.out.println(announcement);
		announcementService.addAnnouncement(announcement);;
		return "redirect:/announcement/announcement_list";
	}
	
	@RequiresPermissions("announcement:update")
	@RequestMapping(value = "/announcement_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		Announcement announcement = announcementService.getAnnouncementById(id);
		List<User> userList	 = userService.getAllUser();
		map.put("userList", userList);
		List<Department> departmentList	 = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		map.put("announcement" , announcement);
		return "announcement/saveUI";
	}
	
	@RequiresPermissions("announcement:update")
	@RequestMapping(value = "/announcement_update" )
	public String update(Announcement announcement){
		System.out.println("announcement : " + announcement);
		announcementService.updateAnnouncement(announcement);;
		return "redirect:/announcement/announcement_list";
	}
				
	@RequiresPermissions("announcement:delete")
	@RequestMapping(value = "/announcement_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		announcementService.deleteAnnouncementById(id);
		return "redirect:/announcement/announcement_list";
	}
	
	@RequiresPermissions("announcement:query")
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
