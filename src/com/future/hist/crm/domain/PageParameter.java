package com.future.hist.crm.domain;

/**
 * 分页参数类
 * 
 */
public class PageParameter {

	public static final int DEFAULT_PAGE_SIZE = 10;

	private int pageSize;
	private int currentPage;
	private int prePage;
	private int nextPage;
	private int totalPage;
	private int totalCount;

	private int beginPageIndex; // 页码列表的开始索引（包含）
	private int endPageIndex; // 页码列表的结束索引（包含）

	public PageParameter() {
		this.currentPage = 1;
		this.pageSize = DEFAULT_PAGE_SIZE;
	}

	/**
	 * 
	 * @param currentPage
	 * @param pageSize
	 */
	public PageParameter(int currentPage, int pageSize) {
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public PageParameter(int pageSize, int currentPage, int totalCount) {
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		// 计算总页码
		totalPage = (totalCount + pageSize - 1) / pageSize;

		// 计算 beginPageIndex 和 endPageIndex
		// >> 总页数不多于10页，则全部显示
		if (totalPage <= 10) {

			beginPageIndex = 1;
			endPageIndex = totalPage;
		}
		// >> 总页数多于10页，则显示当前页附近的共10个页码
		else {
			// 当前页附近的共10个页码（前4个 + 当前页 + 后5个）
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			// 当前面的页码不足4个时，则显示前10个页码
			if (beginPageIndex < 1) {
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 当后面的页码不足5个时，则显示后10个页码
			if (endPageIndex > totalPage) {
				endPageIndex = totalPage;
				beginPageIndex = totalPage - 10 + 1;
			}
		}
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPrePage() {
		return prePage;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getBeginPageIndex() {
		return beginPageIndex;
	}

	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}

	public int getEndPageIndex() {
		return endPageIndex;
	}

	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	@Override
	public String toString() {
		return "PageParameter [pageSize=" + pageSize + ", currentPage=" + currentPage + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount
				+ ", beginPageIndex=" + beginPageIndex + ", endPageIndex=" + endPageIndex + "]";
	}

}
