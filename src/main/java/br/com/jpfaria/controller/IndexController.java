package br.com.jpfaria.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.jpfaria.service.PostCurriculumService;

@Controller
public class IndexController {

    private Logger logger = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/enviaDados")
	public void index() {
		PostCurriculumService service = new PostCurriculumService();
		service.post();
	}

}