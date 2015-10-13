package com.bit2015.mysite.action.main;

import com.bit2015.web.action.Action;
import com.bit2015.web.action.ActionFactory;
import com.bit2015.mysite.action.main.IndexAction;
public class MainActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		//Action action = new IndexAction();
		//return action();
		return new IndexAction();
	}


}
