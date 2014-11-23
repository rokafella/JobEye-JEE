package com.jobeye;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.ApplicationSession;

public class ApplicationBean 
{

	public ApplicationBean() 
	{
		// TODO Auto-generated constructor stub
	}

	private int applicationId;
	private int jobId;
	private int profileId;
	public int getProfileId() {
		return profileId;
	}
	public void setProfileId(int profileIdd) {
		this.profileId = profileIdd;
	}

	private String status;
	
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@EJB
	ApplicationSession appSession;
	
	public String addApplication()
	{
		String ret = appSession.AddApplication(jobId, profileId, status);
		if(ret.equalsIgnoreCase("Exists")){
			return "false";
		}
		return "submit";
	}
}
