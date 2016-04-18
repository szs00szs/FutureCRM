package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.hist.crm.domain.Contacts;
import com.future.hist.crm.domain.Customer;
import com.future.hist.crm.domain.News;
import com.future.hist.crm.domain.User;
import com.future.hist.crm.service.NewsService;
import com.future.hist.crm.service.UserService;

/**
 * @author 羊羊
 * @date 2016年4月11日
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{
	
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/news_detail/{title}")
	public String newsDetail(@PathVariable("title") String title , Model model){
		News news = newsService.getNewsByTitle(title);
		model.addAttribute(news);
		return "news/news_detail";
	}
	
	@RequestMapping("/news_list")
	public String newsList(Map<String , Object> map){
		List<News> newsList = newsService.getAllNewsByTimedesc();
		map.put("newsList", newsList);
		return "news/news_list";
	}

	@RequestMapping(value = "/news_saveUI")
	public String saveUI(){
		return "news/saveUI";
	}
	@RequestMapping(value = "/news_save" )
	public String save(News news){
		System.out.println(news);
		System.out.println("the issuer.name is ： " + news.getIssuer().getName());
		User issuer = new User();
		issuer.setId(1l);
		issuer.setName("张三");
		news.setIssuer(issuer);
		newsService.addNews(news);
		return "redirect:/news/news_list";
	}
	
	@RequestMapping(value = "/news_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		News news = newsService.getNewsById(id);
		map.put("news" , news);
		return "news/saveUI";
	}
	
	@RequestMapping(value = "/news_update" )
	public String update(News news){
		System.out.println("news : " + news);
			System.out.println("the issuer.id is : " + news.getIssuer().getId()); 
//			System.out.println("the user can get from database is : " + userService.getUserById(news.getIssuer().getId().toString()));
			System.out.println(news.getIssur_date());
			User issuer = new User();
			issuer.setId(1l);
			issuer.setName("张三");
			news.setIssuer(issuer);
			newsService.updateNews(news);
			return "redirect:/news/news_list";
	}
				
	@RequestMapping(value = "/news_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		newsService.deleteNewsById(id);
		return "redirect:/news/news_list";
	}
	
	@RequestMapping(value = "/query")
	public String test(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		System.out.println("the selectType is :" + selectType);
		System.out.println("the selectContent is : " + selectContent);
		News news;
		List<News> newsList = new ArrayList<News>();
		switch (selectType) {
		case "title":
			newsList = newsService.getNewsByTitleLike_(selectContent);
			break;

		case "user_name":
			List<User> issuerList = userService.getUserByNameLike_(selectContent);
			for(User issuer : issuerList){
				newsList.addAll(newsService.getNewsByIssuer(issuer));
			}
			break;
		default:
			newsList = newsService.getAllNews();
			break;
		}
		map.put("newsList", newsList);
		return "news/news_list";
	}
	
}
