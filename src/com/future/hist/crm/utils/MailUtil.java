/**
The MIT License (MIT) * Copyright (c) 2015 铭飞科技

 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:

 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.

 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.future.hist.crm.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

/**
 * 
 *         <p>
 *         Comments:邮件发送通用，依赖spring的mail,
 *         </p>
 * 
 *         <p>
 *         经测试，QQ邮箱可以发邮件，需要开启smtp服务，设置独立密码，用授权密码登陆<br>
 *         163邮箱开启smtp服务，设置授权密码，用授权密码登陆
 *         </p>
 */
public class MailUtil {

	/**
	 * <p>host准备，<br>
	 * 适应126、qq、163、sina、tom、263、yahoo、hotmail、gmail邮箱</p>
	 * <p>目前只支持QQ邮箱和163邮箱</p>
	 */
	private static Map<String, String> hostMap = new HashMap<String, String>();
	static {
		// 126
		hostMap.put("smtp.126", "smtp.126.com");
		// qq
		hostMap.put("smtp.qq", "smtp.qq.com");

		// 163
		hostMap.put("smtp.163", "smtp.163.com");

		// sina
		hostMap.put("smtp.sina", "smtp.sina.com.cn");

		// tom
		hostMap.put("smtp.tom", "smtp.tom.com");

		// 263
		hostMap.put("smtp.263", "smtp.263.net");

		// yahoo
		hostMap.put("smtp.yahoo", "smtp.mail.yahoo.com");

		// hotmail
		hostMap.put("smtp.hotmail", "smtp.live.com");

		// gmail
		hostMap.put("smtp.gmail", "smtp.gmail.com");
		hostMap.put("smtp.port.gmail", "465");
	}

	
	/**
	 * <p>给出发送端邮箱地址返回host地址</p>
	 * @param email
	 * @return
	 * @throws Exception
	 */
	public static String getHost(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return hostMap.get(key);
		} else {
			throw new Exception("unSupportEmail");
		}
	}

	public static int getSmtpPort(String email) throws Exception {
		Pattern pattern = Pattern.compile("\\w+@(\\w+)(\\.\\w+){1,2}");
		Matcher matcher = pattern.matcher(email);
		String key = "unSupportEmail";
		if (matcher.find()) {
			key = "smtp.port." + matcher.group(1);
		}
		if (hostMap.containsKey(key)) {
			return Integer.parseInt(hostMap.get(key));
		} else {
			return 25;
		}
	}

	/**
	 * 发送简单的文字邮件
	 * 
	 * @param host 主机
	 * @param port　端口
	 * @param userName　账号
	 * @param password　密码
	 * @param title　标题
	 * @param content　内容
	 * @param toUser　接收人
	 * @throws Exception 
	 */
	public static void sendText(String userName, String password, String title, String content, String[] toUser) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定mail server
		senderImpl.setHost(MailUtil.getHost(userName));//smtp.163.com
		senderImpl.setPort(MailUtil.getSmtpPort(userName));//prot ：25
		// 建立邮件消息
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人 用数组发送多个邮件
		// String[] array = new String[] {"sun111@163.com","sun222@sohu.com"};
		// mailMessage.setTo(array);
		mailMessage.setTo(toUser);
		mailMessage.setFrom(userName);
		mailMessage.setSubject(title);
		mailMessage.setText(content);
		senderImpl.setUsername(userName); // 根据自己的情况,设置username
		senderImpl.setPassword(password); // 根据自己的情况, 设置password

		Properties prop = new Properties();
		prop.put(" mail.smtp.auth ", " true "); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		prop.setProperty("mail.smtp.port", "465");
		prop.setProperty("mail.smtp.socketFactory.port", "465");
		prop.setProperty("mail.smtp.socketFactory.fallback", "false");
		prop.put(" mail.smtp.timeout ", " 25000 ");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);
	}

	/**
	 * 发送简html内容的邮件
	 * 
	 * @param host 主机
	 * @param port　端口
	 * @param userName　账号
	 * @param password　密码
	 * @param title　标题
	 * @param content　html内容
	 * @param toUser　接收人
	 * @throws Exception 
	 * @throws javax.mail.MessagingException 
	 */
	public static void sendHtml(String userName, String password, String title, String content, String[] toUser) throws Exception{
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定mail server
		senderImpl.setHost(MailUtil.getHost(userName));
		senderImpl.setPort(MailUtil.getSmtpPort(userName));
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"UTF-8");
			
			try {
				// 设置收件人，寄件人
				messageHelper.setTo(toUser);
				messageHelper.setFrom(userName);
				messageHelper.setSubject(title);
				// true 表示启动HTML格式的邮件
				messageHelper.setText(content, true);
			} catch (javax.mail.MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			senderImpl.setUsername(userName); // 根据自己的情况,设置username
			senderImpl.setPassword(password); // 根据自己的情况, 设置password
			Properties prop = new Properties();
			prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
			prop.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			prop.setProperty("mail.smtp.port", "465");
			prop.setProperty("mail.smtp.socketFactory.port", "465");
			prop.setProperty("mail.smtp.socketFactory.fallback", "false");
			prop.put("mail.smtp.timeout", "25000");
			senderImpl.setJavaMailProperties(prop);
			// 发送邮件
			senderImpl.send(mailMessage);
		} catch (javax.mail.MessagingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 


	}

	/**
	 * 发送带图片的html邮件，
	 * 
	 * @param host 主机
	 * @param port　端口
	 * @param userName　账号
	 * @param password　密码
	 * @param title　标题
	 * @param content　带图片的html内容 
	 * @param imgs　图片地址，
	 * @param toUser　接收人
	 * @throws Exception 
	 */
	public static void sendNews( String userName, String password, String title, String content, List<String> imgs,
			String[] toUser) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		// 设定mail server
		senderImpl.setHost(MailUtil.getHost(userName));

		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
		// multipart模式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage,true,"UTF-8");

		// 设置收件人，寄件人
		messageHelper.setTo(toUser);
		messageHelper.setFrom(userName);
		messageHelper.setSubject(title);
		// true 表示启动HTML格式的邮件
		messageHelper.setText(content, true);

		int i = 0;
		for (String imagePath : imgs) {
			FileSystemResource img = new FileSystemResource(new File(imagePath));
			messageHelper.addInline(i + "", img);
			i++;
		}

		senderImpl.setUsername(userName); // 根据自己的情况,设置username
		senderImpl.setPassword(password); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);

		// 发送邮件
		senderImpl.send(mailMessage);
	}

	/**
	 * 发送带附件的html邮件，
	 * 
	 * @param host 主机
	 * @param port　端口
	 * @param userName　账号
	 * @param password　密码
	 * @param title　标题
	 * @param content　带图片的html内容 
	 * @param files　附件list<Map<key:文件名称,value:文件地址>>
	 * @param toUser　接收人
	 * @throws Exception 
	 */
	public static void sendAttached(String userName, String password, String title, String content,
			List<Map<String, String>> files, String[] toUser) throws Exception {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();

		// 设定mail server
		senderImpl.setHost(MailUtil.getHost(userName));
		// 建立邮件消息,发送简单邮件和html邮件的区别
		MimeMessage mailMessage = senderImpl.createMimeMessage();
		// 注意这里的boolean,等于真的时候才能嵌套图片，在构建MimeMessageHelper时候，所给定的值是true表示启用，
		// multipart模式 为true时发送附件 可以设置html格式
		MimeMessageHelper messageHelper = new MimeMessageHelper(mailMessage, true, "utf-8");

		// 设置收件人，寄件人
		messageHelper.setTo(toUser);
		messageHelper.setFrom(userName);
		messageHelper.setSubject(title);
		// true 表示启动HTML格式的邮件
		messageHelper.setText(content, true);

		for (Map<String, String> filePath : files) {
			Iterator<String> it = filePath.keySet().iterator();
			String fileName = it.next();
			FileSystemResource file = new FileSystemResource(new File(filePath.get(fileName)));
			// 这里的方法调用和插入图片是不同的。
			messageHelper.addAttachment(fileName, file);
		}

		senderImpl.setUsername(userName); // 根据自己的情况,设置username
		senderImpl.setPassword(password); // 根据自己的情况, 设置password
		Properties prop = new Properties();
		prop.put("mail.smtp.auth", "true"); // 将这个参数设为true，让服务器进行认证,认证用户名和密码是否正确
		prop.put("mail.smtp.timeout", "25000");
		senderImpl.setJavaMailProperties(prop);
		// 发送邮件
		senderImpl.send(mailMessage);
	}
	/*public static void main(String[] args) throws Exception {
		MailUtil mu = new MailUtil();
		String[] toUser = new String[]{"893771943@qq.com"};
//		mu.sendHtml("smtp.163.com", 25, "a985850124@163.com", "fanyangyang123", "发送简单的html邮件", "<html><body>发送简单的html邮件</body></html>",toUser);
		List<String> img = new ArrayList<>();
		img.add("d:/锦锦证件照.jpg");
		mu.sendNews("a985850124@163.com", "fanyangyang123", "发送简单的html邮件", "<html><body>第无次发送发送简单的html邮件</body></html>",img,toUser);
//		List<Map<String,String>> filesList = new ArrayList<>();
//		Map temp = new HashMap<String, String>();
//		temp.put("JetbrainsCrack-2.5.3", "d:/JetbrainsCrack-2.5.3.jar");
//		filesList.add(temp);
//		mu.sendAttached("smtp.163.com", 25, "a985850124@163.com", "fanyangyang123", "发送简单的html邮件", "<html><body>第一次发送发送简单的html邮件</body></html>",filesList,toUser);
	}*/
}