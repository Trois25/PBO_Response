/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author OWNER
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/employee";
    String DBusername = "root";
    String DBpassword = "";
    
    Connection conn;
    Statement stmt;
    
    String[] data = new String[4];
    
    public Connector(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection)DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Connection Success");
        }catch(Exception ex){
            System.out.println("Connection Failed " + ex);
        }
    }
    
    public int data(){
        int totalData = 0;
        try {
            String query = "SELECT * FROM employee";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            }
            stmt.close();
            return totalData;
        } catch (Exception e) {
            return 0;
        }
    }
    
    public String[][] getEmployee(){
        int totalemployee = data();
        String data[][] = new String [totalemployee][4];
        try {
            int totalData = 0;
            String query = "SELECT * FROM `employee`";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);

                while(resultSet.next()){
                    data[totalData][0] = resultSet.getString("id");
                    data[totalData][1] = resultSet.getString("name");
                    data[totalData][2] = resultSet.getString("age");
                    data[totalData][3] = resultSet.getString("salary");
                    totalData++;
                }
                stmt.close();
        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.getMessage());
        } finally{
            return data;
        }
    }
    
    public void addEmployee(String name, String age, String salary){
        try {
            String querry = "INSERT INTO `employee` (`name`, `age`, `salary`)"
            + " VALUES ('" + name + "','" + age + "','" + salary + "')";

            stmt = conn.createStatement();
            stmt.executeUpdate(querry);

            JOptionPane.showMessageDialog(null, "Employee Added");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Age or Salary must be number");
        }
    }
    
    public String[] getSpecificEmployee(String id){
        String data[] = new String[4];
        try {
            String querry = "SELECT * FROM employee WHERE id='" + id + "'";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(querry);
            
            resultSet.next();
            data[0] = resultSet.getString("id");
            data[1] = resultSet.getString("name");
            data[2] = resultSet.getString("age");
            data[3] = resultSet.getString("salary");
            
        } catch (Exception e) {
        }finally{
            return data;
        }
    }
    
    public String TotalSalary(String id, String time){
        int hours = Integer.parseInt(time);
        String totalsalary = null;
        String data[] = new String[1];
        try {
            String querry = "SELECT salary FROM employee WHERE id='" + id + "'";
            stmt = conn.createStatement();
            stmt.executeUpdate(querry);
            ResultSet resultSet = stmt.executeQuery(querry);
            
            resultSet.next();
            data[0] = resultSet.getString("salary");
            
            int fsalary = Integer.parseInt(data[0]);
            System.out.println(fsalary);
            
            int salary = fsalary + (hours * 25000);
            totalsalary = String.valueOf(salary);
        } catch (Exception e) {
            
        }finally{
            return totalsalary;
        }
    }
    
    public String[] TotalSalaryResult(String id, String time){
        String data[] = new String[5];
        String totalsalary = TotalSalary(id,time);
        try {
            String querry = "SELECT * FROM employee WHERE id='" + id + "'";
            stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(querry);
            
            resultSet.next();
            data[0] = resultSet.getString("id");
            data[1] = resultSet.getString("name");
            data[2] = resultSet.getString("age");
            data[3] = resultSet.getString("salary");
            data[4] = totalsalary;
        } catch (Exception e) {
        }finally{
            return data;
        }
    }
    
    public void updateEmployee(String id, String name, String age, String salary){
                try {
                    String querry = "UPDATE `employee` SET name='" + name + "', age='" + age + "', salary='" +salary+ '"' + "WHERE id='" + id + "'";
                    
                    stmt = conn.createStatement();
                    stmt.executeUpdate(querry);
                    
                    JOptionPane.showMessageDialog(null, "Employee Updated");
                } catch (Exception e) {
                    System.out.println("Error");
                    System.out.println(e.getMessage());
                }
            }
    
    public void deleteEmployee(String id){
                try {
                    String querry = "DELETE FROM employee WHERE Id='" + id + "'";
                    
                    stmt = conn.createStatement();
                    stmt.executeUpdate(querry);
                    
                    JOptionPane.showMessageDialog(null, "Employee Deleted");
                } catch (Exception e) {
                    System.out.println("Error");
                }
            }
}
