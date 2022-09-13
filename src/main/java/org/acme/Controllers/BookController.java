package org.acme.Controllers;

import org.acme.Entity.Book;
import org.acme.dao.BookRepo;
import org.acme.services.BookServices;
import org.jboss.resteasy.specimpl.BuiltResponseEntityNotBacked;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.List;
import java.util.Optional;

import static javax.ws.rs.core.Response.Status.*;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

    @Inject
    BookServices bookServices;
    @GET
    public Response getAllBooks() {
        List<Book> books= bookServices.getAllBooks();
        try{
            if(books.size()<=0)
            {
                return Response.status(INTERNAL_SERVER_ERROR).build();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return Response.ok(books).build();
    }

    @GET
    @Path("{id}")
    public Book getBookById(@PathParam("id") Long id) {
        Book book = null;
        try {
            book = this.bookServices.getBookById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)

    public Book addBook(Book obj2){
        Book obj = new Book();

        //obj.setId(obj2.getId());
        obj.setNoOfBooks(obj2.getNoOfBooks());
        obj.setAuthor(obj2.getAuthor());
        obj.setName(obj2.getName());
        obj.setNoOfPages(obj2.getNoOfPages());
        bookServices.addBook(obj);
        return obj;

    }
    @DELETE
    @Path("{id}")
    @Transactional
    public Response delBook(@PathParam("id")Long id)
    {
        try{
            bookServices.deleteBook(id);
            return Response.status(NO_CONTENT).build();
        }catch(Exception e)
        {
            e.printStackTrace();
            return Response.status(INTERNAL_SERVER_ERROR).build();
        }

    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public Response updateBook(@PathParam("id") Long id, Book obj)
    {
        try {
            Book book = bookServices.updateBook(obj,id); // jb update krna hoga , book id ke sath author id bhi same hona chaiye
            return Response.ok(book).build();
        }catch (Exception e) {
            e.printStackTrace();
            return Response.status(NOT_MODIFIED).build();
        }

    }
}
