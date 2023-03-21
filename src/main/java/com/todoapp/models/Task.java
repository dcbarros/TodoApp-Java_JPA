package com.todoapp.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private Status status;
    private String notes;
    @Column(nullable = false)
    private Date deadline;
    @Column(nullable = false)
    private Date createdAt;
    @Column(nullable = false)
    private Date updateAt;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
    
    public Task() {
    }

    public Task(String name, String description, Status status, String notes, Date deadline, Project project) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.notes = notes;
        this.deadline = deadline;
        this.setProject(project);
        this.createdAt = new Date();
        this.updateAt = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Tasks [id=" + id + ", name=" + name + ", description=" + description + ", status=" + status + ", notes="
                + notes + ", deadline=" + deadline + ", createdAt=" + createdAt + ", updateAt=" + updateAt
                + ", project=" + project + "]";
    }
    
}
