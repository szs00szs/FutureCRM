package com.future.hist.crm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
 * 新闻controller层
 * @author 羊羊
 * @date 2016年4月11日
 */
@Controller
@RequestMapping("/news")
public class NewsController extends BaseController{
	
	/**
	 * newService层
	 */
	@Autowired
	private NewsService newsService;
	
	/**
	 * userService层
	 */
	@Autowired
	private UserService userService;
	
	/**
	 * 新闻列表
	 * @param map
	 * @return 返回到新闻列表页面
	 */
	@RequiresPermissions("news:list")
	@RequestMapping("/news_list")
	public String newsList(Map<String , Object> map){
		//准备数据，得到所有的新闻
		List<News> newsList = newsService.getAllNewsByTimedesc();//按时间排序，显示最新新闻
		map.put("newsList", newsList);
		
		return "news/news_list";
	}

	/**
	 * 新闻详情
	 * @param id ： 待查看的新闻id
	 * @param model
	 * @return 返回到新闻详情页
	 */
	@RequiresPermissions("news:detail")
	@RequestMapping("/news_detail/{id}")
	public String newsDetail(@PathVariable("id") long id , Model model){
		//准备数据，通过id得到新闻详情
		News news = newsService.getNewsById(id);
		model.addAttribute(news);
		
		return "news/news_detail";
	}
	
	/**
	 * 添加新闻请求
	 * @param map
	 * @return 返回到添加新闻页面
	 */
	@RequiresPermissions("news:save")
	@RequestMapping(value = "/news_saveUI")
	public String saveUI(Map<String, Object> map){
		//准备数据，userList
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "news/saveUI";
	}
	
	/**
	 * 添加新闻
	 * @param news
	 * @return 返回到新闻列表页面
	 */
	@RequiresPermissions("news:save")
	@RequestMapping(value = "/news_save" )
	public String save(News news){
		
		newsService.addNews(news);
		
		return "redirect:/news/news_list";
	}
	
	/**
	 * 更新新闻请求
	 * @param id ：待更新的新闻id
	 * @param map
	 * @return 返回到更新新闻页面
	 */
	@RequiresPermissions("news:update")
	@RequestMapping(value = "/news_updateUI/{id}")
	public String updateUI(@PathVariable(value = "id") Long id,Map<String, Object> map){
		//数据准备，通过id得到待更新的新闻详情
		News news = newsService.getNewsById(id);
		map.put("news" , news);
		//userList
		List<User> userList = userService.getAllUser();
		map.put("userList", userList);
		
		return "news/saveUI";
	}
	
	/**
	 * 更新新闻
	 * @param news
	 * @return 返回到新闻列表页面
	 */
	@RequiresPermissions("news:update")
	@RequestMapping(value = "/news_update" )
	public String update(News news){
		
		newsService.updateNews(news);
		
		return "redirect:/news/news_list";
	}
			
				
	/**
	 * 删除新闻
	 * @param id ： 待删除的新闻id
	 * @return 返回到新闻列表
	 */
	@RequiresPermissions("news:delete")
	@RequestMapping(value = "/news_delete/{id}")
	public String delete(@PathVariable(value = "id") Long id){
		
		newsService.deleteNewsById(id);
		
		return "redirect:/news/news_list";
	}
	
	/**
	 * 查询新闻
	 * <p>
	 * 	有两种查询方法：title（新闻标题）、user_name(发布人）
	 * </p>
	 * @param request
	 * @param map
	 * @return 返回到新闻列表
	 */
	
	// TODO 暂定为两种查询方法
	@RequiresPermissions("news:query")
	@RequestMapping(value = "/query")
	public String query(HttpServletRequest request , Map<String , Object> map){
		String selectType = request.getParameter("selectType");
		String selectContent = request.getParameter("selectContent");
		
		List<News> newsList = new ArrayList<News>();
		
		switch (selectType) {
		case "title"://通过title查询新闻
			newsList = newsService.getNewsByTitleLike_(selectContent);
			break;

		case "user_name"://通过发布人得到新闻
			List<User> issuerList = userService.getUserByNameLike_(selectContent);
			for(User issuer : issuerList){
				newsList.addAll(newsService.getNewsByIssuer(issuer));
			}
			break;
		default://默认得到所有新闻
			newsList = newsService.getAllNews();
			break;
		}
		map.put("newsList", newsList);
		
		return "news/news_list";
	}
	
}
