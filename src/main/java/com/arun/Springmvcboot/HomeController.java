package com.arun.Springmvcboot;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.arun.Springmvcboot.model.Alien;

@Controller
public class HomeController {
	
	@Autowired
	AlienRepo repo;
	
	@RequestMapping ("/")
	public String home() {
		return "index";
	}
	
	
//	 Model Attribute will be called and object is created which is available for all the jsp files
	@ModelAttribute
	public void modelData(Model m) {
		m.addAttribute("name","Aliens");
		}

	
	
	//Same as JSP and Servlets
//	@RequestMapping("add")
//	public String add(HttpServletRequest req) {
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//
//		int num3 = i + j;
//		
//		HttpSession session = req.getSession();
//		session.setAttribute("num3", num3);
//		return "result.jsp";
//	}
//	
	
	
//	 But in spring, same thing is done using ModelAndView
//	@RequestMapping("add")
//	public ModelAndView add(@RequestParam("num1")int i,@RequestParam("num2") int j) {
//		
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("result");
//		int num3 = i+j;
//		mv.addObject("num3", num3);
//		return mv;
//	}
	
	
//	 But in spring, same thing is done using Model or ModelMap
//	@RequestMapping("add")
//	public String add(@RequestParam("num1")int i,@RequestParam("num2") int j,Model m) {
//		
//		int num3 = i+j;
//		m.addAttribute("num3", num3);
//		return "result";
//	}
//	

	
//	Controller for addAlien as above
//	@RequestMapping("addAlien")
//	public String addAlien(@RequestParam("aid")int aid,@RequestParam("aname") String aname, Model m) {
//		Alien a = new Alien();
//		a.setAid(aid);
//		a.setAname(aname);
//		m.addAttribute("alien", a);
//		
//	
//		return "result";
//	}
	
//	Controller for addAlien automatic
	@PostMapping("addAlien")
	public String addAlien(@ModelAttribute("a1")Alien a) {
		repo.save(a);
		return "result";
	}
	
	
	@GetMapping("getAlien")
	public String getAlien(@RequestParam("aid") int aid,Model m) {
		System.out.println("Aid is:"+aid);
		m.addAttribute("result", repo.getOne(aid));
		return "showAliens";
	}
	
//	@GetMapping("getAliens")
//	public String getAlien(Model m) {
//		m.addAttribute("result", repo.findAll());
//		return "showAliens";
//	}
//	
	
	//Using DSL
//	@GetMapping("getAlienByName")
//	public String getAlien(@RequestParam String aname,Model m) {
//		System.out.println("Aid is:"+aname);
//		m.addAttribute("result", repo.findByAnameOrderByAidDesc(aname));
//		return "showAliens";
//	}
	
	
	//Using annotations
	@GetMapping("getAlienByName")
	public String getAlien(@RequestParam String aname,Model m) {
		System.out.println("Aname is:"+aname);
		m.addAttribute("result", repo.find(aname));
		return "showAliens";
	}
	
//	@GetMapping("getallAliens")
//	public String getAliens(Model m) {
//		m.addAttribute("result", repo.findAll());
//		return "showAliens";
//	}
//	
	
	

}
