package com.activity.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.activity.model.UserDocument;


@Repository("userDocumentDao")
public class UserDocumentDaoImpl implements UserDocumentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	public List<UserDocument> findAll() {
		Criteria crit = getSession().createCriteria(UserDocument.class);
		return (List<UserDocument>)crit.list();
	}

	public void save(UserDocument document) {
		getSession().save(document);
	}

	public UserDocument findById(int id) {
		UserDocument document=(UserDocument)getSession().get(UserDocument.class, id);
		return document;
	}
	
	public void deleteById(int id) {
		UserDocument document =  findById(id);
		getSession().delete(document);
	}

}
