package com.activity.service;

import java.util.List;

import com.activity.model.Project;

public interface ProjectService {
	public void saveOrUpdate(Project project);
	public void deleteProject(int projectId);
	public List<Project> listAllProject();
	public Project findProjectById(int projectId);
	public List<Project> searchProjectByName(String projectName);
}
