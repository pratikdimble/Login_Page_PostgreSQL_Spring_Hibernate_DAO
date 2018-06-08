package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.delegate.Employee_Delegate;



@Controller
public class HomeController {

@RequestMapping(value="/")
public String landing(HttpServletRequest req,HttpServletResponse res)
{
	
	return "/views/login_form";

}

   @RequestMapping(value="showLogin")
	public String showLogin(HttpServletRequest req,HttpServletResponse res)
	{
		
		return "/login_form";
}
   
   @RequestMapping(value="login")
   public ModelAndView showData(HttpServletRequest req,HttpServletResponse res)
	{
	   String name=req.getParameter("name");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		 		//use Delegagate
		Employee_Delegate delegate=null;
		String 	insertResult=null;
		delegate=new Employee_Delegate ();
			ModelAndView mv=new ModelAndView();
 	  try{
 	  insertResult=delegate.addEmployee(name,salary);

 	  }//try close

 	  catch(Exception e){
 		  req.setAttribute("errMsg",e.getMessage());

 	  }//catch
 	mv.setViewName("/views/display");
	mv.addObject("insertResult",insertResult);
	return mv;
	
}
}
