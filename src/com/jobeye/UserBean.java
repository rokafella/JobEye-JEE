package com.jobeye;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.jobeye.EJB.Service.ProfileAdd;
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

	private UIComponent mybutton;
	
	@EJB
	private UserAdd userAdd;
	
	@EJB
	private ProfileAdd profileAdd;
	
	public String submit(){
		String ret = userAdd.UserAdd(name,email,phone,password);
		if(ret.equalsIgnoreCase("Exists")){
			FacesContext.getCurrentInstance().addMessage(mybutton.getClientId(FacesContext.getCurrentInstance()), new FacesMessage("User with this Email already exists!"));
			return "false";
		}
		
		return "login";
	}

	public UIComponent getMybutton() {
		return mybutton;
	}

	public void setMybutton(UIComponent mybutton) {
		this.mybutton = mybutton;
	}
	
}
