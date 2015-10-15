package com.bit2015.mysite.action.guestbook;

import com.bit2015.mysite.action.main.IndexAction;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("list".equals(actionName)){
			action = new ListAction();
		}else if("listadd".equals(actionName)){
			action = new ListAddAction();
		}else if("deleteform".equals(actionName)){
			action = new DeleteformAction();
		}else if("delete".equals(actionName)){
			action  = new DeleteAction();
		}
		else{
			action = new IndexAction();
		}
		return action;
	}

}
