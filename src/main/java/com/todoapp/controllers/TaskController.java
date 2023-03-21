package com.todoapp.controllers;

import java.util.List;

import com.todoapp.controllers.DAO.TaskDAO;
import com.todoapp.models.Task;

public class TaskController {

    private TaskDAO dao = new TaskDAO();

    public void saveTasks(Task task){
        dao.insertManyTransectionsDAO(task);
    }

    public void updateTaskById(Task task, int taskId){
        dao.openTransectionDao().insertTransectionDao(task).updateTransectionDao(dao.findTaskById(taskId)).closeTransectionDao().close();
    }

    public void removeById(int taskId){
        
    }

    public List<Task> getAllTasks(int idProject){
        return dao.findAllProjectTasks(idProject);
    }

    public Task getTaskById(int idTask){
        return dao.findTaskById(idTask);
    }

}
