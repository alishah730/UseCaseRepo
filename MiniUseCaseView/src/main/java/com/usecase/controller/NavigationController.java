package com.usecase.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.usecase.service.DataFetch;
@Controller
public class NavigationController {

	@Autowired
	DataFetch dataFetch;
	String username, password;
	String url = "http://localhost:8080/MiniUseCaseView";
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(NavigationController.class);
}
