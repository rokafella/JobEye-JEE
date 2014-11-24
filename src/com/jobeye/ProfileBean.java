package com.jobeye;

import java.util.ArrayList;
import java.util.List;

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
	
	public static List<String> typesOptions;

	public List<String> getTypesOptions() {
		typesOptions = new ArrayList<String>();
		typesOptions.add("Internship");
		typesOptions.add("Full Time");
		typesOptions.add("Part time");
		List<String> result = profileAdd.oldProfileValues(loginBean.getUserId());
		if(result!=null){
			for(String s:result){
				typesOptions.add(s);
			}
		}
		return typesOptions;
	}
	
	public String createProfile(){
		return profileAdd.addProfile(type,loginBean.getUserId());
	}
	
	public String selectProfile(){
		if(this.type!=null){
			return "success";
		}
		else{
			return "false";
		}
	}
}
