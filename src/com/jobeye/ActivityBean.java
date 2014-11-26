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
	private ActivitySession activitySession;
	private CompanySession companySession;
	private LoginBean loginBean;
	
	public String addActivity()
	{		
		//int companyId = getCompanyIdFromName(company);
		int companyId = companySession.getCompany(selectedCompany,loginBean.getUserId());
		int activityId = activitySession.AddActivity(title, date, description, companyId);
		if(companyId == -1)
			return "false";
		
		if(activityId == -1)
			return "false";
		
		return "submit";
	}
	
	private String selectedCompany;

	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}
	
	public List<List<String>> foo (){
		List<List<String>> temp = new ArrayList<>();
		List<String> compIds = companySession.allCompanies(loginBean.getUserId());
		setTest(String.valueOf(compIds.size()));
//		for(String compid: compIds){	
//			int cid = Integer.parseInt(compid);
//			List<String> compli = new ArrayList<>();
//			
//			String company = companySession.getName(cid);
//			
//			//date title description
////			List<String> res1 = new ArrayList<>();
////			res1 = activitySession.findActivity(cid);
////			
//			compli.add(company);
////			compli.addAll(res1);
//			
//			temp.add(compli);
//		}
		return temp;
	}
	
	List<List<String>> activities;

	public List<List<String>> getActivities() {		
		return foo();
	}

	public void setActivities(List<List<String>> act) {
		this.activities = act;
	}
	
	public String getTest() {
		return test;
	}
	public void setTest(String test) {
		this.test = test;
	}

	private String test;
	
}
