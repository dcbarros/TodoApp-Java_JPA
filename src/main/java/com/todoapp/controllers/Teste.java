package com.todoapp.controllers;

//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;

//import com.todoapp.models.Project;
//import com.todoapp.models.Project;
//import com.todoapp.models.Status;
import com.todoapp.models.Task;



public class Teste {
    public static void main(String[] args) {

        ProjectController projectController = new ProjectController();
        TaskController taskController = new TaskController();
        //List<Task> tasks = taskController.getAllTasks(7);
        //for (Task task : tasks) {
        //    System.out.println(task.getName());
        //}
        Task t = taskController.getTaskById(7);
        t.setName("Task 2");
        taskController.updateTaskById(t, 7);
        System.out.println(projectController.getProjectbyId(7).getName());
    }

}
