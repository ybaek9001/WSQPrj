
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.mybatis.MyBatisMemberDao;
import com.wsq.webprj.vo.Member;

public class TestProgram {

	public static void main(String[] args) throws SQLException, ParseException {

		//프로파일 입력
		/*MemberProfile m_profile = new MemberProfile();
		m_profile.setAge(20);
		m_profile.setGender("male");
		m_profile.setHabitat_country_code(82);
		m_profile.setLevelMentee("beginner");
		m_profile.setLevelMentor("beginner");
		m_profile.setMember_mid("ybaek9001");
		m_profile.setName("yb");
		m_profile.setNationality_country_code(82);
		m_profile.setText("안녕하세요");
		
		
		MemberProfileDao dao = new MyBatisMemberProfileDao();*/
		
		//회원가입
		Member member = new Member();
		member.setMid("msfad");
		member.setPwd("1234");
		
		MemberDao dao = new MyBatisMemberDao();
		
		
		
		
		//int update = dao.delete("yb");
		//int update = dao.update(member);
		int update = dao.insert(member);
		
		List<Member>list = dao.getMembers(1);
		//List<Member>list = dao.getMembers(1,"Mid","");
		
		System.out.println("검색결과:" + list.size());
		
		for(Member m : list)
		{
			System.out.printf(
					"mid : %s, "
					+ "pwd : %s\n", 
					m.getMid(),
					m.getPwd());		
		}
		
		System.out.printf("%d\n", update);
		//session.close();  //session 종료는 맨 마지막에만 가능
		
	}

}  

//api - 플렛폼(도구)이 제공해주는 라이브러리
//프레임워크 - 객체지향적인 관점에서 재사용 가능한 라이브러리
//mybatis는 편의성을 주는 프레임워크(옵션-있어도되고 없어도됨), 따리서 api(꼭 필요한 도구)가 아님
