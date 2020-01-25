package com.activity.model;

//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "activity")
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int activityId;

	@Column(name = "activityPerform")
	private String activityPerform;

	//@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "weekId")
	private int weekId;
	
	//@ManyToOne(cascade = CascadeType.ALL)
	@Column(name = "projectId")
	private int projectId;

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getActivityPerform() {
		return activityPerform;
	}

	public void setActivityPerform(String activityPerform) {
		this.activityPerform = activityPerform;
	}

	
	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public Activity() {
		super();
	}

	public Activity(int activityId, String activityPerform, int weekId, int projectId) {
		super();
		this.activityId = activityId;
		this.activityPerform = activityPerform;
		this.weekId = weekId;
		this.projectId = projectId;
	}

	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", activityPerform=" + activityPerform + ", weekId=" + weekId + ", projectId=" + projectId + "]";
	}

}
