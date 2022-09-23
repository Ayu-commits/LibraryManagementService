package org.acme.services;

import org.acme.Entity.Book;
import org.acme.dao.BookRepo;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

import static io.quarkus.hibernate.orm.panache.Panache.getEntityManager;

@ApplicationScoped
public class BookServices {
    @Inject
    private BookRepo bookRepo;

    public List<Book> getAllBooks() {
        List<Book> b = bookRepo.findAll().list();
        return b;
    }


    public Book getBookById(Long id) {
        Book obj = new Book();
        try {

            obj = this.bookRepo.findById(id);
            long check = obj.getId();
            return obj;
        } catch (Exception e){
            System.out.println("No book found ");
            e.printStackTrace();
            return null;
        }
    }

    public Book addBook(Book book)
    {
        getEntityManager().persist(book);

        return book;
    }
//    public boolean check(Book book)
//    {
//        return bookRepo.isPersistent(book);
//    }
    public void deleteBook(Long id){

          bookRepo.deleteById(id);
    }

    public Book updateBook(Book com4, Long id)
    {
        Book book = bookRepo.findById(id);

        book.setNoOfBooks(com4.getNoOfBooks());
        book.setAuthor(com4.getAuthor());
        book.setName(com4.getName());
        book.setNoOfPages(com4.getNoOfPages());
 //      com4.setId(id);  // agr given id alg hai to yeh usse set kar dega
        bookRepo.persist(book);

        return book;
    }






}
