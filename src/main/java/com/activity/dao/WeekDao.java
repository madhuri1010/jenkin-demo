package com.activity.dao;

import java.util.List;

import com.activity.model.Activity;
import com.activity.model.Week;

public interface WeekDao {

	public List<Week> listAllWeeks();
	public List<Activity> displayActivityByWeekId(int weekId); 
	
}
