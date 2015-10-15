package com.bit2015.mysite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.action.board.BoardActionFactory;
import com.bit2015.mysite.action.guestbook.GuestBookActionFactory;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;


@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding( "UTF-8" );
		String actionName = request.getParameter("a");
		ActionFactory af = new BoardActionFactory();
		
		Action action = af.getAction(actionName);
		action.execute(request, response);
	}

}
