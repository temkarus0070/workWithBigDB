package com.example.workWithBigDB.services;

import com.example.workWithBigDB.database.Entities.BoardingPass;
import com.example.workWithBigDB.database.Entities.IdEmbedable.TicketAndFlight;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class BoardingPassService {
    @PersistenceContext(unitName = "BigDBService")
    EntityManager entityManager;

    public void add(BoardingPass entity){
        entityManager.persist(entity);
    }

    public List<BoardingPass> get(){
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<BoardingPass> criteriaQuery=criteriaBuilder.createQuery(BoardingPass.class);
        Root<BoardingPass> boardingPassRoot=criteriaQuery.from(BoardingPass.class);
        TypedQuery<BoardingPass> query=entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }

    public void delete(TicketAndFlight id){
        BoardingPass boardingPass= entityManager.find(BoardingPass.class,id);
        if(boardingPass!=null)
            entityManager.remove(boardingPass);
    }

    public void update(BoardingPass boardingPass){
        entityManager.refresh(boardingPass);
    }

    public BoardingPass get(TicketAndFlight id){
        return entityManager.find(BoardingPass.class,id);
    }
}
