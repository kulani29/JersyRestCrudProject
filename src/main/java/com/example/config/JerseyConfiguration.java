package com.example.config;

import com.example.controller.UserResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/boot")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        try {
            this.register(UserResource.class);
        } catch (Exception e) {
            System.out.println("Exception occured:" + e.getMessage());
        }
    }
}
