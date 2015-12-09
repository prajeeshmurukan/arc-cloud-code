package com.arc.cloud.mcv.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Dinesh Rajput
 *
 */
@Controller
public class ArcCloudController {
	
	@RequestMapping("/login")  
	 public ModelAndView sayHello() {  
		System.out.println("HelloSpring4Controller.sayHello()");
	  String message = "Arc Cloud - Electronic Content Archival Management System "; 

	  return new ModelAndView("index2", "map", message);  
	 }  

	
}
