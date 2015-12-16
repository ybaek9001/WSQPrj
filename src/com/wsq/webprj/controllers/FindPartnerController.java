package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Member;


//POJO 클래스
@Controller
@RequestMapping("/findpartner/")
public class FindPartnerController {
	
	//Spring이 제공하는 어노테이션
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping("userlist")
	public String userlist(PrintWriter out, Model model) throws SQLException
	{
		
		List<Member> list = memberDao.getMembers(1);
		model.addAttribute("list", list);
		return "findpartner/userlist";		
	}
	
}
