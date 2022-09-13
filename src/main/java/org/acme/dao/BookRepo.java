package org.acme.dao;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import org.acme.Entity.Book;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookRepo implements PanacheRepository<Book> {


}
