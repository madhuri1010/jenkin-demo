package com.activity.pojo;

import java.util.List;

public class WeekPOJO {
	
	private int weekId;
	private String weekDays;
	private List<ActivityPOJO> activitylist;
	private int projectId;
	public int getWeekId() {
		return weekId;
	}

	public void setWeekId(int weekId) {
		this.weekId = weekId;
	}

	public String getWeekDays() {
		return weekDays;
	}

	public void setWeekDays(String weekDays) {
		this.weekDays = weekDays;
	}

	public WeekPOJO() {
		super();
	}

	public List<ActivityPOJO> getActivitylist() {
		return activitylist;
	}

	public void setActivitylist(List<ActivityPOJO> activitylist) {
		this.activitylist = activitylist;
	}

	
	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public WeekPOJO(int weekId, String weekDays, List<ActivityPOJO> activitylist) {
		super();
		this.weekId = weekId;
		this.weekDays = weekDays;
		this.activitylist = activitylist;
	}

	@Override
	public String toString() {
		return "WeekPOJO [weekId=" + weekId + ", weekDays=" + weekDays + ", activitylist=" + activitylist + "]";
	}

}
