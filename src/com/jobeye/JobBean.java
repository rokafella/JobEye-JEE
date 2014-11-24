package com.jobeye;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.*;

public class JobBean 
{
	private long jobId;
	private int companyId; 
	private String position;
	private String location;

	public long getJobId() 
	{	return jobId;	}

	public void setJobId(long jobId) 
	{	this.jobId = jobId;	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	} 
	

	@EJB
	JobSession jobSession;
	
	public String AddJob()
	{
		String ret = jobSession.AddJob(companyId, location, position);
		if(ret.equalsIgnoreCase("Exists")){
			return "false";
		}
		return "submit";
	}
	
}
