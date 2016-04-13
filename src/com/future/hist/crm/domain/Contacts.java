package com.future.hist.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Contacts {

	private Long id;
	private String name;
	private String sex;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	private String departmentDuties;        //部门职务
	private String officeTelephone;         //办公室电话
	private String homePhone;         
	private String mobilePhone;             //手机
	private String email;                   //邮件
	private String postCode;                //邮政编码
	private String QQNumber;                //QQ
	private String contactAddress;          //联系地址
	private String hobby;                   //爱好
	private String taboo;                   //忌讳
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
