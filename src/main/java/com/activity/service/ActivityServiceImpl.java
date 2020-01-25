package com.activity.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ActivityDao;
import com.activity.model.Activity;
import com.activity.pojo.ActivityPOJO;

@Service
@Transactional
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao activityDao;

	public ActivityDao getActivityDao() {
		return activityDao;
	}

	public void setActivityDao(ActivityDao activityDao) {
		this.activityDao = activityDao;
	}

	public void saveOrUpdate(ActivityPOJO activitypojo) {
		Activity activity = new Activity();
		activity.setActivityId(activitypojo.getActivityId());
		activity.setActivityPerform(activitypojo.getActivityPerform());
		activity.setProjectId(activitypojo.getProjectId());
		activity.setWeekId(activitypojo.getWeekId());
		this.activityDao.saveOrUpdate(activity);
	}

	public List<ActivityPOJO> listAllActivity() {
		List<Activity> activitylist = activityDao.listAllActivity();
		List<ActivityPOJO> activitypojolist = new ArrayList<ActivityPOJO>();
		for (Activity activity : activitylist) {
			ActivityPOJO activitypojo = new ActivityPOJO();
			activitypojo.setActivityId(activity.getActivityId());
			activitypojo.setActivityPerform(activity.getActivityPerform());
			activitypojo.setProjectId(activity.getProjectId());
			activitypojolist.add(activitypojo);
		}
		return activitypojolist;
	}

	public ActivityPOJO findActivityByWeekId(int weekId) {
		Activity activity = activityDao.findActivityByWeekId(weekId);
		ActivityPOJO activityPOJO = new ActivityPOJO();
		activityPOJO.setWeekId(activity.getWeekId());
		activityPOJO.setActivityId(activity.getActivityId());
		activityPOJO.setActivityPerform(activity.getActivityPerform());
		activityPOJO.setProjectId(activity.getProjectId());
		return activityPOJO;
	}

	public List<ActivityPOJO> listAllActivityByWeekAndProject(int projectId, int weekId) {
		List<Activity> activitylist = activityDao.listAllActivityByWeekAndProject(projectId, weekId);
		List<ActivityPOJO> activitypojolist = new ArrayList<ActivityPOJO>();
		for (Activity activity : activitylist) {
			ActivityPOJO activitypojo = new ActivityPOJO();
			activitypojo.setActivityId(activity.getActivityId());
			activitypojo.setActivityPerform(activity.getActivityPerform());
			activitypojo.setProjectId(activity.getProjectId());
			activitypojo.setWeekId(activity.getWeekId());
			activitypojolist.add(activitypojo);
		}
		return activitypojolist;
	
	}

	public void deleteActivity(int activityId) {
		activityDao.deleteActivity(activityId);
	}

	public ActivityPOJO findActivityById(int activityId) {
		Activity activity= activityDao.findActivityById(activityId);
		ActivityPOJO activityPOJO = new ActivityPOJO();
		activityPOJO.setWeekId(activity.getWeekId());
		activityPOJO.setActivityId(activity.getActivityId());
		activityPOJO.setActivityPerform(activity.getActivityPerform());
		activityPOJO.setProjectId(activity.getProjectId());
		return activityPOJO;
	}


	/*
	 * public List<ActivityPOJO> displayActivityByDays(String weekDays) {
	 * 
	 * List<Activity> activitylist = activityDao.displayActivityByDays(weekDays);
	 * List<ActivityPOJO> activitypojolist = new ArrayList<ActivityPOJO>(); for
	 * (Activity activity : activitylist) { ActivityPOJO activitypojo = new
	 * ActivityPOJO(); activitypojo.setActivityId(activity.getActivityId());
	 * activitypojo.setActivityPerform(activity.getActivityPerform());
	 * activitypojo.setProjectId(activity.getProjectId());
	 * activitypojolist.add(activitypojo); } return activitypojolist; }
	 */

}
