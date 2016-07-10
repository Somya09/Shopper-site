package com.niit.shopperssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.shopperssite.dao.CategoryDAOImpl;
import com.niit.shopperssite.model.Category;

@Controller
public class OtherController {
@Autowired
private CategoryDAOImpl categoryDAOImpl;
@RequestMapping("/")
public ModelAndView showIndex(){
	ModelAndView mv = new ModelAndView("/index");
	mv.addObject("category", new Category());
	mv.addObject("categoryList",this.categoryDAOImpl.list());
	return mv;
}

@RequestMapping("/signin")
public ModelAndView showSignin(){
	ModelAndView mv = new ModelAndView("/signin");
	return mv;
}

@RequestMapping("/signup")
public ModelAndView showSignup(){
	ModelAndView mv = new ModelAndView("/signup");
	return mv;
}
@RequestMapping("/about")
public ModelAndView showAbout(){
	ModelAndView mv = new ModelAndView("/about");
	return mv;
}
@RequestMapping("/contact")
public ModelAndView showContact(){
	ModelAndView mv = new ModelAndView("/contact");
	return mv;
}
@RequestMapping("/secureLogin")
public ModelAndView secureLogin(){
	ModelAndView mv = new ModelAndView("/secureLogin");
	return mv;
}
}
