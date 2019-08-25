package com.github.daggerok.infrastructure;

import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import java.net.URI;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@RequestScoped
@Produces(APPLICATION_JSON)
@Consumes(APPLICATION_JSON)
public class FallbackResource {

    @GET
    @Path("")
    public JsonObject index(@Context UriInfo uriInfo) {
        if (System.currentTimeMillis() % 2 == 0) throw new RuntimeException("oops");
        URI base = uriInfo.getBaseUri();
        String baseUrl = String.format("%s://%s", base.getScheme(), base.getAuthority());
        return Json.createObjectBuilder()
                   .add("ololo", "trololo")
                   .add("_base", baseUrl)
                   .build();
    }

    // @GET
    // @Path("")
    // public Response index() {
    //     return Response.ok()
    //                    .build();
    // }
}
