package com.example.workWithBigDB.services;

import com.example.workWithBigDB.database.Entities.Ticket;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Stateless
public class TicketService {
    @PersistenceContext(unitName = "BigDBService")
    EntityManager entityManager;

    public List<Ticket> get(int minIndex){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Ticket> criteriaQuery= criteriaBuilder.createQuery(Ticket.class);
        Root<Ticket> root=criteriaQuery.from(Ticket.class);
        TypedQuery<Ticket> query=entityManager.createQuery(criteriaQuery);
        query.setFirstResult(minIndex);
        query.setMaxResults(minIndex+50);
        return query.getResultList();
    }
}
