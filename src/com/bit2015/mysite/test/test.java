package com.bit2015.mysite.test;

import java.util.List;


import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.mysite.dao.GuestBookDao;
import com.bit2015.mysite.dao.MemberDao;
public class test {
	public static void main(String[] args) {
		getTest();
		//updateTest();
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
		GuestBookDao dao = new GuestBookDao();
		List<GuestbookVo> list = dao.getList();
	
		for(GuestbookVo vo :list){
			System.out.println(vo);
		}
	}
}