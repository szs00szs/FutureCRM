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
	
	@RequestMapping("/news_detail/{id}")
	public String newsDetail(@PathVariable("id") long id , Model model){
		News news = newsService.getNewsById(id);
		model.addAttribute(news);
		return "news/news_detail";
	}
	
	@RequestMapping("/news_list")
	public String newsList(Map<String , Object> map){
		List<News> newsList = newsService.getAllNewsByTimedesc();//按时间排序，显示最新新闻
		map.put("newsList", newsList);
		return "news/news_list";
	}

	@RequestMapping(value = "/news_saveUI")
	public String saveUI(Map<String, Object> map){
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		return "news/saveUI";
	}
	@RequestMapping(value = "/news_save" )
	public String save(News news){
		System.out.println(news);
		newsService.addNews(news);
		return "redirect:/news/news_list";
	}
	
	@RequestMapping(value = "/news_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		News news = newsService.getNewsById(id);
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		map.put("news" , news);
		return "news/saveUI";
	}
	
	@RequestMapping(value = "/news_update" )
	public String update(News news){
		System.out.println("news : " + news);
		newsService.updateNews(news);
		return "redirect:/news/news_list";
	}
				
	@RequestMapping(value = "/news_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		newsService.deleteNewsById(id);
		return "redirect:/news/news_list";
	}
	
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		System.out.println("the selectType is :" + selectType);
		System.out.println("the selectContent is : " + selectContent);
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
