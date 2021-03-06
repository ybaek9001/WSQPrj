package com.wsq.webprj.controllers;

import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.HabitatCountryDao;
import com.wsq.webprj.dao.LearningLanguageDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.MessageDao;
import com.wsq.webprj.dao.MyPartnerDao;
import com.wsq.webprj.dao.NationalityCountryDao;
import com.wsq.webprj.dao.NativeLanguageDao;
import com.wsq.webprj.vo.HabitatCountry;
import com.wsq.webprj.vo.LearningLanguage;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MemberProfile;
import com.wsq.webprj.vo.Message;
import com.wsq.webprj.vo.MyPartner;
import com.wsq.webprj.vo.NationalityCountry;
import com.wsq.webprj.vo.NativeLanguage;


//POJO 클래스
@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberProfileDao profileDao;
	
	@Autowired
	private LearningLanguageDao lLanguageDao;
	
	@Autowired
	private NativeLanguageDao nLanguageDao;
	
	@Autowired
	private MyPartnerDao myPartnerDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	private NationalityCountryDao nCountryDao;
	
	@Autowired
	private HabitatCountryDao hCountryDao;
	
	
	@RequestMapping(value="mypage", method=RequestMethod.GET) 
	public String myPage(Model model, String id, Authentication auth)
	{
		if(id==null)
			id=auth.getName();
		
		
		List<MyPartner> send_list = myPartnerDao.getWaitingList(id,"send");
		model.addAttribute("send_list",send_list);
		
		List<MyPartner> receive_list = myPartnerDao.getWaitingList(id,"receive");
		model.addAttribute("receive_list",receive_list);
		
		List<MyPartner> friends_list = myPartnerDao.getWaitingList(id,"friend");
		model.addAttribute("friends_list",friends_list);
		
		int count = friends_list.size();
		model.addAttribute("count", count);
		
		int[] msgCount= new int[friends_list.size()];
		for(int i=0; i<friends_list.size();i++)
		{
			msgCount[i] = messageDao.getMsgCount(id, friends_list.get(i).getMypartners_mid());
			//System.out.println(msg[i]);
		}
		model.addAttribute("msgCount", msgCount);
		
		
		/*System.out.println(mplist.size());
		System.out.println(mplist.get(1).getMypartners_mid());*/
		
		List<NativeLanguage> nlist = nLanguageDao.getNlanguagelist(id);
		model.addAttribute("nlist", nlist);
		        
		List<LearningLanguage> llist = lLanguageDao.getLlanguagelist(id);
		model.addAttribute("llist", llist);
		
		MemberProfile mp = profileDao.getProfile(id);	
		model.addAttribute("mProfile", mp);
			
		

		return "mypage/mypage";
	}
	
	@RequestMapping(value="mypageRev", method=RequestMethod.GET) 
	public String ReviseMyPage(Model model, String id)
	{			
		Member m = memberDao.getMember(id);
		model.addAttribute("member", m);
		return "mypage/mypageRev"; 
	}
	
	@RequestMapping(value="mypageRev", method=RequestMethod.POST) 
	public String ReviseMyPage(Authentication auth, 
			MemberProfile mp, 
			NativeLanguage n_language,
			LearningLanguage l_language,
			NationalityCountry n_country,
			HabitatCountry h_country
			) 
	{			
		String id = auth.getName();
		
		mp.setMember_mid(id);
		profileDao.update(mp);
		
		
		n_country.setMember_mid(id);
		h_country.setMember_mid(id);
		nCountryDao.update(n_country);
		hCountryDao.update(h_country);
		
		
		//-------------------------두개 Dao 만들어!!!!!!!!!!---------------------------//
		
		
		/*String[] nl_code = lc.getNL_Code_List();
		String[] mentor_lv = lc.getMentor_LV_List();
		
		String[] ll_code = lc.getLL_Code_List();
		String[] mentee_lv = lc.getMentee_LV_List();
		
		
		for(int i=0; i<nl_code.length ; i++)
		{
		n_language.setMid(id);
		n_language.setN_language_code(nl_code[i]);
		n_language.setMentor_level(mentor_lv[i]);
		n_language.setNative_num(i+1);
		nLanguageDao.update(n_language);
		}
		
		for(int i=0; i<ll_code.length ; i++)
		{
		l_language.setMid(id);
		l_language.setL_language_code(ll_code[i]);
		l_language.setMentee_level(mentee_lv[i]);
		l_language.setLearning_num(i+1);
		lLanguageDao.update(l_language);
		}*/
		n_language.setMember_mid(id);
		nLanguageDao.update(n_language);
		
		l_language.setMember_mid(id);
		lLanguageDao.update(l_language);
		
		return "redirect:mypage";
	}
	
	@RequestMapping(value="friendManager", method=RequestMethod.POST) 
	public String friendManager(String friendID, String choice, MyPartner m, MyPartner mp, Authentication auth) throws SQLException {
		String myID = auth.getName();
		/*//나
		m.setMembers_mid(myID);
		m.setMypartners_mid(friendID);
		

		//상대방
		mp.setMembers_mid(friendID);
		mp.setMypartners_mid(myID);*/
		try {
			if(choice!=null)
			{
				m.setMembers_mid(myID);
				m.setMypartners_mid(friendID);
				m.setRequest("friend");
				myPartnerDao.update(m);
				mp.setMembers_mid(friendID);
				mp.setMypartners_mid(myID);
				mp.setRequest("friend");
				myPartnerDao.update(mp);
			}
			
			else
			{
				m.setMembers_mid(myID);
				m.setMypartners_mid(friendID);
				m.setRequest("send");
				myPartnerDao.insert(m);
				mp.setMembers_mid(friendID);
				mp.setMypartners_mid(myID);
				mp.setRequest("receive");
				myPartnerDao.insert(mp);
			}
		} catch (Exception e) {
			
		}
		
		
		
		
		return "redirect:mypage";
		
	}
	
	@RequestMapping(value="msgReg", method=RequestMethod.GET)	//showDialog함수에서 메세지 폼을 얻기위해  Ajax GET방식 사용할 때 호출 됨
	public String msgRegget(){
		return "/mypage/msgReg";
	}
	
	@RequestMapping(value="msgReg", method=RequestMethod.POST)	//메세지를 작성하고 보내기를 눌러서 Ajax POST방식 사용할 때 호출 됨
	public void msgReg(Message message, Authentication auth, String msg, String friendID, PrintWriter out){
		Date regDate = new Date();
		String myID = auth.getName();
		//System.out.println(regDate);
		message.setSending_members_mid(myID);
		message.setReceiving_members_mid(friendID);
		message.setDate(regDate);
		message.setComment(msg);
		messageDao.insert(message);	
		
		//test
		/*MemberProfile mp = profileDao.getProfile(myID);
		JSONObject obj = new JSONObject();
		obj.put("name","덩치");
		obj.put("language", "korean");
		out.print(obj);	*/
	}
	
	@RequestMapping("msgOpen")
	public String index(String friendID, Authentication auth, Model model){
		String myID=auth.getName();
		List<Message> msglist = messageDao.getMessages(myID, friendID);
		//System.out.println(msglist.isEmpty());
		//System.out.println(msglist.get(0).getComment());
		
		if(msglist.isEmpty())
		{
			model.addAttribute("isEmpty", 0);
			//System.out.println("empty!!!!");
		}
		else
			model.addAttribute("msglist", msglist);
		return "/mypage/msgOpen";
	}
	
	@RequestMapping(value="msgDel", method=RequestMethod.POST)
	public void msgDel(Authentication auth, String fid, String msg){
		String mid = auth.getName();
		int cnt = messageDao.delete(mid,fid,msg);
		System.out.println(cnt);
	}
	
	
	
}

