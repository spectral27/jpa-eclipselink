package org.example;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertScope(Scope scope) {
        System.out.printf("%s %s%n", request.getMethod(), uriInfo.getPath());
        scopeRepository.insert(scope);
        return Response.ok().build();
    }

}
