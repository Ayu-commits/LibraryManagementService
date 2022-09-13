package org.acme.Controllers;

import org.acme.services.TranscationServices;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.Response.Status.BAD_REQUEST;
import static javax.ws.rs.core.Response.Status.INTERNAL_SERVER_ERROR;


@Path("/api/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TranscationController {
        @Inject
        TranscationServices transcationServices;

        @GET
        @Consumes   (MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        @Transactional
        @Path("/issued/{id}")
       public Response issueBook(@PathParam("id") Long bookId)
        {
//
            try {
                    if(transcationServices.issueBook(bookId)==null)
                        return Response.status(BAD_REQUEST).build();
                    return Response.ok().build();

            }catch (Exception e)
            {
                e.printStackTrace();
                return Response.status(INTERNAL_SERVER_ERROR).build();
            }

        }
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    @Path("return/{id}")
    public Response returnBook(@PathParam("id") Long transactionId)
    {
        try {
            transcationServices.returnBook(transactionId);
            return Response.ok().build();
        }catch (Exception e)
        {
            e.printStackTrace();
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }
    }
}
