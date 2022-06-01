/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Connector;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author OWNER
 */
public class AddEmploye extends JFrame{
    private JTextField fieldName, fieldAge, fieldSalary;
    private JLabel labelTitle, labelName, labelAge, labelSalary;

    private JButton btnSubmit, btnReset, btnBack;
    
    public AddEmploye(){
        Connector conn = new Connector();
        
        setTitle("Input Employee");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,225);

        fieldName = new JTextField();
        fieldAge = new JTextField();
        fieldSalary = new JTextField();
        labelTitle = new JLabel(" Input Employee ");
        labelName = new JLabel(" Name ");
        labelAge = new JLabel(" Age ");
        labelSalary = new JLabel(" Salary ");
        btnSubmit = new JButton("Submit");
        btnReset = new JButton("Reset");
        btnBack = new JButton("Back");

        setLayout(null);
        add(labelTitle);
        add(fieldName);
        add(labelName);
        add(labelAge);
        add(fieldAge);
        add(labelSalary);
        add(fieldSalary);
        add(btnSubmit);
        add(btnReset);
        add(btnBack);

        labelTitle.setBounds(10,10,120,20);
        labelName.setBounds(10,35,120,20);
        fieldName.setBounds(130,35,190,20);
        labelAge.setBounds(10,60,120,20);
        fieldAge.setBounds(130,60,190,20);
        labelSalary.setBounds(10,85,120,20);
        fieldSalary.setBounds(130,85,190,20);
        
        btnSubmit.setBounds(75,125,120,20);
        btnSubmit.setBackground(Color.blue);
        btnSubmit.setForeground(Color.white);
        btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnReset.setBounds(200,125,120,20);
        btnReset.setBackground(Color.red);
        btnReset.setForeground(Color.white);
        btnReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.setBounds(10,155,320,20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
   

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
        
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                conn.addEmployee(getFieldName(), getFieldAge(), getFieldSalary());
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fieldName.setText("");
                fieldAge.setText("");
                fieldSalary.setText("");
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                EmployeePage view = new EmployeePage();
            }
        });
    }

    public String getFieldName() {
        return fieldName.getText();
    }

    public String getFieldAge() {
        return fieldAge.getText();
    }

    public String getFieldSalary() {
        return fieldSalary.getText();
    }
    
    
}
