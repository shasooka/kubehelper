package com.shantanu.kubehelper;

import org.springframework.stereotype.Service;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
//import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1NamespaceList;
import io.kubernetes.client.util.ClientBuilder;
import io.kubernetes.client.util.KubeConfig;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ListNamespaces {
    public V1NamespaceList getservices() throws IOException, ApiException {

        String kubeConfigPath = "/Users/kumshant0/.kube/config";

        // loading the out-of-cluster config, a kubeconfig from file-system
        ApiClient client =
                ClientBuilder.kubeconfig(KubeConfig.loadKubeConfig(new FileReader(kubeConfigPath))).build();

        // set the global default api-client to the in-cluster one from above
        Configuration.setDefaultApiClient(client);

        CoreV1Api api = new CoreV1Api();
        V1NamespaceList list = api.listNamespace(null, null, null, null, null, null, null, null, null);
        return list;


//        V1NamespaceList list =
//                api.listNamespace(null, null, null, null, null, null, null, null, null);
//        List<String> pods = new ArrayList<>();
//        for (V1NamespaceList item : list.getItems()) {
//            System.out.println(item.getMetadata().getContinue());
//
//            pods.add(item.getMetadata().getName());
//        }
//        return pods;
    }
}
