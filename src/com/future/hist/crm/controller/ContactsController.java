package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.ContactService;
import com.future.hist.crm.service.UserService;

/**
 * 联系人Controller层
 * @author 羊羊
 *
 */
@Controller
@RequestMapping("contacts")
public class ContactsController extends BaseController {
	
	/**
	 * 联系人service层
	 */
	@Autowired
	private ContactService contactService;
	
	/**
	 * 用户service层
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 联系人列表
	 * @param map
	 * @return 返回到联系人列表页面
	 */
	@RequiresPermissions("contacts:list")
	@RequestMapping("/contacts_list")
	public String contactsList(Map<String , Object> map){
		//准备数据，得到全部联系人
		List<Contacts> contactsList =contactService.getAllContacts();
		map.put("contactsList", contactsList);
		
		return "contacts/contacts_list";
	}
	
	/**
	 * 联系人详情 
	 * @param map
	 * @param id ； 联系人id
	 * @return 返回到联系人详情也米娜
	 */
	@RequiresPermissions("contacts:detail")
	@RequestMapping("/contacts_detail/{id}")
	public String contactsDetail(Map<String , Object> map ,@PathVariable("id") Long id){
		//通过id得到要查看的联系人信息
		Contacts contacts = contactService.getContactById(id);
		map.put("contacts", contacts);
		
		return "contacts/contacts_detail";
	}
	
	/**
	 * 添加联系人请求
	 * @param map
	 * @return 返回到添加联系人页面
	 */
	@RequiresPermissions("contacts:save")
	@RequestMapping(value = "/contacts_save" , method = RequestMethod.GET)
	public String saveUI(Map<String, Object> map){
		//准备数据（ContactList）
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		//userList
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "contacts/saveUI";
	}
	
//	@RequiresPermissions("contacts:update")
//	@RequestMapping(value = "/contacts_updateUI/{id}")
//	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
//		Contacts contacts = contactService.getContactById(id);
//		List<Contacts> contactsList = contactService.getAllContacts();
//		map.put("contactsList", contactsList);
//		List<User> userList = userService.getAllUser();
//		map.put("userList", userList);
//		map.put("contacts" , contacts);
//		return "contacts/saveUI";
//	}
	
	/**
	 * 添加联系人
	 * @param contacts
	 * @return 返回到联系人列表页面
	 */
	@RequiresPermissions("contacts:save")
	@RequestMapping(value = "/contacts_save" ,method = RequestMethod.POST)
	public String save(Contacts contacts){
		
		contactService.addContact(contacts);
		
		return "redirect:/contacts/contacts_list";
	}
	
	/**
	 * 更新联系人请求
	 * @param id ： 联系人id
	 * @param map
	 * @return 返回到更新联系人页面
	 */
	@RequiresPermissions("contacts:update")
	@RequestMapping(value = "/contacts_update/{id}" , method = RequestMethod.GET)
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		//准备数据，通过id得到要更新的联系人数据
		Contacts contacts = contactService.getContactById(id);
		map.put("contacts" , contacts);
		
//		List<Contacts> contactsList = contactService.getAllContacts();
//		map.put("contactsList", contactsList);
		//userList
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "contacts/saveUI";
	}
	
	/**
	 * 更新联系人
	 * @param contacts
	 * @return 返回到联系人列表页面
	 */
	@RequiresPermissions("contacts:update")
	@RequestMapping(value = "/contacts_update" ,method = RequestMethod.POST )
	public String update(Contacts contacts){
		
		contactService.updateContact(contacts);
		
		return "redirect:/contacts/contacts_list";
	}
				
	/**
	 * 删除联系人
	 * @param id ： 要删除的联系人id
	 * @return 返回到联系人列表页面
	 */
	@RequiresPermissions("contacts:delete")
	@RequestMapping(value = "/contacts_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		
		contactService.deleteContactById(id);
		
		return "redirect:/contacts/contacts_list";
	}
	
	/**
	 * 查找联系人
	 * <p>
	 * 	有三种查询方法：name（联系人姓名）、QQ（联系人QQ）、department Duties（联系人职务）
	 * </p>
	 * @param request
	 * @param map
	 * @return 返回到联系人列表页面
	 */
	@RequiresPermissions("contacts:query")
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		
		List<Contacts> contactsList = new ArrayList<Contacts>();
		Contacts contact = new Contacts();
		
		//TODO 暂定为三种，以后可以添加
		switch (selectType) {
		case "name"://通过name查找联系人，模糊查询
			contactsList = contactService.getContactsByNameLike_(selectContent);
			break;
			
		case "QQ"://通过QQ查找联系人，精确查询
			contact = contactService.getContactByQQ(selectContent);
			contactsList.add(contact);
			break;
			
		case "departmentDuties"://通过departmentDuties查找联系人，模糊查询
			contactsList = contactService.getContactByDepartmentDuties(selectContent);
			break;
			
		default:
			contactsList = contactService.getAllContacts();
			break;
		}
		
		map.put("contactsList", contactsList);
		
		return "contacts/contacts_list";
	}
}
