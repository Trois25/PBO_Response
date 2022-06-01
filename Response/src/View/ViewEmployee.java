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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/**
 *
 * @author OWNER
 */
public class ViewEmployee extends JFrame{
    private JTable table;
    private JButton btnBack;
    private String id;
    
    public ViewEmployee(){
        Connector conn = new Connector();
        int total = conn.data();
        
        String data[][] = new String[total][4];
        final String[] TableTitle = {"Id", "Name", "Age", "Salary"};
        setTitle("Data Karyawan");
        setSize(900,375);
        btnBack = new JButton(" Back ");
            table = new JTable(data,TableTitle);
            table.setBounds(30,40,400,600);
            JScrollPane sp=new JScrollPane(table);
            sp.setPreferredSize(new Dimension(500,80));
            this.getContentPane().add(BorderLayout.CENTER, sp);

            this.getContentPane().add(BorderLayout.SOUTH, btnBack);
            btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            table.setCursor((Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)));
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocation(200,150);
            setVisible(true);
            
            data = conn.getEmployee();
            table.setModel((new JTable(data, TableTitle)).getModel());
            
            btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                dispose();
                EmployeePage view = new EmployeePage();
            }
            });
            
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e){
                    super.mouseClicked(e);
                    int row = table.getSelectedRow();
                    int col = table.getSelectedColumn();
                    
                    String id = table.getValueAt(row, 0).toString();
                    System.out.println("Employee with Id : " + id);
                    
                    int input = JOptionPane.showConfirmDialog(null, 
                        "do you want to see employee with id : " + id + " ?", 
                        "Option...", 
                        JOptionPane.YES_NO_OPTION);
                
                    if (input == 0){
                        dispose();
                        SpecificEmployee see = new SpecificEmployee(id);
                    }    
                }
            });
    }
}
