package com.shantanu.kubehelper;

import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Namespace;
import io.kubernetes.client.models.V1ObjectMeta;
import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class CreateNamespace {
    public String createnamespace(String id) throws IOException, ApiException {

        ApiClient client = Config.defaultClient();
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
            return ("Namespace" + id + "Created");
        } catch (Exception e) {
            return ("Couldn't create namespace ");
        }


    }
}
