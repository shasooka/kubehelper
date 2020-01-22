package com.shantanu.kubehelper;


import io.kubernetes.client.ApiClient;
import org.springframework.stereotype.Controller;
import io.kubernetes.client.models.V1NamespaceList;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KubeController {

    public static ApiClient client = Client.getInstance();

	private final ListPods listpods;
    private final ListNamespaces listNamespaces;

	public KubeController(ListPods listpods, ListNamespaces listNamespaces){
		this.listpods = listpods;
        this.listNamespaces = listNamespaces;
	}

    @RequestMapping("/")
    public @ResponseBody
    String home() {
        return "Kube Helper Home";
    }

	@RequestMapping("/listpods")
	public @ResponseBody
	List<String> greeting() throws Exception
	{
		return listpods.getpods();
	}


    @RequestMapping("/listnamespaces")
    public @ResponseBody
    V1NamespaceList listnamespaces() throws Exception
    {
        return listNamespaces.getservices();
    }


    @GetMapping("/api/createnamespace")
    @ResponseBody
    public String createNameSpace(@RequestParam(required = false) String id) throws Exception {
        CreateNamespace createNamespace = new CreateNamespace();
        createNamespace.createnamespace(id);
	    return "ID: " + id;
    }
}
