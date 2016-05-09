package com.future.hist.crm.dao;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.Contacts;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
public interface ContactsMapper {
	/**
	 * 添加联系人
	 * @param contact
	 */
	void addContact(Contacts contact);

	/**
	 * 通过ID删除联系人
	 * @param id
	 */
	void deleteContactById(long id);

	/**
	 * 通过Name删除联系人
	 * @param name
	 */
	void deleteContactByName(String name);

	/**
	 * 更新联系人
	 * @param contact
	 */
	void updateContact(Contacts contact);

	/**
	 * 得到全部联系人
	 * @return
	 */
	List<Contacts> getAllContacts();
	
	/**
	 * 得到联系人总数
	 * @return
	 */
	int getAllContactsCount();
	
	/**
	 * 通过分页得到联系人
	 * @param baseSearch
	 * @return
	 */
	List<Contacts> getAllContactsByPage(BaseSearch baseSearch);
	
	/**
	 * 根据姓名升序
	 * @return
	 */
	List<Contacts> getAllContactsByNameasc();
	
	/**
	 * 得到联系人的个数
	 * @return
	 */
	int getContactsCount();
	
	/**
	 * 通过ID 得到联系人
	 * @param id
	 * @return
	 */
	Contacts getContactById(long id);

	/**
	 * 通过Name得到联系人
	 * @param name
	 * @return
	 */
	Contacts getContactByName(String name);
	
	/**
	 * 通过Name模糊查询得到联系人
	 * @param _parameter
	 * @return
	 */
	List<Contacts> getContactsByNameLike_(String _parameter);

	/**
	 * 通过departmentDuties得到联系人
	 * @param departmentDuties
	 * @return
	 */
	List<Contacts> getContactByDepartmentDuties(String departmentDuties);

	/**
	 * 通过QQ得到联系人
	 * @param QQNumber
	 * @return
	 */
	Contacts getContactByQQ(String QQNumber);
	
}
