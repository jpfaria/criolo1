package br.com.jpfaria.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/")
	public void index() {
		
	}

}