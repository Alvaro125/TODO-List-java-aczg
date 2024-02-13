package com.mycompany.todo.list.frames;

import com.mycompany.todo.list.controller.TodoController;
import com.mycompany.todo.list.entity.TodoEntity;
import com.mycompany.todo.list.entity.TodoEntity.Status;
import com.mycompany.todo.list.entity.TodoEntityTableModel;
import java.awt.List;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.json.simple.parser.ParseException;

public class TodoFrame extends javax.swing.JFrame {

    private TodoController controller;
    private TodoEntityTableModel model;
    private ArrayList<TodoEntity> list;
    private String[] categories;
    private boolean isEditable;

    public TodoFrame(TodoController controller) throws ParseException, FileNotFoundException {
        this.controller = controller;
        list = controller.read();
        categories = controller.readCategory();
        model = new TodoEntityTableModel(list);
        initComponents();
        cleanPanelFilter();
        cleanPanel();
        isEditable = false;
        cancelButton.setVisible(false);
    }

    private TodoEntity getTodo() {
        String name = nameTextField.getText();
        if (name.equals("")) {
            infoError("Nome não Preenchido.");
            return null;
        }
        Date end_date = end_dateDateChooser1.getDate();
        if (end_date == null) {
            infoError("Data de término não Preenchida.");
            return null;
        }
        String description = descriptionTextArea.getText();
        if (description.equals("")) {
            infoError("Descrição não Preenchida.");
            return null;
        }
        int priority = prioritySlider.getValue();
        String category = (String) categoryComboBox.getSelectedItem();
        if (category.equals("")) {
            infoError("Categoria não Preenchida.");
            return null;
        }
        Status status = (Status) statusComboBox.getSelectedItem();
        if (status == null) {
            infoError("Status não Preenchido.");
            return null;
        }
        return new TodoEntity(0, name, end_date, description, priority, category, status);
    }

    private void cleanPanel() {
        nameTextField.setText("");
        end_dateDateChooser1.setDate(null);
        descriptionTextArea.setText("");
        prioritySlider.setValue(1);
        categoryComboBox.setSelectedItem("");
        statusComboBox.setSelectedIndex(-1);
    }
    private void cleanPanelFilter() {
        filterCategoryComboBox.setSelectedIndex(-1);
        filterStatusComboBox.setSelectedIndex(-1);
        filterPrioritySlider.setValue(0);
    }

    private TodoFrame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nameTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        end_dateDateChooser1 = new com.toedter.calendar.JDateChooser();
        prioritySlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        todosTable = new javax.swing.JTable();
        createButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        cleanButton = new javax.swing.JButton();
        categoryComboBox = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        filterPrioritySlider = new javax.swing.JSlider();
        jLabel8 = new javax.swing.JLabel();
        filterCategoryComboBox = new javax.swing.JComboBox<>();
        filterStatusComboBox = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        filterButton = new javax.swing.JButton();
        filterCleanButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ToDo List");

        nameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTextFieldActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome");

        jLabel2.setText("Descrição");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        jScrollPane1.setViewportView(descriptionTextArea);

        jLabel3.setText("data de Término");

        prioritySlider.setMaximum(5);
        prioritySlider.setMinimum(1);

        jLabel4.setText("Prioridade");

        jLabel5.setText("Status");

        statusComboBox.setModel(new DefaultComboBoxModel(Status.values()));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        todosTable.setModel(model);
        jScrollPane2.setViewportView(todosTable);

        createButton.setText("Criar");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createTodo(evt);
            }
        });

        jLabel6.setText("Categoria");

        deleteButton.setText("Deletar");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButton(evt);
            }
        });

        updateButton.setText("Editar");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancelar");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        readButton.setText("Visualizar");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        cleanButton.setText("Limpar");
        cleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanButtonActionPerformed(evt);
            }
        });

        categoryComboBox.setEditable(true);
        categoryComboBox.setModel(new DefaultComboBoxModel(categories));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Filtro"), "Filtro"));

        jLabel9.setText("Prioridade");

        filterPrioritySlider.setMaximum(5);
        filterPrioritySlider.setValue(0);

        jLabel8.setText("Categoria");

        filterCategoryComboBox.setModel(new DefaultComboBoxModel(categories));

        filterStatusComboBox.setModel(new DefaultComboBoxModel(Status.values()));
        filterStatusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterStatusComboBoxActionPerformed(evt);
            }
        });

        jLabel7.setText("Status");

        filterButton.setText("Filtrar");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        filterCleanButton.setText("Limpar");
        filterCleanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterCleanButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterPrioritySlider, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                    .addComponent(filterCategoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filterStatusComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(filterButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(filterCleanButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterPrioritySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterCategoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterStatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterButton)
                    .addComponent(filterCleanButton))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(nameTextField, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cleanButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(prioritySlider, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(end_dateDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(createButton)
                                .addGap(18, 18, 18)
                                .addComponent(cancelButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(statusComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(categoryComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(108, 108, 108)))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(readButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(updateButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(deleteButton))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deleteButton)
                            .addComponent(updateButton)
                            .addComponent(readButton)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(end_dateDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(11, 11, 11)
                        .addComponent(prioritySlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(createButton)
                            .addComponent(cancelButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cleanButton)))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTextFieldActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void createTodo(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createTodo
        try {
            TodoEntity todo = getTodo();
            if (isEditable) {
                todo.setId(list.get(todosTable.getSelectedRow()).getId());
                this.controller.update(todo);
            } else {
                if (todo != null) {
                    todo.setId(TodoEntity.getNextId(list));
                    this.controller.create(todo);
                }
            }
            list = this.controller.read();
            model = new TodoEntityTableModel(list);
            categories = this.controller.readCategory();
            filterCategoryComboBox.setModel(new DefaultComboBoxModel(categories));
            categoryComboBox.setModel(new DefaultComboBoxModel(categories));
            todosTable.setModel(model);
            if (isEditable) {
                cleanPanel();
                isEditable = false;
                createButton.setText("Criar");
                cancelButton.setVisible(false);
            }
        } catch (ParseException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_createTodo

    private void deleteButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButton
        try {
            this.controller.delete(list.get(todosTable.getSelectedRow()).getId());
            list = this.controller.read();
            model = new TodoEntityTableModel(list);
            todosTable.setModel(model);
        } catch (ParseException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deleteButton

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        TodoEntity todo = list.get(todosTable.getSelectedRow());
        nameTextField.setText(todo.getName());
        end_dateDateChooser1.setDate(todo.getEnd_date());
        descriptionTextArea.setText(todo.getDescription());
        prioritySlider.setValue(todo.getPriority());
        categoryComboBox.setSelectedItem(todo.getCategory());
        statusComboBox.setSelectedItem(todo.getStatus());
        createButton.setText("Atualizar");
        cancelButton.setVisible(true);
        isEditable = true;
    }//GEN-LAST:event_updateButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        cleanPanel();
        isEditable = false;
        cancelButton.setVisible(isEditable);
        createButton.setText("Criar");
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        TodoEntity todo = list.get(todosTable.getSelectedRow());
        nameTextField.setText(todo.getName());
        end_dateDateChooser1.setDate(todo.getEnd_date());
        descriptionTextArea.setText(todo.getDescription());
        prioritySlider.setValue(todo.getPriority());
        categoryComboBox.setSelectedItem(todo.getCategory());
        statusComboBox.setSelectedItem(todo.getStatus());
    }//GEN-LAST:event_readButtonActionPerformed

    private void cleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanButtonActionPerformed
        cleanPanel();
    }//GEN-LAST:event_cleanButtonActionPerformed

    private void filterStatusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterStatusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterStatusComboBoxActionPerformed

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        try {
            list = this.controller.readFilter(
                    (String) filterCategoryComboBox.getSelectedItem(), 
                    filterPrioritySlider.getValue(),
                    (Status)filterStatusComboBox.getSelectedItem());
            model = new TodoEntityTableModel(list);
            todosTable.setModel(model);
        } catch (ParseException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filterButtonActionPerformed

    private void filterCleanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterCleanButtonActionPerformed
        cleanPanelFilter();
        try {
            list = this.controller.read();
            model = new TodoEntityTableModel(list);
            todosTable.setModel(model);
        } catch (ParseException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(TodoFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_filterCleanButtonActionPerformed

    private void infoError(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TodoFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TodoFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JButton cleanButton;
    private javax.swing.JButton createButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JTextArea descriptionTextArea;
    private com.toedter.calendar.JDateChooser end_dateDateChooser1;
    private javax.swing.JButton filterButton;
    private javax.swing.JComboBox<String> filterCategoryComboBox;
    private javax.swing.JButton filterCleanButton;
    private javax.swing.JSlider filterPrioritySlider;
    private javax.swing.JComboBox<String> filterStatusComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JSlider prioritySlider;
    private javax.swing.JButton readButton;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JTable todosTable;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
