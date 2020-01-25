package com.activity.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ActivityDao;
import com.activity.dao.WeekDao;
import com.activity.model.Activity;
import com.activity.model.Week;
import com.activity.pojo.ActivityPOJO;
import com.activity.pojo.WeekPOJO;

@Service
@Transactional
public class WeekServiceImpl implements WeekService {

	@Autowired
	WeekDao weekDao;
	
	@Autowired
	ActivityDao activityDao;

	public WeekDao getWeeekDao() {
		return weekDao;
	}

	public void setWeekDao(WeekDao weekDao) {
		this.weekDao = weekDao;
	}

	public List<WeekPOJO> listAllWeeks(int projectId) {
		List<Week> weeklist = weekDao.listAllWeeks();
		List<WeekPOJO> weekpojolist = new ArrayList<WeekPOJO>();
		for (Week week : weeklist) {
			WeekPOJO weekpojo = new WeekPOJO();
			weekpojo.setWeekId(week.getWeekId());
			weekpojo.setWeekDays(week.getWeekDays());
			weekpojo.setActivitylist(prepareActivity(week.getWeekId(),projectId));
			weekpojolist.add(weekpojo);
		}
		return weekpojolist;
	}

	
	public List<ActivityPOJO> prepareActivity(int weekId,int projectId) {

		List<Activity> activitylist = activityDao.listAllActivityByWeekAndProject(projectId,weekId);
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
	
	
}
