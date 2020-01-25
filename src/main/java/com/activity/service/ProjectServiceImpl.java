package com.activity.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.activity.dao.ProjectDao;
import com.activity.model.Project;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	 ProjectDao projectDao;
	
	
	public ProjectDao getProjectDao() {
		return projectDao;
	}

	public void setProjectDao(ProjectDao projectDao) {
		this.projectDao = projectDao;
	}

	public void saveOrUpdate(Project project) {
		
		this.projectDao.saveOrUpdate(project);
	}

	public List<Project> listAllProject() {
		return projectDao.listAllProject();
		//return this.projectDao.listAllProject();
	}
	public void deleteProject(int projectId) {
		projectDao.deleteProject(projectId);
	}

	public Project findProjectById(int projectId) {
		return projectDao.findProjectById(projectId);
		
	}

	public List<Project> searchProjectByName(String projectName) {
		return projectDao.searchProjectByName(projectName);
	}

}
