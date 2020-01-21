package com.shantanu.kubehelper;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
//import io.kubernetes.client.models.V1Namespace;
//import io.kubernetes.client.models.V1NamespaceBuilder;
//import io.kubernetes.client.models.V1NamespaceList;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1ObjectMeta;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;


@Service
public class CreateNamespace {
    public void createnamespace(String id) throws IOException, ApiException {

        String kubeConfigPath = "/Users/kumshant0/.kube/config";

        // loading the out-of-cluster config, a kubeconfig from file-system
        ApiClient client =
                ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();

        // set the global default api-client to the in-cluster one from above
        Configuration.setDefaultApiClient(client);

        try {
            CoreV1Api api = new CoreV1Api();
            V1Namespace ns = new V1Namespace();
            ns.setApiVersion("v1");
            ns.setKind("Namespace");
            V1ObjectMeta meta = new V1ObjectMeta();
            meta.setName(id);
            ns.setMetadata(meta);
            api.createNamespace(ns, null, null, null);
            System.out.println("Namespace" + id + "Created");
        }
        catch (Exception e){
            System.out.println("Couldn't create namespace ");
        }


    }
}
