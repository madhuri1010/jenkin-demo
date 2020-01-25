package com.activity.service;

import java.util.List;

import com.activity.model.Week;
import com.activity.pojo.ActivityPOJO;
import com.activity.pojo.WeekPOJO;
public interface WeekService {

	public List<WeekPOJO> listAllWeeks(int projectId);
}
