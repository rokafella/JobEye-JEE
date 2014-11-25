package com.jobeye;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.jobeye.EJB.Service.*;

public class ApplicationBean 
{

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
		int companyId = companySession.getCompany(selectedCompany,loginBean.getUserId());
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
	
	public static List<String> allCompanies;

	public List<String> getAllCompanies() {
		allCompanies = new ArrayList<String>();
		List<String> result = companySession.allCompanies(loginBean.getUserId());
		if(result!=null){
			for(String s:result){
				allCompanies.add(s);
			}
		}
		return allCompanies;
	}
	
	public String addCompany(){
		int res = companySession.AddCompany(companyName,loginBean.getUserId());
		if(res==-1){
			return "false";
		}
		else{
			return "true";
		}
	}
	
	public String getSelectedCompany() {
		return selectedCompany;
	}

	public void setSelectedCompany(String selectedCompany) {
		this.selectedCompany = selectedCompany;
	}

	private String selectedCompany;
	
	List<List<String>> applications;

	public List<List<String>> getApplications() {
		
		return applications;
	}

	public void setApplications(List<List<String>> applications) {
		this.applications = applications;
	}
	
	public String trackStatus;

	public String getTrackStatus() {
		return trackStatus;
	}

	public void setTrackStatus(String trackStatus) {
		this.trackStatus = trackStatus;
	}
	
	public String trackApplications(){
		
		List<Integer> jobIds = appSession.getAllApps(profileBean.getProfileId(),"Open");
		
		for(int jobid: jobIds){
			//int companyID = jobSession.getCompanyId(jobid);
//			String location = jobSession.getLocation(jobid);
//			String position = jobSession.getPosition(jobid);
//			String company = companySession.getName(companyID);
			List<String> appli = jobSession.getApps(jobid);
//			appli.add(company);
//			appli.add(location);
//			appli.add(position);
			if(appli==null){
				System.out.println("NONONONONON");
			}
			else{
				applications.add(appli);
				System.out.println("HHAAHAHAHA");
			}
			return "false";
		}
		
		return "true";
	}
}
