package org.zk.config;

import org.codehaus.jackson.jaxrs.JacksonJaxbJsonProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.zk.controller.HelloResource;

public class MyApplication extends ResourceConfig {


    public MyApplication() {
        register(new HelloResource());
        register(JacksonJaxbJsonProvider.class);
    }
}