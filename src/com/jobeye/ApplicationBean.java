package com.jobeye;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.*;

public class ApplicationBean 
{

	public ApplicationBean() 
	{
		// TODO Auto-generated constructor stub
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}


	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String companyName;
	private String jobTitle;
	private String location;
	private String status;
	
	private LoginBean loginBean;

	@EJB
	ApplicationSession appSession;

	@EJB
	CompanySession companySession; 

	@EJB
	JobSession jobSession; 
	
	
	public String addApplication()
	{
//		Integer companyId = companySession.AddCompany(companyName, "", loginBean.getUserId());
//		if(companyId == null)){
//			return "false";
//		}
//		Integer retJob = jobSession.AddJob(companyId, , position)
//		String ret = appSession.AddApplication(jobId, profileId, status);
//		if(ret.equalsIgnoreCase("Exists")){
//			return "false";
//		}
		return "submit";
	}
}
