package com.example.workWithBigDB.services;

import com.example.workWithBigDB.database.Entities.Aircraft;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class AircraftService {

    @PersistenceContext(unitName = "BigDBService")
    EntityManager entityManager;


    public List<Aircraft> get(int minIndex) {
        CriteriaBuilder criteriaBuilder= entityManager.getCriteriaBuilder();
        CriteriaQuery<Aircraft> criteriaQuery=criteriaBuilder.createQuery(Aircraft.class);
        Root<Aircraft> aircraftRoot=criteriaQuery.from(Aircraft.class);
        TypedQuery<Aircraft> typedQuery=entityManager.createQuery(criteriaQuery);
        typedQuery.setFirstResult(minIndex);
        typedQuery.setMaxResults(minIndex+50);
        return typedQuery.getResultList();
    }


    public void add(Aircraft entity) {
        entityManager.persist(entity);
    }


    public void remove(String id) {
        Aircraft aircraft=entityManager.find(Aircraft.class,id);
        if(aircraft!=null){
            entityManager.remove(aircraft);
        }
    }


    public Aircraft find(String id) {
        return entityManager.find(Aircraft.class,id);
    }


    public void update(Aircraft entity) {
        entityManager.refresh(entity);
    }
}
