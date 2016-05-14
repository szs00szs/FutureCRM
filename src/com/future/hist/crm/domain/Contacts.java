package com.future.hist.crm.domain;

import java.util.Date;

import org.jeecgframework.poi.excel.annotation.Excel;
import org.springframework.format.annotation.DateTimeFormat;
/**
 * 联系人
 * @author Administrator
 *
 */
public class Contacts {

	@Excel(name = "联系人contacts,联系人属性contacts", orderNum = "2", needMerge = false, isImportField = "true_teacherEntity,true_courseEntity")
	private Long id;
	
	@Excel(name="联系人姓名",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String name;
	
	@Excel(name="性别",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String sex;
	
	@Excel(name = "出生日期", databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd HH:mm:ss", isImportField = "true_st", width = 20)
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	@Excel(name="部门职务",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String departmentDuties;        //部门职务
	
	@Excel(name="办公室电话",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String officeTelephone;         //办公室电话
	
	@Excel(name="家庭电话",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String homePhone;         
	
	@Excel(name="手机",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String mobilePhone;             //手机
	
	@Excel(name="邮件",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String email;                   //邮件
	
	@Excel(name="邮政编码",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String postCode;                //邮政编码
	
	@Excel(name="QQ",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String QQNumber;                //QQ
	
	@Excel(name="联系地址",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String contactAddress;          //联系地址
	
	@Excel(name="爱好",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String hobby;                   //爱好
	
	@Excel(name="忌讳",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String taboo;                   //忌讳
	
	@Excel(name="备注",orderNum="1",width=25,needMerge=true,isImportField="true")
	private String remark;                  //备注
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getDepartmentDuties() {
		return departmentDuties;
	}
	public void setDepartmentDuties(String departmentDuties) {
		this.departmentDuties = departmentDuties;
	}
	public String getOfficeTelephone() {
		return officeTelephone;
	}
	public void setOfficeTelephone(String officeTelephone) {
		this.officeTelephone = officeTelephone;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getQQNumber() {
		return QQNumber;
	}
	public void setQQNumber(String qQNumber) {
		QQNumber = qQNumber;
	}
	public String getContactAddress() {
		return contactAddress;
	}
	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}
	public String getHobby() {
		return hobby;
	}
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	public String getTaboo() {
		return taboo;
	}
	public void setTaboo(String taboo) {
		this.taboo = taboo;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Contacts [id=" + id + ", name=" + name + ", sex=" + sex + ", birthday=" + birthday
				+ ", departmentDuties=" + departmentDuties + ", officeTelephone=" + officeTelephone + ", homePhone="
				+ homePhone + ", mobilePhone=" + mobilePhone + ", email=" + email + ", postCode=" + postCode
				+ ", QQNumber=" + QQNumber + ", contactAddress=" + contactAddress + ", hobby=" + hobby + ", taboo="
				+ taboo + ", remark=" + remark + "]";
	}
	
}
