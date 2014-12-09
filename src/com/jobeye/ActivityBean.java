package com.jobeye;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.ActivitySession;
import com.jobeye.EJB.Service.CompanySession;

public class ActivityBean 
{	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	private String date;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	private String description;
	private String company;
	
	@EJB
	private ActivitySession activitySession;
	
	public String addActivity()
	{		
		int activityId = activitySession.AddActivity(title, date, description, company);
		
		if(activityId == -1)
			return "false";
		
		return "submit";
	}
}
