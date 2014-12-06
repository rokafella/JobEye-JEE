package com.jobeye;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;


public class TaskBean 
{
	
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
	public ApplicationBean getApplicationBean() {
		return applicationBean;
	}
	public void setApplicationBean(ApplicationBean applicationBean) {
		this.applicationBean = applicationBean;
	}
	
	public LoginBean getLoginBean() {
		return loginBean;
	}
	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}
	
	public ArrayList<String> getAllApplications() {
		ArrayList<String> applicationsToBind = new ArrayList<String>();
		List<com.jobeye.EJB.Entity.ApplicationEntity> applications = applicationSession.getAllApplicationsForTasks("open");
		for(com.jobeye.EJB.Entity.ApplicationEntity s:applications)
			applicationsToBind.add(s.getDescription());
			
		return applicationsToBind;
	}
	public void setAllApplications(
			ArrayList<com.jobeye.EJB.Entity.ApplicationEntity> allApplications) {
		this.allApplications = allApplications;
	}
	public String getSelectedApplication() {
		return selectedApplication;
	}
	public void setSelectedApplication(String selectedApplication) {
		this.selectedApplication = selectedApplication;
	}
	
	private Date date;
	private String description;
	private ApplicationBean applicationBean;
	private LoginBean loginBean;

	private ArrayList<com.jobeye.EJB.Entity.ApplicationEntity> allApplications;
	private String selectedApplication;
	

	@EJB
	private com.jobeye.EJB.Service.TaskSession taskSession;
	
	@EJB
	private com.jobeye.EJB.Service.ApplicationSession applicationSession;
	
	public String addTask()
	{
		
		int taskId = taskSession.AddTask(date, description, applicationSession.getapplicationFordescription(selectedApplication, loginBean.getUserId()));
		if(taskId == -1)
			return "false";
		
		return "submit";
	}
	
}
