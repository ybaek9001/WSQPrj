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


//POJO Å¬·¡½º
@Controller
@RequestMapping("/wsqdebate/")
public class WsqDebateController {
	
	@RequestMapping("debate")
	public String debate(PrintWriter out, Model model)
	{
		return "wsqdebate/debate";		
	}
}
