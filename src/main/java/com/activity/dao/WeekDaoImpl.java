package com.activity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Activity;
import com.activity.model.Week;

@Repository
public class WeekDaoImpl implements WeekDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<Week> listAllWeeks() {
		Criteria criteria = getSession().createCriteria(Week.class);
		criteria.addOrder(Order.asc("weekId"));
		return (List<Week>) criteria.list();
	}

	@SuppressWarnings("unchecked")
	public List<Activity> displayActivityByWeekId(int weekId) {
		Criteria criteria = getSession().createCriteria(Week.class);
		criteria.add(Restrictions.eq("weekId",weekId));
		return (List<Activity>) criteria.list();
	}
	
	
}
