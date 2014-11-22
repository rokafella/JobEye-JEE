package com.jobeye;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.UserAdd;

public class UserBean {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@EJB
	private UserAdd userAdd;
	
	public String submit(){
		String ret = userAdd.UserAdd(name);
		if(ret.equalsIgnoreCase("Exists")){
			return "false";
		}
		return "submit";
	}
	
}
