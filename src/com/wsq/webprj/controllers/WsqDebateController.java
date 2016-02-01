package com.wsq.webprj.controllers;

import java.io.PrintWriter;

import java.sql.SQLException;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.RequestWrapper;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.CommentDao;
import com.wsq.webprj.dao.DebateSquareDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.ReplyDao;
import com.wsq.webprj.dao.mybatis.MyBatisDebateSquareDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Comment;
import com.wsq.webprj.vo.DebateSquare;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.Reply;


//POJO 클래스
@Controller
@RequestMapping("/wsqdebate/")
public class WsqDebateController {
	
	@Autowired
	private DebateSquareDao dao;
	
	@Autowired
	private CommentDao commentDao;
	
	@Autowired
	private ReplyDao replyDao;
	
	
	@RequestMapping(value="debateJSON", method=RequestMethod.GET)
	public void debateJSON(String c, PrintWriter out){
		int code = 1;
		if(c != null && !c.equals(""))
			code = Integer.parseInt(c);
		
		StringBuilder builder = new StringBuilder();
		
		List<Reply> replyList = replyDao.getReplies(code);
		
		builder.append("[");
		for(int i=0; i<replyList.size(); i++){
			Reply r = replyList.get(i);
			
			//마지막줄은 쉼표 없게
			if(i == replyList.size()-1)
				builder.append(String.format("{'code':'%s', 'id':'%s', 'context':'%s'}"
						, r.getCode()
						, r.getId()
						, r.getContext()						
						));
			else
				builder.append(String.format("{'code':'%s', 'id':'%s', 'context':'%s'},"
						, r.getCode()
						, r.getId()
						, r.getContext()					
					));
		}		
		builder.append("]");
		
		out.println(builder.toString());
		
		
		/*List<Notice> list = noticeDao.getNotices(page, "Title", "");					
		for(int i=0; i<list.size(); i++)
		{
			Notice n = list.get(i);
			if(i==list.size()-1)
				builder.append(String.format("{'code':'%s', 'title':'%s', 'writer':'%s'}"
						, n.getCode()
						, n.getTitle()
						, n.getWriter()						
						));
			else
				builder.append(String.format("{'code':'%s', 'title':'%s', 'writer':'%s'},"
					, n.getCode()
					, n.getTitle()
					, n.getWriter()					
					));
		}		
		builder.append("]");*/
		
		/*//지연시간 부여
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	*/	
		/*out.println(builder.toString());*/
	}
	
	
	@RequestMapping(value="debate", method=RequestMethod.GET)
	public String debate(String c, Model model,  HttpServletRequest request, Authentication auth)
	{				
		/*String id=dao.getMember(mc); //작성자정보
		if(id.equals(request.getUserPrincipal().getName()))
		{
			model.addAttribute("signal","signal");
		}*/
		
		//System.out.printf("getname : %s\n", auth.getName());
				
		if(c==null){		
			System.out.printf("\ncode:%s / ", c);
			
			DebateSquare debate = dao.getDebateFirst();
			
			System.out.printf("getCode : " + String.valueOf(debate.getCode()) +"\n" );
			System.out.printf("id : %s\n", auth.getName());
			
			List<Comment> comments = commentDao.getComments(String.valueOf(debate.getCode()));
			//List<Reply> replies = replyDao.getReplies(comments.get(0).getCode());
			//model.addAttribute("reply", replies);
						
			/*comments[0] 댓글들 쭉
			comments[1]
			comments[2]
			comments[3]
			comments[4]*/
						
			
			model.addAttribute("debate", debate);
			model.addAttribute("comments", comments);
			
			//model.addAttribute("userid", auth.getName());
			model.addAttribute("userid", auth.getName());
			
			//System.out.println(debate.getHit());
			dao.updateHit(debate.getHit(), String.valueOf(debate.getCode()) );
			
		}
		else{		
			System.out.printf("\ncode:%s / ", c);
			
			DebateSquare debate = dao.getDebate(c);
			
			System.out.printf("getCode : " + String.valueOf(debate.getCode()) +"\n" );
			System.out.printf("id : %s\n", auth.getName());
			
			List<Comment> comments = commentDao.getComments(c);			
			
			model.addAttribute("debate", debate);			
			model.addAttribute("comments", comments);	
			//model.addAttribute("userid", auth.getName());
			model.addAttribute("userid", auth.getName());
			
			dao.updateHit(debate.getHit(), c);
		}		
		
		return "wsqdebate/debate";		
	}
	
	@RequestMapping(value="debate", method=RequestMethod.POST)
	public String debate(String c, Comment comment, HttpServletRequest request, Model model, Authentication auth) throws SQLException
	{		
		DebateSquare debate = dao.getDebate(c);		
		List<Comment> comments = commentDao.getComments(c);
				
		model.addAttribute("debate", debate);
		model.addAttribute("comments", comments);
		model.addAttribute("userid", auth.getName());
				
		//댓글 삽입
		//String opinion = request.getParameter("opinion");
		//comment.setOpinion(opinion);
		
		comment.setId(auth.getName());
		comment.setDebateCode(Integer.parseInt(c));
		
		if(commentDao.insert(comment) == 1){
			System.out.println("insert success!");
			dao.updateComment(debate.getCommentCnt(), c, 1); //댓글count++;
			
			if(comment.isOpinion()==true) //찬성
				dao.updateAgree(debate.getAgreeCnt() , c, 1); 
			else if(comment.isOpinion()==false) //반대
				dao.updateDisagree(debate.getDisagreeCnt(), c, 1); 				
			
		}	
		
		return "redirect:debate?c="+c;		
	}
	
	@RequestMapping(value="debateDelete", method=RequestMethod.GET)
	public String debateDelete(String c, String code, Boolean type) throws SQLException{		
		System.out.println("delete success : " + commentDao.delete(code) + "\n");	
		
		
		DebateSquare debate = dao.getDebate(c);				
		dao.updateComment(debate.getCommentCnt(), c, -1); //댓글count--;
		
		//System.out.printf("type : " +type);		
		if(type == true)
			dao.updateAgree(debate.getAgreeCnt() ,c, -1);			
		else if(type == false)
			dao.updateDisagree(debate.getDisagreeCnt(), c, -1);
		
		
		return "redirect:debate?c="+c;
	}
	

	@RequestMapping(value="commentReg", method=RequestMethod.POST)
	public String commentReg(String c, String code, String context) throws SQLException{
		
		System.out.printf("c:%s / code:%s / context:%s\n", c, code, context);
		
		if(context.length()>0)
			System.out.println("update success : " + commentDao.update(code, context) +"\n");
		else System.out.println("update failed\n");
		
		
		return "redirect:debate?c="+c;
	}
	
	
	/*@RequestMapping(value="comment", method=RequestMethod.GET)
	public String comment(String c, Model model){
		
		if(c==null){
			DebateSquare debate = dao.getDebateFirst();	
			
			List<Comment> comments = commentDao.getComments(String.valueOf(debate.getCode()));	
						
			model.addAttribute("comments", comments);
		}
		
		else{
			List<Comment> comments = commentDao.getComments(c);
			model.addAttribute("comments", comments);
		}
		
		return "wsqdebate/comment";
	}*/
			
	
	@RequestMapping("debateList")
	public String list(Model model) throws SQLException{
		List<DebateSquare> list = dao.getDebateSquares(1);
		model.addAttribute("list", list);
		
		return "wsqdebate/debateList";
	}
}
