package org.acme.Entity;

import io.quarkus.panache.common.Parameters;
import jdk.jshell.Snippet;

import javax.persistence.*;
import javax.transaction.Status;
import java.sql.Date;

import static io.quarkus.hibernate.orm.panache.PanacheEntityBase.count;


//@NamedQueries({
//        @NamedQuery( name = "Trancation.GetTransactionByBookId" ,
//                query = "select t FROM transcation t WHERE t.book_id = :book_id")
//})
@Entity
public class Transcation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Date issuedDate;
    private Date returnDate;

    @ManyToOne
    private Book book;

    public Transcation(long id,  Date issuedDate, Date returnDate) {
        this.id = id;
        this.issuedDate = issuedDate;
        this.returnDate = returnDate;
    }

    public Transcation() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public long getId(Long id) {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

//    public static long GetTransactionByBookId(long book_id) {
//        return count("#Transcation.GetTransactionByBookId",
//                Parameters.with("book_id",book_id).map());
//    }
}
