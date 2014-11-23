package com.jobeye;

import javax.ejb.EJB;

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

		@EJB
		private LoginService loginSession;
		
		public String validate(){
			String ret = loginSession.validate(email,password);
			if(ret.equalsIgnoreCase("false")){
				return "false";
			}
			this.name = ret;
			return "true";
		}
}
