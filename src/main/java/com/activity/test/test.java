package com.activity.test;

import java.util.List;
import java.util.Scanner;

import com.activity.dao.ActivityDaoImpl;
import com.activity.model.Activity;
import com.activity.service.ActivityService;

public class test {

	public static void main(String[] args) 
	{
	Scanner sc=new Scanner(System.in);
	int weekId;
	System.out.println("Enter the weekId");weekId=sc.nextInt();
	Activity act=new Activity();
	ActivityDaoImpl  activityDao=new ActivityDaoImpl();
//	List<Activity> list=activityDao.listAllActivity();
//	System.out.println(list);
	
	
	}

}
