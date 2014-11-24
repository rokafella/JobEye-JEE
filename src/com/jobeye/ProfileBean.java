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
	
	private String newType;
	
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
		return profileAdd.addProfile(newType,loginBean.getUserId());
	}
	
	public String selectProfile(){
		setProfileId(profileAdd.getProfileIdFromDb(type));
		return "success";
	}

	public String getNewType() {
		return newType;
	}

	public void setNewType(String newType) {
		this.newType = newType;
	}
	
	public int getProfileId() {
		return profileId;
	}

	public void setProfileId(int profileId) {
		this.profileId = profileId;
	}

	private int profileId;
}
