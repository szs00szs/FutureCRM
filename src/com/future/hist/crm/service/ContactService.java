package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.Contacts;

public interface ContactService {

	/**
	 * 添加联系人
	 * 
	 * @param contact
	 */
	void addContact(Contacts contact);

	/**
	 * 通过ID删除联系人
	 * 
	 * @param id
	 */
	void deleteContactById(long id);

	/**
	 * 通过Name删除联系人
	 * 
	 * @param name
	 */
	void deleteContactByName(String name);

	/**
	 * 更新联系人
	 * 
	 * @param contact
	 */
	void updateContact(Contacts contact);

	/**
	 * 得到全部联系人
	 * @return
	 */
	List<Contacts> getAllContacts();
	
	/**
	 * 根据姓名升序
	 * @return
	 */
	List<Contacts> getAllContactsByNameasc();
	
	/**
	 * 得到联系人的个数
	 * @return
	 */
	long getContactsCount();
	
	/**
	 * 通过ID 得到联系人
	 * 
	 * @param id
	 * @return
	 */
	Contacts getContactById(long id);

	/**
	 * 通过Name得到联系人
	 * 
	 * @param name
	 * @return
	 */
	Contacts getContactByName(String name);

	/**
	 * 通过Name模糊查询得到联系人
	 * @param name
	 * @return
	 */
	List<Contacts> getContactsByNameLike_(String name);
	
	/**
	 * 通过departmentDuties得到联系人
	 * 
	 * @param departmentDuties
	 * @return
	 */
	List<Contacts> getContactByDepartmentDuties(String departmentDuties);

	/**
	 * 通过QQ得到联系人
	 * 
	 * @param QQNumber
	 * @return
	 */
	Contacts getContactByQQ(String QQNumber);

}