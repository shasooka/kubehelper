package com.shantanu.kubehelper;

import io.kubernetes.client.util.Config;
import org.springframework.stereotype.Service;
import io.kubernetes.client.ApiClient;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.Configuration;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1NamespaceList;
import java.io.IOException;


@Service
public class ListNamespaces {
    public V1NamespaceList getservices() throws IOException, ApiException {

        ApiClient client = Config.defaultClient();
        Configuration.setDefaultApiClient(client);
        CoreV1Api api = new CoreV1Api();
        V1NamespaceList list = api.listNamespace(null, null, null, null, null, null, null, null, null);
        return list;
    }
}
