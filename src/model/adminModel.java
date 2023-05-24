package model;

import bioskopku.dbconnector;
import java.awt.HeadlessException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class adminModel extends dbconnector{

    public static final String[] HEADER = {"ID", "Nomor Studio", "Kode Kursi"};
    
    public int getData(){
        try {
            int total = 0;
            String query = "SELECT * FROM `inputan`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                total++;
            }
            statement.close();
            return total;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return 0;
        }
    }
    
    public String[][] readAllData(){
        String data[][] = new String[getData()][4];
        try {
            int index = 0;  
            String query = "SELECT * FROM `inputan`";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[index][0] = resultSet.getString("id");
                data[index][1] = resultSet.getString("studioId");
                data[index][2] = resultSet.getString("kodekursi");
                index++;
            }
            statement.close();
            return data;
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
            return data;
        }
    }
    
    public void insertData(int studioNum, String sitNum){
        try {
            String query = "INSERT INTO `inputan` (`studioId`, `kodekursi`) "
                    + "VALUES "
                    + "('" + studioNum + "','" + sitNum + "')";
            
            statement = connection.createStatement();
            statement.executeUpdate(query);
            
            statement.close();
            JOptionPane.showMessageDialog(null, "Input Success");
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Failed : " + e.getMessage());
        }
    }
   
}