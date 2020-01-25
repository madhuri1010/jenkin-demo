package com.activity.dao;

import java.util.List;

import com.activity.model.Activity;
import com.activity.model.Project;
import com.activity.pojo.ActivityPOJO;

public interface ActivityDao {
	public void saveOrUpdate(Activity activity);
	public Activity findActivityByWeekId(int weekId);
	public List<Activity> fetchActivityByWeek(int weekId);
	public List<Activity> listAllActivity();
	public List<Activity> listAllActivityByWeekAndProject(int projectId,int weekId);
	public void deleteActivity(int activityId); 
	public Activity findActivityById(int activityId);
}
