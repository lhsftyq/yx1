package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/clocking"})
public class ClockingController {

	@GetMapping("/index")
	public String  index() {
		
		return "front/clocking_in/clocking-in";
	}
}
