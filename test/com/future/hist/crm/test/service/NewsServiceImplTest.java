package com.future.hist.crm.test.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.NewsService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
public class NewsServiceImplTest {

	ApplicationContext applicationContext;
	NewsService newsService;
	UserService userService;
	
	@Before
	public void before() {
		applicationContext = new ClassPathXmlApplicationContext("classpath:springbeans.xml");
		newsService = applicationContext.getBean(NewsService.class);
		userService = applicationContext.getBean(UserService.class);
	}

	@Test
	public void testAddNews() {
		News news = new News();
		news.setContent("report");
		news.setIssur_date(new Date());
		
		news.setNewsType("新闻类型2");
		news.setTitle("新闻1");
		
		newsService.addNews(news);
	}

	@Test
	public void testDeleteNewsById() {
		newsService.deleteNewsById(7l);
	}

	@Test
	public void testDeleteNewsByTitle() {
		newsService.deleteNewsByTitle("新闻6");
	}

/*	@Test
	public void testDeleteNewsByIssuer() {
		newsService.deleteNewsByIssuer(userService.getUserById(2l));
	}
*/
	@Test
	public void testUpdateNews() {
		News news = newsService.getNewsById(5l);
		news.setContent("恶劣新闻");
		newsService.updateNews(news);
	}

	@Test
	public void testGetAllNews(){
		List<News> list = newsService.getAllNews();
		for(News news : list){
			System.out.println(news);
			System.out.println(news.getIssur_date());
		}
	}
	
	@Test
	public void testGetNewsById() {
		System.out.println(newsService.getNewsById(1l));
	}

	@Test
	public void testGetNewsByTitle() {
		System.out.println(newsService.getNewsByTitle("新闻4"));
	}
/*
	@Test
	public void testGetNewsByIssuer() {
		List<News> list = newsService.getNewsByIssuer(userService.getUserById(1l));
		for(News news : list){
			System.out.println(news);
		}
	}*/

	@Test
	public void testGetNewsByNewsType() {
		List<News> list = newsService.getNewsByNewsType("新闻类型1");
		for(News news : list){
			System.out.println(news);
		}
	}
	
	@Test
	public void testGetAllNewsByTimeasc(){
		List<News> list = newsService.getAllNewsByTimeasc();
		for(News news : list){
			System.out.println(news);
		}
	}
	
	@Test
	public void testGetAllNewsByTimedesc(){
		List<News> list = newsService.getAllNewsByTimedesc();
		for(News news : list){
			System.out.println(news);
		}
	}

}
