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
public class SpecificEmployee extends JFrame{
    private JLabel labelName, labelAge, labelSalary, labelOvertime, isName, isAge, isSalary;
    private JButton btnUpdate, btnDelete, btnBack, btnShow;
    private JTextField fieldOvertime;
    private String id;
    
    public SpecificEmployee(String data){
        Connector conn = new Connector();
        String Employee[] = conn.getSpecificEmployee(data);
        
        setTitle(Employee[1]);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(350,325);
        labelName = new JLabel(" Name : ");
        labelAge = new JLabel(" Age : ");
        labelSalary = new JLabel(" Salary : ");
        fieldOvertime = new JTextField();
        labelOvertime = new JLabel(" Overtime (Hours) ");

        isName = new JLabel(Employee[1]);
        isAge = new JLabel(Employee[2]);
        isSalary = new JLabel(Employee[3]);
        btnUpdate = new JButton("Edit");
        btnDelete = new JButton("Delete");
        btnBack = new JButton("Back");
        btnShow = new JButton("Total Salary");

        setLayout(null);
        add(labelName);
        add(labelAge);
        add(labelSalary);
        add(labelOvertime);
        add(isName);
        add(isAge);
        add(isSalary);
        add(fieldOvertime);
        add(btnUpdate);
        add(btnDelete);
        add(btnBack);
        add(btnShow);

        labelName.setBounds(10,10,120,20);
        isName.setBounds(130,10,190,20);
        labelAge.setBounds(10,35,120,20);
        isAge.setBounds(130,35,190,20);
        labelSalary.setBounds(10,60,120,20);
        isSalary.setBounds(130,60,190,20);
        labelOvertime.setBounds(10,85,120,20);
        fieldOvertime.setBounds(130,85,190,20);
        btnShow.setBounds(130,185,90,20);
        btnShow.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnBack.setBounds(10,260,90,20);
        btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.setBounds(110,260,90,20);
        btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnUpdate.setBackground(Color.blue);
        btnUpdate.setForeground(Color.white);
        btnDelete.setBounds(210,260,90,20);
        btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnDelete.setBackground(Color.red);
        btnDelete.setForeground(Color.white);

        setResizable(false);
        setLocation(450,200);
        setVisible(true);
        
        btnShow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {         
                dispose();
                SalaryTotal view = new SalaryTotal(data,getTime());
            }
        });
        
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                EmployeePage view = new EmployeePage();
            }
        });
        
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                conn.updateEmployee(data, Employee[1], Employee[2], Employee[3]);
            }
        });
        
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                conn.deleteEmployee(data);
            }
        });
    }

    public String getTime() {
        return fieldOvertime.getText();
    }
    
    

}
