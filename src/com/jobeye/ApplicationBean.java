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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public ProfileBean getProfileBean() {
		return profileBean;
	}

	public void setProfileBean(ProfileBean profileBean) {
		this.profileBean = profileBean;
	}
	
	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}



	private String companyName;
	private String location;
	private String position;
	private String status;
	private int applicationId;
	
	private LoginBean loginBean;
	private ProfileBean profileBean;

	@EJB
	private ApplicationSession appSession;

	@EJB
	private CompanySession companySession; 

	@EJB
	private JobSession jobSession;
	
	public String addApplication()
	{
		int companyId = companySession.AddCompany(companyName, "", loginBean.getUserId());
		if(companyId == -1)
			return "false";
		int jobId = jobSession.AddJob(companyId, location, position);
		if(jobId == -1)
			return "false";
		int applicationId = appSession.AddApplication(jobId, profileBean.getProfileId(), status);
		setApplicationId(applicationId);
		if(applicationId == -1)
			return "false";
		
		return "submit";
	}
}
