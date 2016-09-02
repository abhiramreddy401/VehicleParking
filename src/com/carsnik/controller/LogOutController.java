package com.carsnik.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogOutController {
	

	@RequestMapping("/logout")
	public ModelAndView UserMainPage(HttpSession session) {
		if(session != null)
			session.invalidate();
		System.out.println("The Session is Expired .......logout successfully...");
    	return new ModelAndView("redirect:/");
    }
	
	
	/*HttpSession session = request.getSession(false);
	if(session != null)
	    session.invalidate();
	request.getRequestDispatcher("/index.jsp").forward(request,response);
*/
}
