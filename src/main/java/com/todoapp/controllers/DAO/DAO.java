package com.todoapp.controllers.DAO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classEntity;

    static{
        try{
            emf = Persistence.createEntityManagerFactory("ToDoApp");
        }catch(Exception e){
            // ...
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classEntity) {
        this.classEntity = classEntity;
        em = emf.createEntityManager();
    }
    
    
    public EntityManager getEm() {
        return em;
    }

    public Class<E> getClassEntity() {
        return classEntity;
    }

    public DAO<E> openTransectionDao(){
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransectionDao(){
        em.getTransaction().commit();
        return this;
    }
        
    public void close(){
        em.close();
    }
        
    public DAO<E> insertTransectionDao(E entity){
        em.persist(entity);
        return this;
    }

    public DAO<E> insertManyTransectionsDAO(E entity){
        return this.openTransectionDao().insertTransectionDao(entity).closeTransectionDao();
    }
    
    public DAO<E> updateTransectionDao(E entity){
        if(entity != null){
            em.merge(entity);
        }
        return this;
    }

    public DAO<E> removeDao(int id){
        if(findEntitybyId(id) != null){
            em.remove(findEntitybyId(id));
        }
        return this;
    }

    public E findEntitybyId(int id){
        return em.find(classEntity, id);
    }
    
}
