package com.shantanu.kubehelper;


import io.kubernetes.client.Configuration;
import org.springframework.stereotype.Component;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.ApiClient;

import java.io.IOException;

@Component
public class Client {

    private static ApiClient client = null;

    public static ApiClient getInstance() {
        try {
            if (client == null) {
                client = Config.defaultClient();
                Configuration.setDefaultApiClient(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
            client = null;
        }
        return client;
    }
}
