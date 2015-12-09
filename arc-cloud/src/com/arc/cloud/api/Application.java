package com.arc.cloud.api;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class Application extends ResourceConfig {

    public Application() {
    	//final Application application = new ResourceConfig().packages("org.glassfish.jersey.examples.multipart").register(MultiPartFeature.class);
    	packages("org.glassfish.jersey.examples.multipart").register(MultiPartFeature.class);
        packages(this.getClass().getPackage().getName());
    }

}