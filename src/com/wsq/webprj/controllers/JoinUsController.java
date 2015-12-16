package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MemberProfile;


//POJO Ŭ����
@Controller
@RequestMapping("/joinus/")
public class JoinUsController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberProfileDao mprofileDao;
	
	//--------------------------------------------------------------
	@RequestMapping(value= "join",method=RequestMethod.GET)
	public String join(){
		
		return "joinus/join";
	}
	
	@RequestMapping(value= "join",method=RequestMethod.POST)
	public String join(Member m, MemberProfile mprofile, HttpSession session) throws SQLException
	{
		Date regDate = new Date();
		m.setRegDate(regDate);
		memberDao.insert(m);
		mprofile.setMember_mid(m.getMid());
		
		
		return "redirect:../findpartner/userlist"; 
	}
	//---------------------------------------------------------------
	
	@RequestMapping(value= "login",method=RequestMethod.GET)
	public String login(){
		
		return "joinus/login";
	}
	
	/*@RequestMapping(value= "login",method=RequestMethod.POST)
	public String login(String userID, 
			String password, 
			Model model,
			HttpSession session) throws SQLException
	{
		Member m = memberDao.getMember(userID);
		String error = null;
		
		if(m == null)
		{
			error = "����� ���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�";
		}
		
		else if(!m.getPwd().equals(password)) //ȸ���� ���������� ��й�ȣ�� ��ġ���� ���� ���
			error = "����� ���̵� �Ǵ� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�";
		
		if(error != null)
		{
			model.addAttribute("error", error);
			return "joinus/login";
		}
		
		
	
		//���� ����
		//���� ������ ���� ���?(session?cookie? ����)
		session.setAttribute("mid", userID);	
		return "redirect:../findpartner/userlist"; 
	}*/
}