package com.todoapp.controllers;

import com.todoapp.controllers.DAO.ProjectDAO;
import com.todoapp.models.Project;

public class ProjectController {
    
    private ProjectDAO dao = new ProjectDAO();

    public void saveProject(Project project){
        dao.openTransectionDao().insertTransectionDao(project).closeTransectionDao().close();
    }

    public void updateProjectById(Project project,int id){
        dao.openTransectionDao().insertTransectionDao(project).updateTransectionDao(getProjectbyId(id)).closeTransectionDao().close();
    }

    public void removeById(int id){
        dao.openTransectionDao().removeDao(id).closeTransectionDao().close();
    }

    public Project getProjectbyId(int id){
        return dao.findProjectById(id);
    }
}
