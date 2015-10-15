package com.bit2015.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.mysite.vo.MemberVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class WriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session = request.getSession();
		if( session == null ) {
			WebUtil.redirect( response, "/mysite/main" );
			return;
		}
		MemberVo memberVo = (MemberVo)session.getAttribute( "authUser" );
		
		Long no = memberVo.getNo();
		String title = request.getParameter( "title" );
		String content = request.getParameter( "content" );
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent( content );
		vo.setMemberNo( no );
		
		BoardDao dao = new BoardDao();
		dao.insert(vo);
		
		WebUtil.redirect( response, "/mysite/board?a=lista" );
	}

}
