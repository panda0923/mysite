package com.bit2015.mysite.test;

import java.util.List;




import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.dao.GuestBookDao;
import com.bit2015.mysite.dao.MemberDao;
public class test {
	public static void main(String[] args) {
		getListtest();
	}


	public static void getTest() {
		MemberDao dao = new MemberDao();
		MemberVo vo = dao.get( "a", "1234" );
		System.out.println( vo );
	}
	public static void insertTest(){
		MemberDao dao = new MemberDao();
		MemberVo vo = new MemberVo();
		vo.setName("이송이");
		vo.setEmail("a");
		vo.setPassword("123");
		vo.setGender("2");
		dao.insert(vo);
		
	}
	public static void getListtest(){
		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.getList();
	
		for(BoardVo vo :list){
			System.out.println(vo);
		}
	}
}