package org.zk.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.List;

@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {

    @GET
    @Path("")
    public Response sayHello() {
        return Response.accepted(Arrays.asList(new User(2L, "zx"), new User(2L, "zk"))).build();
    }
}
