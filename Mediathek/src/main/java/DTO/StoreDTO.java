package DTO;

import Entity.Store;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class StoreDTO {
    @PersistenceContext
    EntityManager entityManager;

    String path = "../resources/Bill.csv";
    public void readFromCSV(){

    }

    public Store getById(int id){
        //return (Store)entityManager.createQuery("SELECT store from Store store where storeId = :Id").setParameter("Id", id).getSingleResult();
        return null;
    }
}
