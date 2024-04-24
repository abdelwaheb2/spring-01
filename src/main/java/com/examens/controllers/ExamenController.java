package com.examens.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.examens.entities.Examens;
import com.examens.service.ExamenService;

@Controller
public class ExamenController {
	
	@Autowired
	ExamenService ExamensService;
	@RequestMapping("/ListeExamens")
	public String listeProduits(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,@RequestParam (name="size", defaultValue = "2") int size)
	{
		Page<Examens> ex = ExamensService.getAllProduitsParPage(page, size);
		modelMap.addAttribute("produits", ex);
		modelMap.addAttribute("pages", new int[ex.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		return "ListeExamens";
	}
	 @RequestMapping("/showCreate")
	public String showCreate()
	{
	return "createExamens";
	}
	@RequestMapping("/saveExamens")
	public String saveExamens(@ModelAttribute("Examens") Examens Examens, 
	@RequestParam("date") String date,
	ModelMap modelMap) throws ParseException 
	{
	
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Examens.setdate(dateCreation);
	 
	Examens saveExamens = ExamensService.saveExamens(Examens);
	String msg ="Examens enregistré avec Id "+saveExamens.getid();
	modelMap.addAttribute("msg", msg);
	return "createExamens";
	}
	@RequestMapping("/supprimerExamens")
	public String supprimerExamens(@RequestParam("id") Long id,
	 ModelMap modelMap , @RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
		ExamensService.deleteExamensById(id);
		Page<Examens> ex = ExamensService.getAllProduitsParPage(page, size);
			modelMap.addAttribute("Examens", ex);
			modelMap.addAttribute("pages", new int[ex.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);
			return "listeExamens";
	}
	 
	 @RequestMapping("/modifierExamens")
	public String editerExamens(@RequestParam("id") Long id,ModelMap modelMap)
	{
	Examens e= ExamensService.getExamens(id);
	modelMap.addAttribute("Examens", e);
	return "editerExamens";
	}
	@RequestMapping("/updateExamens")
	public String updateExamens(@ModelAttribute("Examens") Examens 
	Examens, @RequestParam("date") String date,
	 ModelMap modelMap) throws ParseException 
	{
	 
	 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
	 Date dateCreation = dateformat.parse(String.valueOf(date));
	 Examens.setdate(dateCreation);
	 
	 ExamensService.updateExamens(Examens);
	 List<Examens> ex = ExamensService.getAllExamenss();
	 modelMap.addAttribute("Examenss", ex);
	return "listeExamenss";
	}
}



