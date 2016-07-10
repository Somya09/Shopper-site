package com.niit.shopperssite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.shopperssite.dao.CategoryDAOImpl;
import com.niit.shopperssite.model.Category;

@Controller
public class CategoryController {
@Autowired
private CategoryDAOImpl categoryDAOImpl;
@RequestMapping(value="/category",method=RequestMethod.GET)
public String listCategory(Model model){
	System.out.println("list category");
	model.addAttribute("category", new Category());
	model.addAttribute("categoryList",this.categoryDAOImpl.list());
	return "category";
}

@RequestMapping(value="/category/add",method=RequestMethod.POST)
public String addCategory(@ModelAttribute("category") Category category){
	System.out.println("add category");
	categoryDAOImpl.saveOrUpdate(category);
	return "redirect:/category";
}

@RequestMapping(value="category/remove/{id}")
public String removeCategory(@PathVariable("id") String id, ModelMap model) throws Exception{
	System.out.println("remove category");
	try{
		categoryDAOImpl.delete(id);
		model.addAttribute("message", "Succesfully Added");
	}
	catch(Exception e){
		model.addAttribute("message", e.getMessage());
	}
	return "redirect:/category";
}

@RequestMapping("category/edit/{id}")
public String editCategory(@PathVariable("id") String id, ModelMap model){
	System.out.println("edit category");
	
	model.addAttribute("category", this.categoryDAOImpl.get(id));
	model.addAttribute("categoryList", this.categoryDAOImpl.list());
	return "category";
}

@RequestMapping(value="category/view/{name}", method=RequestMethod.GET)
public String showGames(@PathVariable("name") String name, ModelMap model){
	System.out.println("Category View");
	model.addAttribute("category", new Category());
	model.addAttribute("categoryList", this.categoryDAOImpl.getByName(name));
	return "showGamesByCategory";
}
}
