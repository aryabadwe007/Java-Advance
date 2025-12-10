package com.demo.SpringbootMVCProductCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.SpringbootMVCProductCrud.beans.Product;
import com.demo.SpringbootMVCProductCrud.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

		// TODO Auto-generated method stub
		@Autowired		
		ProductService pservice;
		
		
		@GetMapping("/getProducts")
		public ModelAndView getAllProducts() {
			List<Product> plist = pservice.findAllProducts();
			return new ModelAndView("showproduct","plist",plist);
		}
		
		@GetMapping("/addProduct")
		public  String showaddProductform(Model m){
			m.addAttribute("product",new Product());
			return "insertproduct";
		}
		
		@PostMapping("/insertproduct")
		public ModelAndView insertProduct(@ModelAttribute Product prod) {
			pservice.addnewProduct(prod);
			return new ModelAndView("redirect:/product/getProducts");
			
		}
		
		@GetMapping("/editProduct/{pid}")
		public ModelAndView editProduct(@PathVariable int pid) {
			Product p = pservice.getById(pid);
			if(p!=null) {
				return new ModelAndView ("editProduct","prod",p);
			}else {
				return new ModelAndView("redirect:/product/getProducts");
			}
			
			
		}
		
		@PostMapping("/updateProduct")
		public ModelAndView updateProduct(@ModelAttribute Product prod) {
			pservice.updateProduct(prod);
			return new ModelAndView("redirect:/product/getProducts");
		}
		
		@GetMapping("/deleteProduct/{pid}")
		public ModelAndView deleteProduct(@PathVariable int pid) {
			pservice.deleteProduct(pid);
			return new ModelAndView("redirect:/product/getProducts");
			
		}
		
	}


