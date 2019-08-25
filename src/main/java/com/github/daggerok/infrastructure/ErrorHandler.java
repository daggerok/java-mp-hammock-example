package com.github.daggerok.infrastructure;

import javax.enterprise.context.ApplicationScoped;
import javax.json.Json;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
@ApplicationScoped
public class ErrorHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        return Response.status(Response.Status.BAD_REQUEST)
                       .header("Content-Type", MediaType.APPLICATION_JSON)
                       .entity(Json.createObjectBuilder()
                                   .add("error", exception.getLocalizedMessage())
                                   .build())
                       .build();
    }
}
