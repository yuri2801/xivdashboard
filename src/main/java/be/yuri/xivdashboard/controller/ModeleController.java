package be.yuri.xivdashboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.yuri.xivdashboard.data.Modele;

@Controller
@RequestMapping(path="/modele")
public class ModeleController {

	@RequestMapping(method=RequestMethod.GET,path="/")
	public String indexView(Model model, HttpSession session) {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/content")
	public @ResponseBody Modele getWindow() {
		Modele model = new Modele();
		
		
		return model;
	}
}
