package com.shantanu.kubehelper;

import org.springframework.stereotype.Service;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1NamespaceList;


@Service
public class ListNamespaces {
    public V1NamespaceList getservices() throws ApiException {
        CoreV1Api api = new CoreV1Api();
        V1NamespaceList list = api.listNamespace(null, null, null, null, null, null, null, null, null);
        return list;
    }
}
