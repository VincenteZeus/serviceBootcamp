/*
 * Bignon
 */
package com.bootcamp.rest.controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;


@Path("/hello")
public class HelloRest {
    
    // PATH PARAMETER(@PathParam)
    
    @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "get Amigo recrache moi : " + msg;
        return Response.status(200).entity(output).build();
    }
    
    @GET
    @Path("/{param1}/encore/{param2}")
    public Response Msg(@PathParam("param1") String msg1, @PathParam("param2") String msg2) {
        String output = "get Amigo recrache moi 1. : " + msg1+" 2. "+ msg2;
        return Response.status(200).entity(output).build();
    }
    
    @POST
    @Path("/{param}")
    public Response postMsg(@PathParam("param") String msg) {
        String output = " post Amigo recrache moi : " + msg;
        return Response.status(200).entity(output).build();
    }
    
    @PUT
    @Path("/{param}")
    public Response putMsg(@PathParam("param") String msg) {
        String output = " put Amigo recrache moi : " + msg;
        return Response.status(200).entity(output).build();
    }
    
    @DELETE
    @Path("/{param}")
    public Response deleteMsg(@PathParam("param") String msg) {
        String output = " delete Amigo recrache moi :";
        return Response.status(200).entity(output).build();
    }
    
    @GET
    public Response home() {
        String output = " Be welcom ! ";
        return Response.status(200).entity(output).build();
    }
    
    // QUERY PARAMETER (@QueryParam)
    @GET
    @Path("/test")
    public Response queryParam(@QueryParam("param1") String msg1,@QueryParam("param2") String msg2 ) {
        String output = "Ho! Query Path! Salut me amigos 1. : " + msg1+" et 2. "+ msg2;
        return Response.status(200).entity(output).build();
    }
}
