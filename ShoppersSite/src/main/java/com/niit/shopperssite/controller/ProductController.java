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
import com.niit.shopperssite.dao.ProductDAOImpl;
import com.niit.shopperssite.dao.SupplierDAOImpl;
import com.niit.shopperssite.model.Category;
import com.niit.shopperssite.model.Product;
import com.niit.shopperssite.model.Supplier;

@Controller
public class ProductController {
@Autowired
private ProductDAOImpl productDAOImpl;
@Autowired
private SupplierDAOImpl supplierDAOImpl;
@Autowired
private CategoryDAOImpl categoryDAOImpl;
@RequestMapping(value = "/products", method = RequestMethod.GET)
public String listProducts(Model model) {
	model.addAttribute("product", new Product());
	model.addAttribute("category", new Category());
	model.addAttribute("supplier", new Supplier());
	model.addAttribute("productList", this.productDAOImpl.list());
	model.addAttribute("categoryList", this.categoryDAOImpl.list());
	model.addAttribute("supplierList", this.supplierDAOImpl.list());
	return "product";
}

// For add and update product both
@RequestMapping(value = "/product/add", method = RequestMethod.POST)
public String addProduct(@ModelAttribute("product") Product product) {

	Category category = categoryDAOImpl.getByName(product.getCategory().getName());
	categoryDAOImpl.saveOrUpdate(category);  // why to save??

	Supplier supplier = supplierDAOImpl.getByName(product.getSupplier().getName());
	supplierDAOImpl.saveOrUpdate(supplier); // Why to save??
	
	
	
	product.setCategory(category);
	product.setSupplier(supplier);
	
	product.setCategory_id(category.getId());
	product.setSupplier_id(supplier.getId());
	productDAOImpl.saveOrUpdate(product);

	return "redirect:/product";

}

@RequestMapping("product/remove/{id}")
public String removeProduct(@PathVariable("id") String id, ModelMap model) throws Exception {

	try {
		productDAOImpl.delete(id);
		model.addAttribute("message", "Successfully Added");
	} catch (Exception e) {
		model.addAttribute("message", e.getMessage());
		e.printStackTrace();
	}
	// redirectAttrs.addFlashAttribute(arg0, arg1)
	return "redirect:/product";
}

@RequestMapping("product/edit/{id}")
public String editProduct(@PathVariable("id") String id, Model model) {
	System.out.println("editProduct");
	model.addAttribute("product", this.productDAOImpl.get(id));
	model.addAttribute("productList", this.productDAOImpl.list());
	model.addAttribute("categoryList", this.categoryDAOImpl.list());
	model.addAttribute("supplierList", this.supplierDAOImpl.list());

	return "product";
}
}
