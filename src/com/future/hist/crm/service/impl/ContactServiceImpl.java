package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.ContactsMapper;
import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.service.ContactService;

/**
 * @author 羊羊
 * @date 2016年4月8日
 */
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	private ContactsMapper contactMapper;
	
	/**
	 * 添加联系人
	 * 
	 * @param contact
	 */
	public void addContact(Contacts contact) {
		contactMapper.addContact(contact);
	}

	/**
	 * 通过ID删除联系人
	 * 
	 * @param id
	 */
	public void deleteContactById(long id) {
		contactMapper.deleteContactById(id);
	}

	/**
	 * 通过Name删除联系人
	 * 
	 * @param name
	 */
	public void deleteContactByName(String name) {
		contactMapper.deleteContactByName(name);
	}

	/**
	 * 更新联系人
	 * 
	 * @param contact
	 */
	public void updateContact(Contacts contact) {
		contactMapper.updateContact(contact);
	}
	
	public List<Contacts> getAllContacts(){
		return contactMapper.getAllContacts();
	}

	/**
	 * 通过ID 得到联系人
	 * 
	 * @param id
	 * @return
	 */
	public Contacts getContactById(long id) {
		return contactMapper.getContactById(id);
	}

	/**
	 * 通过Name得到联系人
	 * 
	 * @param name
	 * @return
	 */
	public Contacts getContactByName(String name) {
		return contactMapper.getContactByName(name);
	}
	
	public List<Contacts> getContactsByNameLike_(String name){
		return contactMapper.getContactsByNameLike_(name);
	}

	/**
	 * 通过departmentDuties得到联系人
	 * 
	 * @param departmentDuties
	 * @return
	 */
	public List<Contacts> getContactByDepartmentDuties(String departmentDuties) {
		return contactMapper.getContactByDepartmentDuties(departmentDuties);
	}

	/**
	 * 通过QQ得到联系人
	 * 
	 * @param QQNumber
	 * @return
	 */
	public Contacts getContactByQQ(String QQNumber) {
		return contactMapper.getContactByQQ(QQNumber);
	}

	@Override
	public List<Contacts> getAllContactsByNameasc() {
		return contactMapper.getAllContactsByNameasc();
	}

	@Override
	public long getContactsCount() {
		return contactMapper.getContactsCount();
	}

}
