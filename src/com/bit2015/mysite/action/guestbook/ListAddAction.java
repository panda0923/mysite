package com.bit2015.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.GuestBookDao;
import com.bit2015.mysite.vo.GuestbookVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class ListAddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String message = request.getParameter("message");
		
		//vo에넣기
		GuestbookVo vo = new GuestbookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		GuestBookDao dao = new GuestBookDao();
		//dao와 연결
		dao.insert(vo);
		//결과 보여주기
		
		WebUtil.redirect(response, "/mysite/guest?a=list");
		
	}

}
