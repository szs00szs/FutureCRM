package com.future.hist.crm.service;

import java.util.List;

import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.User;

public interface NewsService {

	/**
	 * 添加新闻
	 * 
	 * @param news
	 */
	void addNews(News news);

	/**
	 * 通过ID删除新闻
	 * 
	 * @param id
	 */
	void deleteNewsById(long id);

	/**
	 * 通过标题删除新闻
	 * 
	 * @param title
	 */
	void deleteNewsByTitle(String title);

	/**
	 * 通过发布人删除新闻
	 * 
	 * @param issuer
	 */
	void deleteNewsByIssuer(User issuer);

	/**
	 * 更新新闻
	 * 
	 * @param news
	 */
	void updateNews(News news);

	/**
	 * 得到全部新闻
	 * @return
	 */
	List<News> getAllNews();
	
	/**
	 * 得到新闻的个数
	 * @return
	 */
	int getAllNewsCount();
	
	/**
	 * 通过分页得到新闻
	 * @param baseSearch 
	 * @return
	 */
	List<News> getAllNewsByPage(BaseSearch baseSearch);
	
	
	/**
	 * 升序查找所有新闻
	 * @return
	 */
	List<News> getAllNewsByTimeasc();
	
	/**
	 * 降序查找所有新闻
	 * @return
	 */
	List<News> getAllNewsByTimedesc();
	
	/**
	 * 通过ID 得到新闻
	 * 
	 * @param id
	 * @return
	 */
	News getNewsById(long id);

	/**
	 * 通过标题得到新闻
	 * 
	 * @param title
	 * @return
	 */
	News getNewsByTitle(String title);
	
	/**
	 * 通过标题模糊查找得到新闻
	 * @param title
	 * @return
	 */
	List<News>getNewsByTitleLike_(String title);

	/**
	 * 通过发布人得到新闻
	 * 
	 * @param issuer
	 * @return
	 */
	List<News> getNewsByIssuer(User issuer);
	
	/**
	 * 通过新闻类型得到新闻
	 * 
	 * @param newsType
	 * @return
	 */
	List<News> getNewsByNewsType(String newsType);
}