package com.jobeye;

import java.util.Date;

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
	
	private Date date;
	private String description;
	private ApplicationBean applicationBean;

	@EJB
	private com.jobeye.EJB.Service.TaskSession taskSession;
	
	public String addTask()
	{
		
		int taskId = taskSession.AddTask(date, description, applicationBean.getApplicationId());
		if(taskId == -1)
			return "false";
		
		return "submit";
	}
	
}
