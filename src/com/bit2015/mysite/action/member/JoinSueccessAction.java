package com.bit2015.mysite.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.MemberDao;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class JoinSueccessAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		MemberDao dao = new MemberDao();
		MemberVo vo =dao.get(email, password);
		
		String name = vo.getName();
		WebUtil.forwarding(request, response, "/views/user/joinsuccess.jsp");
		
	}

}
