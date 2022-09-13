package org.acme.dao;

import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import org.acme.Entity.Transcation;
import org.jboss.resteasy.annotations.Query;


import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class TranscationRepo implements PanacheRepository <Transcation> {
//    public List<Transcation> GetTransactionByBookId(long bookId)
//    {
//        return getEntityManager().createQuery("SELECT t FROM transcation t WHERE t.book_id = " + bookId,
//                Transcation.class).getResultList();
//    }
}

