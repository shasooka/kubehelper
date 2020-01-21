package com.shantanu.kubehelper;


// import org.springframework.stereotype.Controller;
//import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1NamespaceList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class KubeController {

	private final ListPods listpods;
    private final ListNamespaces listNamespaces;

	public KubeController(ListPods listpods, ListNamespaces listNamespaces){
		this.listpods = listpods;
        this.listNamespaces = listNamespaces;
	}




//    private final ListNamespaces listnamespaces;
//    public KubeController(ListNamespaces listnamespaces){
//        this.listnamespaces = listnamespaces;
//    }

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
