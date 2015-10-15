package com.bit2015.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2015.mysite.dao.BoardDao;
import com.bit2015.mysite.vo.BoardVo;
import com.bit2015.web.WebUtil;
import com.bit2015.web.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
			String no = request.getParameter("no");
			
			BoardVo vo = new BoardVo();
			vo.setNo(Long.parseLong(no));
			
			BoardDao dao = new BoardDao();
			dao.delete(vo);
			
			WebUtil.redirect(response, "/mysite/board?a=lista");
	}

}
