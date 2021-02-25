package com.Counter.Controller;

import java.net.http.HttpResponse;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ViewController {
	
	@RequestMapping("/")
    public String index(HttpSession session) {
		session.setAttribute("count", 0);
    	Integer count = (Integer) session.getAttribute("count");
    	
		return "index.jsp";
    }
	
	@RequestMapping("/counter")
    public String counter(Model model, HttpSession session) {
			
		Integer tracker = (Integer) session.getAttribute("count");
		if(tracker == null) {
			 session.setAttribute("count", 0);
			 tracker = 0;
		}
		tracker++;
		session.setAttribute("count", tracker);
		session.getAttribute("count");
		return "counter.jsp";
	}
	
}

