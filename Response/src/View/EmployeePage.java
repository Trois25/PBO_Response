/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author OWNER
 */
public class EmployeePage extends JFrame{
    private JLabel labelMenu;
    private JButton btnCreate, btnRead;
    
    public EmployeePage(){
        setTitle("Menu");
        labelMenu = new JLabel("Main Menu");
        labelMenu.setHorizontalAlignment(SwingConstants.CENTER);
        btnCreate = new JButton(" Add Employee");
        btnRead = new JButton(" View Employees ");
        setLayout(new GridLayout(4,1));
        add(labelMenu);
        add(btnCreate);
        add(btnRead);
        pack();
        setResizable(false);
        setLocation(500,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
      
        setVisible(true);
        
        btnRead.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                ViewEmployee view = new ViewEmployee();
            }
        });
        
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                AddEmploye add = new AddEmploye();
            }
        });
    }
}
