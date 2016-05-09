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
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.Announcement;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Department;
import com.future.hist.crm.domain.PageParameter;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.AnnouncementService;
import com.future.hist.crm.service.DepartmentService;
import com.future.hist.crm.service.UserService;

/**
 * 公告controller层
 * @author 羊羊
 * @date 2016年4月11日
 */
@Controller
@RequestMapping("/announcement")
public class AnnouncementController extends BaseController {

	/**
	 * 公告service层
	 */
	@Autowired
	private AnnouncementService announcementService;
	
	/**
	 * 用户service层
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 部门service层
	 */
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * 公告列表
	 * @param model
	 * @return 返回到公告列表页面
	 */
	@RequiresPermissions("announcement:view")
	@RequestMapping("/announcement_list/{currentPage}")
	public String announcementList(@PathVariable(value = "currentPage") Integer currentPage, Model model){
		//分页相关数据
		BaseSearch baseSearch = new BaseSearch();
		//公告总页数
		int totalCount = announcementService.getAnnouncementCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, totalCount);
		
		baseSearch.setPage(pageParameter);
		model.addAttribute("pageParameter", pageParameter);
		
		//查找所有公告
		List<Announcement> announcementList = announcementService.getAllAnnouncementByPage(baseSearch);
		//以model的形式返回数据
		model.addAttribute(announcementList);
		
		//跳转到公告列表页面
		return "announcement/announcement_list";
	}
	
	/**
	 * 公告详情
	 * @param id：公告id
	 * @param model 
	 * @return 返回到公告详情页面
	 */
	@RequiresPermissions("announcement:detail")
	@RequestMapping("/announcement_detail/{id}")
	public String announcementDetail(@PathVariable("id") long id , Model model){
		//通过id得到想查看的公告内容
		Announcement annoucement = announcementService.getAnnouncementById(id);
		
		model.addAttribute(annoucement);
		//跳转到公告详情页面
		return "announcement/announcement_detail";
	}
	
	/**
	 * 添加公告请求
	 * @param map 
	 * @return 返回公告添加页面
	 */
	@RequiresPermissions("announcement:save")
	@RequestMapping(value = "/announcement_save", method=RequestMethod.GET)
	public String saveUI(Map<String, Object> map){
		//准备数据（userList）
		List<User> userList	 = userService.getAllUser();
		map.put("userList", userList);
		//准备数据（departmentList）
		List<Department> departmentList	 = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		
		return "announcement/saveUI";
	}
	
	/**
	 * 添加公告
	 * @param announcement
	 * @return 返回到公告列表
	 */
	@RequiresPermissions("announcement:save")
	@RequestMapping(value = "/announcement_save" )
	public String save(Announcement announcement){
//		System.out.println(announcement);
		
		announcementService.addAnnouncement(announcement);
		
		//添加后返回最后一页，查看添加情况
		int totalCount = announcementService.getAnnouncementCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		return "redirect:/announcement/announcement_list/" + totalPage;
	}
	
	/**
	 * 更新公告请求
	 * @param id 公告id
	 * @param map
	 * @return 返回到更新公告页面
	 */
	@RequiresPermissions("announcement:update")
	@RequestMapping(value = "/announcement_updateUI/{id}/{currentPage}", method=RequestMethod.GET)
	public String updateUI(@PathVariable(value = "id") Long id, @PathVariable(value = "currentPage") Integer currentPage, Map<String, Object> map){
		//通过id得到公告
		Announcement announcement = announcementService.getAnnouncementById(id);
		map.put("announcement" , announcement);
		
		//准备数据（UserList)
		List<User> userList	 = userService.getAllUser();
		map.put("userList", userList);
		//（DepartmentList）
		List<Department> departmentList	 = departmentService.getAllDepartment();
		map.put("departmentList", departmentList);
		
		return "announcement/saveUI";
	}
	
	/**
	 * 更新公告
	 * @param announcement
	 * @return 返回到公告列表页面
	 */
	@RequiresPermissions("announcement:update")
	@RequestMapping(value = "/announcement_update" )
	public String update(Announcement announcement){
//		System.out.println("announcement : " + announcement);
		//更新公告
		announcementService.updateAnnouncement(announcement);;
		
		return "redirect:/announcement/announcement_list/1";
	}
				
	/**
	 * 删除公告
	 * @param id ：公告id
	 * @return 返回到公告列表页面
	 */
	@RequiresPermissions("announcement:delete")
	@RequestMapping(value = "/announcement_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		announcementService.deleteAnnouncementById(id);
		return "redirect:/announcement/announcement_list/1";
	}
	
	/**
	 * 查询公告
	 * <p>
	 * 有三种查询方法：title（公告标题）、issuer（公告发布人）、department（所属部门）
	 * </p>
	 * @param request
	 * @param map
	 * @return 返回公告列表页面
	 */
	@RequiresPermissions("announcement:query")
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		
//		System.out.println("the selectType is :" + selectType);
//		System.out.println("the selectContent is : " + selectContent);
		
		List<Announcement> announcementList = new ArrayList<Announcement>();
		
		switch (selectType) {
		case "title"://通过title查询公告
			announcementList = announcementService.getAnnouncementByTitleLike_(selectContent);
			break;

		case "issuer"://通过issuer查询公告
			List<User> issuerList = userService.getUserByNameLike_(selectContent);
			for(User issuer : issuerList){
				announcementList.addAll(announcementService.getAnnouncementByIssuer(issuer));
			}
			break;
			
		case "department": //通过department查询公告
			List<Department> departmentList = departmentService.getAllDepartment();
			for(Department department : departmentList){
				announcementList.addAll(announcementService.getAnnouncementByDepartment(department));
			}
			break;
			
		default:
			announcementList = announcementService.getAllAnnouncement();
			break;
		}
		map.put("announcementList", announcementList);
		
		return "announcement/announcement_list/1";
	}
	
}
