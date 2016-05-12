package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.NewsMapper;
import com.future.hist.crm.domain.BaseSearch;
import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.NewsService;

/**
 * @author 羊羊
 * @date 2016年4月8日
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;
	
	public void addNews(News news) {
		newsMapper.addNews(news);
	}

	public void deleteNewsById(long id) {
		newsMapper.deleteNewsById(id);
	}

	public void deleteNewsByTitle(String title) {
		newsMapper.deleteNewsByTitle(title);
	}

	public void deleteNewsByIssuer(User issuer) {
		newsMapper.deleteNewsByIssuer(issuer);
	}

	public void updateNews(News news) {
		newsMapper.updateNews(news);
	}
	
	public List<News> getAllNews(){
		return newsMapper.getAllNews();
	}

	public int getAllNewsCount(){
		return newsMapper.getAllNewsCount();
	}
	
	public List<News> getAllNewsByPage(BaseSearch baseSearch){
		return newsMapper.getAllNewsByPage(baseSearch);
	}
	
	public News getNewsById(long id) {
		return newsMapper.getNewsById(id);
	}

	public News getNewsByTitle(String title) {
		return newsMapper.getNewsByTitle(title);
	}
	
	public List<News>getNewsByTitleLike_(String title){
		return newsMapper.getNewsByTitleLike_(title);
	}

	public List<News> getNewsByIssuer(User issuer) {
		return newsMapper.getNewsByIssuer(issuer);
	}
	
	public List<News> getNewsByNewsType(String newsType) {
		return newsMapper.getNewsByNewsType(newsType);
	}

	public List<News> getAllNewsByTimeasc() {
		return newsMapper.getAllNewsByTimeasc();
	}

	public List<News> getAllNewsByTimedesc() {
		return newsMapper.getAllNewsByTimedesc();
	}

}
