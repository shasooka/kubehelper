package com.shantanu.kubehelper;

import org.springframework.stereotype.Service;
import io.kubernetes.client.ApiException;
import io.kubernetes.client.apis.CoreV1Api;
import io.kubernetes.client.models.V1Pod;
import io.kubernetes.client.models.V1PodList;

import java.util.ArrayList;
import java.util.List;


@Service
public class ListPods {

    public List<String> getpods() throws ApiException {
        CoreV1Api api = new CoreV1Api();
        V1PodList list =
                api.listPodForAllNamespaces(null, null, null, null, null, null, null, null, null);
        List<String> pods = new ArrayList<>();
        for (V1Pod item : list.getItems()) {
            System.out.println(item.getMetadata().getName());

            pods.add(item.getMetadata().getName());
        }
        return pods;
    }

}