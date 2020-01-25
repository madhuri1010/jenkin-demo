package com.activity.dao;

import java.util.List;

import com.activity.model.Project;

public interface ProjectDao {
	public void saveOrUpdate(Project project);
	public List<Project> listAllProject();
	public void deleteProject(int projectId);
	public Project findProjectById(int projectId); 
	public List<Project> searchProjectByName(String projectName);
	
}
