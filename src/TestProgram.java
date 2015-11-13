import java.sql.SQLException;
import java.util.List;

import com.worldsqure.webprj.dao.MemberDao;
import com.worldsqure.webprj.vo.Member;



public class TestProgram {
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		MemberDao dao  = new MemberDao();
		//List<Member> list = dao.getMembers(1, "MID", "a");
		List<Member> list = dao.getMembers(1);
		System.out.println("검색결과: " + list.size());
		
		
		for(Member m : list)
		{
			System.out.printf("mid : %s, name : %s, pwd : %s, regDate: %s\n", m.getMid(), m.getName(), m.getPwd(), m.getRegDate());
		}
	}
}
