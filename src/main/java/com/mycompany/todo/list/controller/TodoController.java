/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.todo.list.controller;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.mycompany.todo.list.entity.TodoEntity;
import com.mycompany.todo.list.frames.TodoFrame;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

public class TodoController {

    public TodoController() throws ParseException, FileNotFoundException {
        new TodoFrame(this).setVisible(true);
    }

    public ArrayList<TodoEntity> read() throws ParseException, FileNotFoundException {
        ArrayList<TodoEntity> list = new ArrayList();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/main/java/com/mycompany/todo/list/data/todos.json"));
            TodoEntity[] data = gson.fromJson(reader, TodoEntity[].class);
            list = new ArrayList<TodoEntity>(Arrays.asList(data));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public String[] readCategory() throws ParseException, FileNotFoundException {
        ArrayList<TodoEntity> list = new ArrayList();
        ArrayList<String> categories = new ArrayList();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/main/java/com/mycompany/todo/list/data/todos.json"));
            TodoEntity[] data = gson.fromJson(reader, TodoEntity[].class);
            list = new ArrayList<TodoEntity>(Arrays.asList(data));
            for (TodoEntity todo : data) {
                if (!categories.contains(todo.getCategory())) {
                    categories.add(todo.getCategory());
                }
            }
            System.out.println(categories);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories.toArray(new String[categories.size()]);
    }

    public ArrayList<TodoEntity> readFilter(String category, int priority, TodoEntity.Status status) throws ParseException, FileNotFoundException {
        ArrayList<TodoEntity> list = new ArrayList();
        try {
            Gson gson = new Gson();
            JsonReader reader = new JsonReader(new FileReader("./src/main/java/com/mycompany/todo/list/data/todos.json"));
            TodoEntity[] data = gson.fromJson(reader, TodoEntity[].class);
            list = new ArrayList<TodoEntity>(Arrays.asList(data));
            if (category!=null) {
                list.removeIf(td -> !td.getCategory().equals(category));
            }
            if (priority!=0) {
                list.removeIf(td -> td.getPriority()!=priority);
            }
            if (status!=null) {
                list.removeIf(td -> td.getStatus()!=status);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void create(TodoEntity todo) throws ParseException, FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<TodoEntity> list = this.read();
        list.add(todo);
        String todo_str = gson.toJson(list);
        try {
            FileWriter file = new FileWriter("./src/main/java/com/mycompany/todo/list/data/todos.json");
            file.write(todo_str);
            file.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void delete(int id) throws ParseException, FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<TodoEntity> list = this.read();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.remove(index);
            String todo_str = gson.toJson(list);
            try {
                FileWriter file = new FileWriter("./src/main/java/com/mycompany/todo/list/data/todos.json");
                file.write(todo_str);
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void update(TodoEntity todo) throws ParseException, FileNotFoundException {
        Gson gson = new Gson();
        ArrayList<TodoEntity> list = this.read();
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == todo.getId()) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            list.set(index, todo);
            String todo_str = gson.toJson(list);
            try {
                FileWriter file = new FileWriter("./src/main/java/com/mycompany/todo/list/data/todos.json");
                file.write(todo_str);
                file.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}
