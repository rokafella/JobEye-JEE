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
	
	public static class types{
		public String typeLabel;
		public String typeValue;
		
		public types(String label, String value){
			this.typeLabel = label;
			this.typeValue = value;
		}
		
		public String getTypeLabel() {
			return typeLabel.toString();
		}

		public String getTypeValue() {
			return typeValue.toString();
		}
	}
	
	@EJB
	private ProfileAdd profileAdd;
	
	public static List<String> typesOptions;

	public List<String> getTypesOptions() {
		typesOptions = new ArrayList<String>();
		typesOptions.add("Internship");
		typesOptions.add("Full Time");
		typesOptions.add("Part time");
		List<String> result = profileAdd.oldProfileValues(loginBean.getEmail());
		if(result!=null){
			for(String s:result){
				typesOptions.add(s);
			}
		}
		else{
			System.out.println("NULL NULL");
		}
		return typesOptions;
	}
	
	public String setProfile(){
		return profileAdd.addProfile(type,loginBean.getEmail());
	}
}
