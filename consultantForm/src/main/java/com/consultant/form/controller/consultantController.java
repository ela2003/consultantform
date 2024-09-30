package com.consultant.form.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.consultant.form.entity.consultantEntity;
import com.consultant.form.repository.consultantRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class consultantController {
	@Autowired
private consultantRepository consrepo;
	@GetMapping("/form")
	public String showconsForm(Model model) {
		model.addAttribute("form", new consultantEntity());
		return "conindex";	
		
	}
	
	@GetMapping("/load_form")
	public String showadd(Model mod) {
		mod.addAttribute("conform", new consultantEntity());
		return "add";
	}
	
	@GetMapping("/edit_form/{id}")
	public String showedit(@PathVariable (value = "id") long id,  Model mod1) {
		
		java.util.Optional<consultantEntity> form=consrepo.findById(id);
		consultantEntity con = form.get();
		
		
		mod1.addAttribute("form", con);
		return "edit";   
	}
	
	
	@GetMapping("/view_form")
	public String showview(Model mod) {
		
		java.util.List<consultantEntity> list = consrepo.findAll();
		mod.addAttribute("all_consultant",list);
		mod.addAttribute("conform", new consultantEntity());
		return "newindex";
	}
	
	@PostMapping("/save_form")
	
	public String saveform(@ModelAttribute consultantEntity form, HttpSession session ) {
		
		consrepo.save(form);
		session.setAttribute("msg", "product Added Sucessfully...");
		
		
		return "redirect:/load_form";
	}
	
	
@PostMapping("/update_form")
	
	public String updateform(@ModelAttribute consultantEntity form, HttpSession session ) {
		
		consrepo.save(form);
		session.setAttribute("msg", "product update Sucessfully...");
		
		
		return "redirect:/view_form";
	}
	
	
	
@GetMapping("/delete/{id}")
public String deleteform(@PathVariable (value = "id") long id,  HttpSession session) {
	
	consrepo.deleteById(id);
	session.setAttribute("msg", "product delete Sucessfully...");
	return "redirect:/view_form";  
}
	
	
	
	
	@PostMapping("/form")
	public String processconsForm(@ModelAttribute  consultantEntity form,
			@RequestParam("Resume") MultipartFile Resume ) {
		// @RequestParam MultipartFile pdfData
		// , @RequestParam("pdfDoc") MultipartFile pdfDoc
		//@RequestParam("pdfData") MultipartFile pdfData ,
		
		//&& !pdfDoc.isEmpty() 
		
		if (!Resume.isEmpty() ) {
			try {

				
				  String originalFileName = Resume.getOriginalFilename();
				  form.setResumeName(originalFileName);
				  form.setResume(Resume);
				 
					/*
					 * String originalFileName1 = pdfDoc.getOriginalFilename();
					 * registration.setPdfDocName(originalFileName1);
					 * registration.setPdfDoc(pdfDoc.getBytes());
					 */
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		consrepo.save(form);
		return "Registrationsuccess";
	}


	
}
	

