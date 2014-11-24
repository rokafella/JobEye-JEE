package com.jobeye;

import java.util.Date;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.ActivitySession;

public class ActivityBean 
{	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
		
	private String title;
	private Date date;
	private String description;
	private String company;
	
	@EJB
	private ActivitySession activitySession ;
	
	public String addActivity()
	{		
		int companyId = -111;
		//int companyId = getCompanyIdFromName(company);
		int activityId = activitySession.AddActivity(title, date, description, companyId);
		if(companyId == -1)
			return "false";
		
		if(activityId == -1)
			return "false";
		
		return "submit";
	}
	
}
