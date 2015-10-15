package com.bit2015.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class ListViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Long no = new Long( request.getParameter( "no" ) );
		
		BoardDao dao = new BoardDao();
		// 조회수 올리기
	
		dao.increaseViewCount( no );
		// 게시물 가져오기

		BoardVo vo = dao.get( no );
	

		request.setAttribute( "board", vo );
	
		WebUtil.forwarding( request, response, "/views/board/view.jsp" );
	}

}
