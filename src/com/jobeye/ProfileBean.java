package com.jobeye;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.ProfileAdd;

public class ProfileBean {

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	private LoginBean loginBean;
	
	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	@EJB
	private ProfileAdd profileAdd;
	
	public String setProfile(){
		return profileAdd.addProfile(type,loginBean.getEmail());
	}
}
