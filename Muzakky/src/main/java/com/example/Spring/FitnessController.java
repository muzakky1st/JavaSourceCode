package com.example.Spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FitnessController {

	@Autowired
	private FitnessService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Fitness>listFitnessx = service.listAll();
		model.addAttribute("listFitnessx", listFitnessx);
		
		return "index";
	}
	
	@RequestMapping("/new")
	public String showNewFitnessPage(Model model) {
		Fitness fitness = new Fitness();
		model.addAttribute("fitness", fitness);
		
		return "new_fitness";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveFitness(@ModelAttribute("fitness") Fitness fitness ) {
		service.Save(fitness);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditFitnessPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView ("edit_fitness");
		Fitness fitness = service.get(id);
		mav.addObject("fitness", fitness);
		
		return mav;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteFitness(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/";
	}
	
	@RequestMapping(value ="/update", method = RequestMethod.POST)
	public String updateFitness(@ModelAttribute("fitness") Fitness fitness) {
		service.Save(fitness);
		return "/redirect:/";
	}
}
