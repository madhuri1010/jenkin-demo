package com.activity.service;

import java.util.List;

import com.activity.model.Project;
import com.activity.pojo.ActivityPOJO;

public interface ActivityService {
	public void saveOrUpdate(ActivityPOJO activity);

	public List<ActivityPOJO> listAllActivity();

	public ActivityPOJO findActivityByWeekId(int weekId);
	public List<ActivityPOJO> listAllActivityByWeekAndProject(int projectId,int weekId);
	public void deleteActivity(int activityId);
	public ActivityPOJO findActivityById(int activityId);
}
