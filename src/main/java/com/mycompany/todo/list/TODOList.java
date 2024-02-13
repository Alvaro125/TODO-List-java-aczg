package com.mycompany.todo.list;

import com.mycompany.todo.list.controller.TodoController;
import java.io.FileNotFoundException;
import java.text.ParseException;

public class TODOList {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        TodoController app = new TodoController();
    }
}
