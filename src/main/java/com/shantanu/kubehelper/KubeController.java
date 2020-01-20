package com.shantanu.kubehelper;


// import org.springframework.stereotype.Controller;
import io.kubernetes.client.models.V1Pod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KubeController {

	private final ListPods service;
	public KubeController(ListPods service){
		this.service = service;
	}


	@RequestMapping("/listpods")
	public @ResponseBody
	List<String> greeting() throws Exception
	{
		return service.getpods();
	}
}
