package com.niit.shopperssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopperssite.dao.UserDAOImpl;

@Controller
public class UserController {
@Autowired
private UserDAOImpl userDAOImpl;
@RequestMapping("/isValidUser")
public ModelAndView isValidUser(@RequestParam(value="id") String id, @RequestParam(value="password") String password){
	System.out.println("User Controller");
	System.out.println(id+" "+password);
	if(userDAOImpl.isValidUser(id, password, true)){
		ModelAndView mv = new ModelAndView("/adminPage");
		return mv;
	}
	else{
		ModelAndView mv = new ModelAndView("/signin");
		return mv;
	}
	
}

@RequestMapping("/adminHome")
public ModelAndView showAdmin(){
	ModelAndView mv = new ModelAndView("adminHome");
	return mv;
}

}
