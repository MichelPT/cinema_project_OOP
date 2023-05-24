/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import bioskopku.dbconnector;
import static bioskopku.dbconnector.connection;
import static bioskopku.dbconnector.statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Michel
 */
public class editModel extends dbconnector{
    
    public int getData(){
        try {
            int total = 1;
            String query = "SELECT * FROM `studio`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                total++;
            }
            statement.close();
            return total;
        } catch (Exception e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public String setMovie(int index){
        String name = "";
        String data[][] = new String[getData()][2];
        try {
            String query = "SELECT * FROM `studio` WHERE `studioID`="+index;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                data[index][1] = resultSet.getString("movieName");
                name = data[index][1];
            }
            statement.close();
            return name;
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
            return name;
        }
    }
    
    public void editMovie(int index, String newName){
        try {
            String query = "UPDATE `studio` SET `movieName`='" + newName + "' WHERE `studioId`=" + index;
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }
    
    public void resetStudio(int studioNum){
        try {
            String sql = "DELETE FROM `inputan` WHERE `studioId`="+studioNum;
            statement = connection.createStatement();
            statement.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e+"di reset");
        }
    }
}
