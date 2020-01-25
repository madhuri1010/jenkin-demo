package com.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.activity.model.Project;
import com.activity.service.ProjectService;


@Controller
@RequestMapping(value = "/projects")
public class ProjectController {
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model){
		List<Project> list = projectService.listAllProject();
		model.addAttribute("list", list);
		return "projects/list";
	}

		 
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public ModelAndView add() {
		ModelAndView model = new ModelAndView("projects/addproject");//return addproject.jsp page
		Project project=new Project();
		model.addObject("projectForm", project);
		List<Project> list = projectService.listAllProject();
		model.addObject("list", list);
		return model;
	}
       
	  @RequestMapping(value = "/save", method = RequestMethod.POST) 
	  public ModelAndView save(@RequestBody Project project) { //after click on submit save to // database and redirect to list page
		  projectService.saveOrUpdate(project);
		  ModelAndView model = new ModelAndView("projects/list");//return addproject.jsp page
		  model.addObject("projectForm", project);
		  List<Project> list = projectService.listAllProject();
		model.addObject("list", list);
		return model;
	  }
	  
	  @RequestMapping(value = "/delete/{projectId}", method = RequestMethod.GET)
		public String delete(@PathVariable("projectId") int projectId) {
			projectService.deleteProject(projectId);
			return "redirect:/projects/add";
		}
	  @RequestMapping(value="/search/{projectName}", method = RequestMethod.GET)
	  public String search1(@PathVariable("projectName") String projectName,Model model)
	  {
		  
		  List<Project> projectlist=projectService.searchProjectByName(projectName);
		  model.addAttribute("projectForm", new Project());
		  model.addAttribute("list",projectlist);
		
		  return "projects/list";
	  }
	
	/*
	 * @RequestMapping(value = "/update/{projectId}", method = RequestMethod.GET)
	 * public String update(@PathVariable("projectId") int projectId,Model model) {
	 * if(projectId!=0) { Project project=
	 * projectService.findProjectById(projectId); model.addAttribute("projectForm",
	 * project); } return "projects/updateproject"; }
	 */
}
