package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.*;

@Path("/api/scopes")
public class ScopeController {

    @Context
    private Request request;

    @Context
    private UriInfo uriInfo;

    @Inject
    private ScopeRepository scopeRepository;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response allScopes() {
        System.out.printf("%s %s%n", request.getMethod(), uriInfo.getPath());
        return Response.ok(scopeRepository.selectAll()).build();
    }

}
