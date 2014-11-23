package com.jobeye;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.jobeye.EJB.Service.LoginService;

public class LoginBean {
	
		private String email;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		private String password;
		
		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		private UIComponent mybutton;
		
		@EJB
		private LoginService loginSession;
		
		public String validate(){
			String ret = loginSession.validate(email,password);
			if(ret.equalsIgnoreCase("false")){
				FacesContext.getCurrentInstance().addMessage(mybutton.getClientId(FacesContext.getCurrentInstance()), new FacesMessage("Wrong email or password!"));
				return "false";
			}
			this.name = ret;
			return "true";
		}

		public UIComponent getMybutton() {
			return mybutton;
		}

		public void setMybutton(UIComponent mybutton) {
			this.mybutton = mybutton;
		}
}
