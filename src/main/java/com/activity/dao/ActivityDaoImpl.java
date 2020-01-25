package com.activity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Activity;
import com.activity.model.Project;
import com.activity.pojo.ActivityPOJO;

@Repository
public class ActivityDaoImpl implements ActivityDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(Activity activity) {
		getSession().saveOrUpdate(activity);	
	}

	
	public Activity findActivityByWeekId(int weekId) {
		Activity activity = (Activity) getSession().get(Activity.class, weekId);
		return activity;
	}

	@SuppressWarnings("unchecked")
	public List<Activity> fetchActivityByWeek(int weekId) {
		Criteria criteria = getSession().createCriteria(Activity.class).add(Restrictions.eq("weekId",weekId));
		return (List<Activity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Activity> listAllActivity() {
		Criteria criteria = getSession().createCriteria(Activity.class);
		return (List<Activity>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Activity> listAllActivityByWeekAndProject(int projectId, int weekId) {
		Criteria criteria = getSession().createCriteria(Activity.class);
		criteria.add(Restrictions.eq("weekId",weekId));
		criteria.add(Restrictions.eq("projectId",projectId));
		return (List<Activity>) criteria.list();
	}

	public void deleteActivity(int activityId) {
		Activity activity = (Activity) getSession().get(Activity.class, activityId);
		getSession().delete(activity);		
	}

	public Activity findActivityById(int activityId) {	
			Activity activity=(Activity)getSession().get(Activity.class,activityId);
			return activity;			
	}
	
}
