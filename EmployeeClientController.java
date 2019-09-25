package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeClientController {

    
	
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
    public ModelAndView getEmployeeInfo() {
		System.out.println("Test");
        return new ModelAndView("getAllEmployees");
    }
	
}