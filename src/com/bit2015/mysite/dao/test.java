package com.bit2015.mysite.dao;

import com.bit2015.mysite.vo.GuestbookVo;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		insert();
	}
	public static void insert(){
		GuestBookDao dao =new GuestBookDao();
		GuestbookVo vo = new GuestbookVo();
		vo.setName("z");
		vo.setMessage("z");
		vo.setPassword("1234");
		dao.insert(vo);
		
	}

}
