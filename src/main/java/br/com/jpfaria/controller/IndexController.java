package br.com.jpfaria.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.jpfaria.service.PostCurriculumService;

@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);
    
	@RequestMapping(value = "/envia", method = RequestMethod.GET)
	@ResponseBody 
	public String send(PostCurriculumService service) {
		service.post();
		return null;
	}

}