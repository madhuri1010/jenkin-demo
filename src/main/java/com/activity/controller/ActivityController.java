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
import com.activity.pojo.ActivityPOJO;
import com.activity.pojo.WeekPOJO;
import com.activity.service.ActivityService;
import com.activity.service.WeekService;

@Controller
@RequestMapping(value = "/activities")
public class ActivityController {
	@Autowired
	ActivityService activityService;

	@Autowired
	WeekService weekService;

	
	 @RequestMapping(value = "/activitylist/{projectId}", method = RequestMethod.GET)
	 	public String list(@PathVariable int projectId, Model model) { 
		 List<WeekPOJO> weeklist = weekService.listAllWeeks(projectId);
		model.addAttribute("weeklist", weeklist);
		return "projects/activitylist"; 
	  }
	 

	@RequestMapping(value = "/addactivity/{projectId}", method = RequestMethod.GET)
	public ModelAndView add(@PathVariable int projectId) {

		ModelAndView model = new ModelAndView("projects/addactivity");

		ActivityPOJO activity = new ActivityPOJO();
		activity.setProjectId(projectId);
		model.addObject("activityForm", activity);
		model.addObject("projectId", projectId);
		List<WeekPOJO> weeklist = weekService.listAllWeeks(projectId);
		model.addObject("weeklist", weeklist);

		return model;
	}

	@RequestMapping(value = "/saveactivity", method = RequestMethod.POST)
	public String save(@RequestBody ActivityPOJO activity, Model model) {
		activityService.saveOrUpdate(activity);
		model.addAttribute("activityForm", activity);
		List<ActivityPOJO> activitylist = activityService.listAllActivityByWeekAndProject(activity.getProjectId(),activity.getWeekId()); 
		model.addAttribute("activitylist", activitylist);
		return "projects/activitylist";
	}

	  @RequestMapping(value = "/delete/{activityId}/{projectId}", method = RequestMethod.GET)
		public String delete(@PathVariable("activityId") int activityId,@PathVariable("projectId") int projectId) {
			activityService.deleteActivity(activityId);
			return "redirect:/activities/addactivity/"+projectId;
		}
	  
	 /* @RequestMapping(value = "/update/{activityId}/{projectId}", method = RequestMethod.GET)
		public String update(@PathVariable("activityId") int activityId,@PathVariable("projectId") int projectId,Model model) {
			if(activityId!=0)
			{
				ActivityPOJO activity = activityService.findActivityById(activityId);
				model.addAttribute("activityForm", activity);
			}
			return "projects/updateactivity";
			///Project_Activity/WEB-INF/jsp/projects/addactivity/224.jsp
		}*/
}
