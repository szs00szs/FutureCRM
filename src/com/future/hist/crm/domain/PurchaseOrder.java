package com.future.hist.crm.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 进货单
 */
public class PurchaseOrder {

	private Long id;
	private String purchaseNo;// 进货单编号
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime; // 创建日期
	private String remark;
	private int commodityCount;		//商品数量
	private Supplier supplier; // 供货商
	private User user; // 业务员
	private Commodity commodity; // 商品

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	

	public int getCommodityCount() {
		return commodityCount;
	}

	public void setCommodityCount(int commodityCount) {
		this.commodityCount = commodityCount;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	@Override
	public String toString() {
		return "PurchaseOrder [id=" + id + ", purchaseNo=" + purchaseNo + ", createTime=" + createTime + ", remark="
				+ remark + ", commodityCount=" + commodityCount + ", supplier=" + supplier + ", user=" + user
				+ ", commodity=" + commodity + "]";
	}


}
