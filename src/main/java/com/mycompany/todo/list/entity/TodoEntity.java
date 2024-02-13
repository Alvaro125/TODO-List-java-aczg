
package com.mycompany.todo.list.entity;

import java.util.ArrayList;
import java.util.Date;

public class TodoEntity {
    public enum Status{
        todo, doing, done
    }
    private int id;
    private String name;
    private Date end_date;
    private String description;
    private int priority;
    private String category;
    private Status status;

    public TodoEntity(int id, String name, Date end_date, String description, int priority, String category, Status status) {
        this.id = id;
        this.name = name;
        this.end_date = end_date;
        this.description = description;
        this.priority = priority;
        this.category = category;
        this.status = status;
    }

    public static int getNextId(ArrayList<TodoEntity> todoList) {
        int maxId = 0;
        for (TodoEntity todo : todoList) {
            if (todo.getId() > maxId) {
                maxId = todo.getId();
            }
        }
        return maxId + 1;
    }

    public int getId() {
        return id;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
    
    
}
