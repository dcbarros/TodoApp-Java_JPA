package com.todoapp.controllers.DAO;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.todoapp.models.Project;

public class ProjectDAO extends DAO<Project>{
    public ProjectDAO(){
        super(Project.class);
    }

    public Project findProjectById(int projectId){
        EntityManager em = getEm();
        TypedQuery<Project> query = em.createQuery("SELECT p FROM Project p WHERE p.id = :id", Project.class);
        query.setParameter("id", projectId);
        return query.getSingleResult();
    }
}
