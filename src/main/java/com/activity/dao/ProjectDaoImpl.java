package com.activity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.activity.model.Project;


@Repository
public class ProjectDaoImpl implements ProjectDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void saveOrUpdate(Project project) {
		getSession().saveOrUpdate(project);	
	}

	@SuppressWarnings("unchecked")
	public List<Project> listAllProject() {
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.addOrder(Order.desc("projectId"));
		return (List<Project>) criteria.list();
	}

	public void deleteProject(int projectId) {
		Project project = (Project) getSession().get(Project.class, projectId);
		getSession().delete(project);		
	}

	public Project findProjectById(int projectId) {
		Project project=(Project)getSession().get(Project.class,projectId);
		return project;		
	}

	public void updateProject(int projectId) {
		getSession().update(projectId);
		
	}
	@SuppressWarnings("unchecked")
	public List<Project> searchProjectByName(String projectName) {
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.add(Restrictions.ilike("projectName",projectName+"%"));
		return (List<Project>) criteria.list();
	}

}
