package com.myapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myapp.model.User;

@Controller
public class UserController {

//   @RequestMapping("demo")
//   public String demo(Model model) {
//       model.addAttribute("message", "Hello Thymeleaf");
//       // return to templates/demo.html page.
//       return "demo";
//   }
	
	@RequestMapping("demo")
	public String demo(Model model) {
	   model.addAttribute("message", "Hello Thymeleaf");
	   double grade = 90.5;
	   model.addAttribute("grade", grade);
	   model.addAttribute("GPA", convertGPA(grade));
	   // return to templates/demo.html page.

	   return "demo";
	}

	private String convertGPA(double grade) {
	   if (grade >= 90) {
	       return "A";
	   } else if (grade < 90 && grade >= 80) {
	       return "B";
	   } else if (grade < 80 && grade >= 70) {
	       return "C";
	   } else if (grade < 70 && grade >= 60) {
	       return "D";
	   } else {
	       return "F";
	   }
	}
	
	
	@RequestMapping("demo2")
	public String demo2(Model model) {
	   List<User> lst = new ArrayList<>();
	   lst.add(new User(1, "Tom", 30));
	   lst.add(new User(2, "Jerry", 29));
	   lst.add(new User(3, "Nancy", 27));
	   model.addAttribute("list", lst);
	   return "demo2";
	}
	
	
	@RequestMapping("demo3")
	public String demo3(HttpServletRequest request, Model model) {
	   // Request
	   request.setAttribute("request", "request data");
	   // Session
	   request.getSession().setAttribute("session", "session data");
	   // Application
	   request.getSession().getServletContext().setAttribute("application", "application data");
	   return "demo2";
	}
}