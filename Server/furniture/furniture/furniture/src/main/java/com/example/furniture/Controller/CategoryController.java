package com.example.furniture.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.furniture.DaoImpl.CategoryDaoImpl;
import com.example.furniture.Model.Category;

@CrossOrigin("http://localhost:4200")
@RestController
public class CategoryController {
	@Autowired
	CategoryDaoImpl categoryObj;
	
	@GetMapping("/category")
	public List getCategory() {
		return categoryObj.ViewAllCategory();
	}
	
	@RequestMapping(value = "/addcategory", method = RequestMethod.POST)
	public void addCategory(@RequestBody Category category){

		categoryObj.addCategory(category);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/delete/category/{id}")
	public void deleteCategory(@PathVariable int id) {
		categoryObj.deleteCategory(id);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/update/category")
	public void updateCategory(@RequestBody Category category) {
		categoryObj.updateCategory(category);
	}
	
	
	
}
