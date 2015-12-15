package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MemberProfile;


//POJO Å¬·¡½º
@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private MemberProfileDao profileDao;
	
	@RequestMapping(value="mypage", method=RequestMethod.GET) 
	public String myPage()
	{
		return "mypage/mypage";
	}
	
	@RequestMapping(value="mypage", method=RequestMethod.POST) 
	public String myPage(MemberProfile mProfile, HttpSession session) throws SQLException
	{
		profileDao.insert(mProfile);
		
		return "redirect:../findpartner/userlist"; 
	}
}

