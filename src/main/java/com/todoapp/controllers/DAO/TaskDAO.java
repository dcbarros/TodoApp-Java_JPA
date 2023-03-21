package com.todoapp.controllers.DAO;

import java.util.List;

import com.todoapp.models.Task;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;


public class TaskDAO extends DAO<Task>{
    
    public TaskDAO(){
        super(Task.class);
    }

    public Task findTaskById(int taskId){
        EntityManager em = getEm();
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t WHERE t.id = :id", Task.class);
        query.setParameter("id", taskId);
        return query.getSingleResult();
    }
    
    public List<Task> findAllProjectTasks(int projectId){
        EntityManager em = getEm();
        TypedQuery<Task> query = em.createQuery("SELECT t FROM Task t WHERE t.project.id = :id", Task.class);
        query.setParameter("id", projectId);
        return query.getResultList();
    }
}
