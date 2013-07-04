package br.com.jpfaria.service;

import java.io.File;

import org.springframework.core.io.FileSystemResource;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

public class PostCurriculumService {

	public void post() {
	
		String url = "http://www.marcuscavalcanti.net/trash/rest-api/index.php/resume?format=json";
		String file = "/home/jpfaria/Documentos/sed.pdf";
		
		RestTemplate template = new RestTemplate();
		
		MultiValueMap<String, Object> form = new LinkedMultiValueMap<String, Object>();
		form.add("email", "jpfaria@gmail.com");
		form.add("questionAnswer", "test");
		form.add("resumeFile", new FileSystemResource(new File(file)));
		
		template.postForLocation(url, form);
		
	}
	
}