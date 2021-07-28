package com.example.workWithBigDB.services;

import com.example.workWithBigDB.database.Entities.Airport;

import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;


@Stateless
public class AirportService{

    @PersistenceContext(unitName = "BigDBService")
    EntityManager entityManager;


    public List<Airport> get(int minIndex) {
        CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
        CriteriaQuery<Airport> criteriaQuery=criteriaBuilder.createQuery(Airport.class);
        Root<Airport> airportRoot=criteriaQuery.from(Airport.class);
        criteriaQuery.select(airportRoot);
        TypedQuery<Airport> airportTypedQuery=entityManager.createQuery(criteriaQuery);
        return airportTypedQuery.getResultList();
    }


    public void add(Airport entity) {
        entityManager.persist(entity);
    }


    public void remove(String id) {
        Airport airport=entityManager.find(Airport.class,id);
        if(airport!=null)
            entityManager.remove(airport);
    }

    public Airport find(String id) {
        return entityManager.find(Airport.class,id);
    }


    public void update(Airport entity) {
        entityManager.refresh(entity);
    }
}
