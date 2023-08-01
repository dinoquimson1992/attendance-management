package com.genpact.attendance;

import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import com.genpact.attendance.exception.ApplicationException;
import com.genpact.attendance.exception.StudentNotFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(ClassNotFoundException.class)
	public ModelAndView displayErrorPage1(ClassNotFoundException e) {
		return initView(e.toString());
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ModelAndView displayErrorPage2(StudentNotFoundException e) {
		return initView(e.toString());
	}
	
	@ExceptionHandler(ApplicationException.class)
	public ModelAndView displayErrorPage3(ApplicationException e) {
		return initView(e.toString());
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView displayErrorPage4(Exception e) {
		return initView(e.toString());
	}
	
	@ExceptionHandler(TransactionSystemException.class)
	public ModelAndView displayErrorPage5(TransactionSystemException e) {
		return initView("Please fill out the required fields!");
	}
	
	private ModelAndView initView(String errorMessage) {
		ModelAndView view = new ModelAndView();
		view.setViewName("error");
		view.addObject("message", errorMessage);
		return view;
	}

}
