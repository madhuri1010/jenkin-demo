package com.activity.pojo;

public class ActivityPOJO {
	
	private int activityId;
	private String activityPerform;
	private int projectId;
	private int weekId;
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

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	

	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public ActivityPOJO(int activityId, String activityPerform, int projectId) {
		super();
		this.activityId = activityId;
		this.activityPerform = activityPerform;
		this.projectId = projectId;
	}

	public ActivityPOJO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ActivityPOJO [activityId=" + activityId + ", activityPerform=" + activityPerform + ", projectId="
				+ projectId + "]";
	}

	
}
