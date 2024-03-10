package org.example;

import jakarta.ws.rs.core.UriBuilder;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.net.URI;

public class Main {

    public static void main(String[] args) {
        URI url = UriBuilder.fromUri("http://127.0.0.1").port(8080).build();
        ResourceConfig resourceConfig = new ResourceConfig();
        resourceConfig.register(ScopeController.class);
        resourceConfig.register(new AbstractBinder() {
            @Override
            protected void configure() {
                bindAsContract(ScopeRepository.class);
            }
        });
        GrizzlyHttpServerFactory.createHttpServer(url, resourceConfig);
    }

}
