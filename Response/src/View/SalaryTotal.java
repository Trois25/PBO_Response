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
public class SalaryTotal extends JFrame{
    private JLabel labelName, labelAge, labelSalary, labelTotalSalary, isName, isAge, isSalary, isTotalSalary;
    private JButton btnBack;
    private String id;
    
    public SalaryTotal(String data, String time){
        Connector conn = new Connector();
        String Employee[] = conn.TotalSalaryResult(data, time);
        
        setTitle(Employee[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,325);
        labelName = new JLabel(" Name : ");
        labelAge = new JLabel(" Age : ");
        labelSalary = new JLabel(" Salary : ");
        labelTotalSalary = new JLabel(" Total Salary : ");
        
        isName = new JLabel(Employee[1]);
        isAge = new JLabel(Employee[2]);
        isSalary = new JLabel(Employee[3]);
        isTotalSalary = new JLabel(Employee[4]);
        btnBack = new JButton("Back");
        
        setLayout(null);
        add(labelName);
        add(labelAge);
        add(labelSalary);
        add(labelTotalSalary);
        add(isName);
        add(isAge);
        add(isSalary);
        add(isTotalSalary);
        add(btnBack);

        labelName.setBounds(10,10,120,20);
        isName.setBounds(130,10,190,20);
        labelAge.setBounds(10,35,120,20);
        isAge.setBounds(130,35,190,20);
        labelSalary.setBounds(10,60,120,20);
        isSalary.setBounds(130,60,190,20);
        labelTotalSalary.setBounds(10,85,120,20);
        isTotalSalary.setBounds(130,85,190,20);
        btnBack.setBounds(10,260,90,20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                EmployeePage page = new EmployeePage();
            }
        });
    }

}
