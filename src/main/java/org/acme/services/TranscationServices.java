package org.acme.services;


import io.quarkus.hibernate.orm.panache.PanacheQuery;
import org.acme.Entity.Book;
import org.acme.Entity.Transcation;
import org.acme.dao.BookRepo;
import org.acme.dao.TranscationRepo;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.sql.Date;


@ApplicationScoped
public class TranscationServices {
    @Inject
    TranscationRepo transcationRepo;
    @Inject
    BookRepo bookRepo;




    public Book issueBook(Long bookId)
    {
        Transcation newTransaction=createTransaction(bookId);


        if(newTransaction.getBook() == null)
            return null;
        transcationRepo.persist(newTransaction);
        Book book=bookRepo.findById(bookId);

        return book;
    }
    public void returnBook(Long transactionId)
    {
        Transcation transcation=transcationRepo.findById(transactionId);
        transcation.setReturnDate(new Date(System.currentTimeMillis()));
        transcationRepo.persist(transcation);

    }


    public Transcation createTransaction(Long bookId)
    {
       Book book= bookRepo.findById(bookId);
        Transcation transcation=new Transcation();
        Date date = new Date(System.currentTimeMillis());
        transcation.setIssuedDate(date);
        try {
             if (book.getId() == bookId) {

                long transSize = transcationRepo.list("book_id",bookId).size();
                int count = book.getNoOfBooks();
               if(count <= transSize)
                {
                    throw new Exception();
                }
                transcation.setBook(book);

                //transcationRepo.persist(transcation);
            }
        }catch (Exception e)
        {
            e.printStackTrace();

        }

        return transcation;
    }


}
