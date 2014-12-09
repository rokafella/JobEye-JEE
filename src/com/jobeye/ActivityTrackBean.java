package com.jobeye;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ejb.EJB;

import com.jobeye.EJB.Entity.ActivityEntity;
import com.jobeye.EJB.Service.ActivityTrackSession;

public class ActivityTrackBean {
	
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
	private ActivityTrackSession activityTrackSession;
	
	List<List<String>> activities;

	public List<List<String>> getActivities() {		
		return foo();
	}

	public void setActivities(List<List<String>> act) {
		this.activities = act;
	}

	public List<List<String>> foo (){
		
		List<List<String>> temp = new ArrayList<>();
		
		List<ActivityEntity> res = activityTrackSession.findActivity(selectedCompany);

		if(res == null){
			return null;
		}
		else{
			for(ActivityEntity en: res){
				List<String> response = new ArrayList();
				response.add(en.getCompany());
				response.add(en.getTitle());
				response.add(en.getDate());
				response.add(en.getDescription());
				temp.add(response);
			}
		}
		
		return temp;
	}
	
	public String trackActivities(){
		return "true";
	}
	
	private String selectedCompany;

	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}
	
	public static Set<String> allCompanies;
	
	public Set<String> getAllCompanies() {
		allCompanies = new HashSet<>();
		List <String> companies = new ArrayList<String>();
		List<String> result = activityTrackSession.allCompanies();
		if(result!=null){
			for(String s:result){
				companies.add(s);
			}
		}
		if(companies!=null){
			allCompanies = new HashSet<>(companies);
		}
		return allCompanies;
	}
}
