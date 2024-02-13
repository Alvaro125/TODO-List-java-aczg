package com.mycompany.todo.list.entity;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TodoEntityTableModel extends AbstractTableModel {
    private List<TodoEntity> data;
    private String[] columnNames = {"Name", "Prazo", "Descrição", "Prioridade", "Categoria", "Status"};

    public TodoEntityTableModel(ArrayList<TodoEntity> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TodoEntity todo = data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return todo.getName();
            case 1:
                return todo.getEnd_date();
            case 2:
                return todo.getDescription();
            case 3:
                return todo.getPriority();
            case 4:
                return todo.getCategory();
            case 5:
                return todo.getStatus();
            default:
                return null;
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        TodoEntity todo = data.get(rowIndex);
        switch (columnIndex) {
            case 1:
                todo.setEnd_date((Date) value);
                break;
            case 2:
                todo.setDescription((String) value);
                break;
            case 3:
                todo.setPriority((int) value);
                break;
            case 4:
                todo.setCategory((String) value);
                break;
            case 5:
                todo.setStatus((TodoEntity.Status) value);
                break;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}

