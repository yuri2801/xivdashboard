package be.yuri.xivdashboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path="/index")
public class MainController {

	@RequestMapping(method=RequestMethod.GET,path="/")
	public String indexView(Model model, HttpSession session) {
		return "index";
	}
}
