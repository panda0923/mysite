package com.bit2015.mysite.action.member;

import com.bit2015.mysite.action.main.IndexAction;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class MemberActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if( "joinform".equals( actionName ) ) {
			action = new JoinFormAction();
		} else if( "joinsuccess".equals( actionName ) ) {
			action = new JoinSueccessAction();
		} else if( "join".equals( actionName ) ) {
			action = new JoinAction();
		}else if( "loginform".equals( actionName ) ) {
			action = new LoginFormAction();
		}else if( "login".equals( actionName ) ) {
			action = new LoginAction();
		}else if( "logout".equals( actionName ) ) {
			action = new LoginOutAction();
		}else {
			// error 처리 
			action = new IndexAction();
		}
		
		return action;
	}

}
//에러 처리 (사용자가 없는 경로를 입력하였을때)