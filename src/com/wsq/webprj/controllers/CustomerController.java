package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Member;


//POJO 클래스
@Controller
public class CustomerController {
	
	//Spring이 제공하는 어노테이션
	
	@RequestMapping("/findpartner/userlist")
	public String userlist(PrintWriter out, Model model) throws SQLException
	{
		MemberDao dao = new MyBatisMemberDao();
		List<Member> list = dao.getMembers(1);
		model.addAttribute("m", list);
		return "findpartner/userlist";		
	}
	
	@RequestMapping("/index") 
	public String index(PrintWriter out, Model model)
	{
		return "index";
	}
		
	@RequestMapping("/mypage/mypage") 
	public String myPage(PrintWriter out, Model model)
	{
		return "mypage/mypage";
	}
	
	@RequestMapping("/wsqdebate/debate")
	public String debate(PrintWriter out, Model model)
	{
		return "wsqdebate/debate";		
	}
	
	@RequestMapping("/joinus/join")
	public String join(PrintWriter out, Model model)
	{
		return "joinus/join";		
	}
	
	@RequestMapping("/joinus/login")
	public String login(PrintWriter out, Model model)
	{
		return "joinus/login";		
	}
	
}
