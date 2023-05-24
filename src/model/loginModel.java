package model;

import bioskopku.dbconnector;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class loginModel extends dbconnector{

    public boolean loginHandler(String user, String pass){
        int totalData = 0;
        try {
            connection = getConnection();
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            };
            
            statement.close();
            if(totalData>0){
                return true;
            }
            
            return false;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
            
            return false;
        } 
    }
    
    public boolean isAdmin(String user, String pass){
        int totalData = 0;
        try {
            connection = getConnection();
            String query = "SELECT * FROM `users` WHERE "
                    + "`username`='" + user + "' AND "
                    + "`password`='" + pass + "' AND "
                    + "`role`='admin'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                totalData++;
            };
            
            statement.close();
            if(totalData>0){
                return true;
            }
            
            return false;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            e.printStackTrace();
            return false;
        } 
    }
    
    public void registerUser(String username, String password){
        String sql = "INSERT INTO `users` (`username`, `password`, `role`) "
                + "SELECT '" + username + "', '" + password + "', 'customer'"
                + "FROM DUAL "
                + "WHERE NOT EXISTS (SELECT 1 FROM `users` WHERE `username` = '" + username + "')";
        try {
            connection = getConnection();
            statement = connection.createStatement();
            int rows = statement.executeUpdate(sql);
            if (rows == 0) {
                JOptionPane.showMessageDialog(null, "The username already exists!");
            } else {
                JOptionPane.showMessageDialog(null, "Register Success");
                sql = "INSERT INTO `users` (`username`, `password`, `role`) SELECT 'paid" + username + "', 'paid" + password + "', 'customer'";
                System.out.println("trying to do the paiduser");
                statement.executeUpdate(sql);
            }
            statement.close();
        } catch (HeadlessException | SQLException e) {
            System.out.println(e+"di register");
        }
    }
}
