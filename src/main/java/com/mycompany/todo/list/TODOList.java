/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.todo.list;

import com.mycompany.todo.list.controller.TodoController;
import java.io.FileNotFoundException;
import org.json.simple.parser.ParseException;

public class TODOList {

    public static void main(String[] args) throws ParseException, FileNotFoundException {
        TodoController app = new TodoController();
        System.out.println("Hello World!");
        
    }
}
