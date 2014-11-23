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
	
	private String email;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String phone;
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String password;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@EJB
	private UserAdd userAdd;
	
	public String submit(){
		String ret = userAdd.UserAdd(name,email,phone,password);
		if(ret.equalsIgnoreCase("Exists")){
			return "false";
		}
		return "login";
	}
	
}
