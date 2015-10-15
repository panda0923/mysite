package com.bit2015.mysite.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class LoginOutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(); //세션은 가지고 있는 값 리턴
		if(session == null){
			//로그인 안하고 요청
			WebUtil.redirect(response, "/mysite/main");
			return;
		}
		//정상적인 로그 아웃 처리
		
		session.removeAttribute("authUser");//세션객체 삭제
		session.invalidate();//세션객체 생성
		
		WebUtil.redirect(response, "/mysite/main");
		
	}

}
