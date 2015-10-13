package com.bit2015.mysite.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class LoginFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// loginform 보여주기
		
		WebUtil.forwarding(request, response, "/views/user/loginform.jsp");
			
	}

}
