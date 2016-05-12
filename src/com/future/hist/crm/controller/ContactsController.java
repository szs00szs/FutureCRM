package com.future.hist.crm.controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.PageParameter;
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
	@RequiresPermissions("contacts:view")
	@RequestMapping("/contacts_list/{currentPage}")
	public String contactsList(@PathVariable(value = "currentPage") Integer currentPage, Map<String , Object> map){
		//分页相关数据
		BaseSearch baseSearch = new BaseSearch();
		//公告总页数
		int totalCount = contactService.getAllContactsCount();
		PageParameter pageParameter = new PageParameter(PageParameter.DEFAULT_PAGE_SIZE, currentPage, totalCount);
		
		baseSearch.setPage(pageParameter);
		map.put("pageParameter", pageParameter);
		
		//准备数据，得到全部联系人
		List<Contacts> contactsList =contactService.getAllContactsByPage(baseSearch);
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
		
		//添加后到最后一页，查看添加情况
		int totalCount = contactService.getContactsCount();
		PageParameter pageParameter = new PageParameter();
		int totalPage = (totalCount + pageParameter.getPageSize() - 1) / pageParameter.getPageSize();
		
		return "redirect:/contacts/contacts_list/" + totalPage;
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
		
		return "redirect:/contacts/contacts_list/1";
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
		
		return "redirect:/contacts/contacts_list/1";
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
		
		return "contacts/contacts_list/1";
	}
	
	/**
	 * 导出excel
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequiresPermissions("contacts:export")
	@RequestMapping("/export")
	public String exportExcel(HttpServletResponse response) throws IOException{
		List<Contacts> list = contactService.getAllContacts();
		
		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("联系人列表", "联系人"),Contacts.class,list);
		
		File saveFile = new File("d:/");
		if(!saveFile.exists()){
			saveFile.mkdirs();
		}

		String fileName = "contactsList.xls";
		
		// 定义输出流，以便打开保存对话框______________________begin
		OutputStream os = response.getOutputStream();// 取得输出流
		response.reset();// 清空输出流
		response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("UTF-8"), "UTF-8"));
		// 设定输出文件头
		response.setContentType("application/msexcel");// 定义输出类型
		// 定义输出流，以便打开保存对话框_______________________end
		
		workbook.write(os);
		os.close();
		
//		FileOutputStream fos = new FileOutputStream("d:/test.xls");
//		workbook.write(fos);
//		fos.close();
		
		return "contacts/contacts_list/1";
	}
	
	/**
	 * 导入excel
	 * @param request
	 * @param map
	 * @return
	 */
	@RequiresPermissions("contacts:import")
	@RequestMapping("/import")
	public String importExcel(HttpServletRequest request, Map<String , Object> map){
		System.out.println("in the method");
		
		String filePath = request.getParameter("file");
		System.out.println(filePath);
		
		File file = new File(filePath);
		
		ImportParams params = new ImportParams();
		params.setTitleRows(1);
		params.setHeadRows(1);
		
		List<Contacts> list = ExcelImportUtil.importExcel(file, Contacts.class, params);
		
		System.out.println("the list of imported excel is : " + list.size());
		
		List<Contacts> contactsList = list;
		
		map.put("contactsList", contactsList);
		
		return "contacts/importContactsList/1";
	}
	
	
	/**
	 * 下载导入用户数据模板
	 * @param response
	 * @param redirectAttributes
	 * @return
	 * @throws IOException 
	 */
	@RequiresPermissions("contacts:export")
    @RequestMapping(value = "/import/template")
    public String importFileTemplate(HttpServletResponse response) throws IOException {
            String fileName = "联系人数据导入模板.xls";
    		List<Contacts> list = new ArrayList<>();
    		
    		Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("联系人导入模板", "联系人"),Contacts.class,list);
    		
    		// 定义输出流，以便打开保存对话框______________________begin
    		OutputStream os = response.getOutputStream();// 取得输出流
    		response.reset();// 清空输出流
    		response.setHeader("Content-disposition", "attachment; filename="+ new String(fileName.getBytes("GB2312"), "ISO8859-1"));
    		// 设定输出文件头
    		response.setContentType("application/msexcel");// 定义输出类型
    		// 定义输出流，以便打开保存对话框_______________________end
    		
    		workbook.write(os);
    		os.close();
    		return "contacts/contacts_list/1";
    }
}
