package com.future.hist.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.future.hist.crm.dao.NewsMapper;
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
	
	@Override
	public void addNews(News news) {
		newsMapper.addNews(news);
	}

	@Override
	public void deleteNewsById(long id) {
		newsMapper.deleteNewsById(id);
	}

	@Override
	public void deleteNewsByTitle(String title) {
		newsMapper.deleteNewsByTitle(title);
	}

	@Override
	public void deleteNewsByIssuer(User issuer) {
		newsMapper.deleteNewsByIssuer(issuer);
	}

	@Override
	public void updateNews(News news) {
		newsMapper.updateNews(news);
	}
	
	@Override
	public List<News> getAllNews(){
		return newsMapper.getAllNews();
	}

	@Override
	public News getNewsById(long id) {
		return newsMapper.getNewsById(id);
	}

	@Override
	public News getNewsByTitle(String title) {
		return newsMapper.getNewsByTitle(title);
	}

	@Override
	public List<News> getNewsByIssuer(User issuer) {
		return newsMapper.getNewsByIssuer(issuer);
	}

	@Override
	public List<News> getNewsByNewsType(String newsType) {
		return newsMapper.getNewsByNewsType(newsType);
	}

	@Override
	public List<News> getAllNewsByTimeasc() {
		return newsMapper.getAllNewsByTimeasc();
	}

	@Override
	public List<News> getAllNewsByTimedesc() {
		return newsMapper.getAllNewsByTimedesc();
	}

}
