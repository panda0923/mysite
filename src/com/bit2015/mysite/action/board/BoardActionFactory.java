package com.bit2015.mysite.action.board;

import com.bit2015.mysite.action.main.IndexAction;
import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
	
		if("write".equals(actionName)){
			action = new WriteAction();
		}else if("modify".equals(actionName)){
			action = new ModifyAction();
		}else if("delete".equals(actionName)){
			action = new DeleteAction();
		
		}else if("listview".equals(actionName)){
			action  = new ListViewAction();
		}else if("lista".equals(actionName)){
			action  = new ListAction();
		}else {
			action = new IndexAction();
		}
		return action;
	}

}
