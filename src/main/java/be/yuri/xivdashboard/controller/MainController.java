package be.yuri.xivdashboard.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import be.yuri.xivdashboard.data.Container;

@Controller
@RequestMapping(path="/index")
public class MainController {

	@RequestMapping(method=RequestMethod.GET,path="/")
	public String indexView(Model model, HttpSession session) {
		return "index";
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/content")
	public @ResponseBody Container[] getContent() {
		List<Container> list = new ArrayList<Container>();
		Container cont1 = new Container();
		cont1.setContent("Je suis le container 1");
		cont1.setName("Cont1");
		cont1.setX(1);cont1.setY(1);cont1.setW(1);cont1.setH(1);
		cont1.setTemplate("/xivdashboard/resources/templates/controller1.html");
		cont1.setController("cont1Ctrl");
		Container cont2 = new Container();
		cont2.setContent("Je suis le container 1");
		cont2.setName("Cont1");
		cont2.setX(1);cont2.setY(1);cont2.setW(1);cont2.setH(1);
		cont2.setTemplate("/xivdashboard/resources/templates/controller1.html");
		cont2.setController("cont1Ctrl");
		
		list.add(cont1);
		list.add(cont2);
		return list.toArray(new Container[list.size()]);
	}
	
	@RequestMapping(method=RequestMethod.POST,path="/content")
	public ResponseEntity<Container[]> setContent(@RequestBody Container[] containers) {
		for(int i = 0; i < containers.length; i++)
			System.out.println(containers[i]);
		return new ResponseEntity<Container[]>(containers, HttpStatus.OK);
	}
}
