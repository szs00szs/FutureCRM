package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.ContactService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 *
 */
@Controller
@RequestMapping("contacts")
public class ContactsController extends BaseController {
	
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/contacts_list")
	public String contactsList(Map<String , Object> map){
		List<Contacts> contactsList =contactService.getAllContacts();
		map.put("contactsList", contactsList);
		return "contacts/contacts_list";
	}
	
	@RequestMapping("/contacts_detail/{id}")
	public String contactsDetail(Map<String , Object> map ,@PathVariable("id") Long id){
		Contacts contacts = contactService.getContactById(id);
		System.out.println("the contacts is " + contacts);
		map.put("contacts", contacts);
		return "contacts/contacts_detail";
	}
	
	@RequestMapping(value = "/contacts_saveUI")
	public String saveUI(Map<String, Object> map){
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		return "contacts/saveUI";
	}
	
	@RequestMapping(value = "/contacts_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		Contacts contacts = contactService.getContactById(id);
		List<Contacts> contactsList = contactService.getAllContacts();
		map.put("contactsList", contactsList);
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		map.put("contacts" , contacts);
		return "contacts/saveUI";
	}
	
	@RequestMapping(value = "/contacts_save" )
	public String save(Contacts contacts){
		System.out.println(contacts);
		contactService.addContact(contacts);
		return "redirect:/contacts/contacts_list";
	}
	
	@RequestMapping(value = "/contacts_update" )
	public String update(Contacts contacts){
		System.out.println("contacts : " + contacts);
		contactService.updateContact(contacts);
		return "redirect:/contacts/contacts_list";
	}
				
	@RequestMapping(value = "/contacts_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		contactService.deleteContactById(id);
		return "redirect:/contacts/contacts_list";
	}
	
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		System.out.println("the selectType is :" + selectType);
		System.out.println("the selectContent is : " + selectContent);
		List<Contacts> contactsList = new ArrayList<Contacts>();
		Contacts contact = new Contacts();
		switch (selectType) {
		case "name":
			contactsList = contactService.getContactsByNameLike_(selectContent);
			break;
		case "QQ":
			contact = contactService.getContactByQQ(selectContent);
			contactsList.add(contact);
			break;
		case "departmentDuties":
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
