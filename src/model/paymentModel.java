/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import bioskopku.dbconnector;
import bioskopku.studioCode;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Michel
 */
public class paymentModel extends dbconnector {

    private int count;
    private int price;

    public boolean detectBooking() {
        try {
            String sql = "SELECT COUNT(*) FROM `inputan` WHERE `username`='" + dbconnector.username + "'";
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                this.count = resultSet.getInt("COUNT(*)");
            }
            boolean returnValue = this.count == 0;
            statement.close();
            return returnValue;
        } catch (SQLException e) {
            System.out.println(e + " di detectbooking");
            return false;
        }
    }

    public String getSeats(int studioNum) {
        String[] seatsData;
        String seats = "";
        try {
            String sql = "SELECT * FROM `inputan` WHERE `username`='" + username + "' AND `studioId`=" + studioNum;
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.last();
            int rowCount = resultSet.getRow();
            resultSet.beforeFirst();
            seatsData = new String[rowCount];

            int index = 0;
            this.count = 0;
            while (resultSet.next()) {
                seatsData[index] = resultSet.getString("kodekursi") + " ";
                index++;
                this.count++;
            }

            StringBuilder builder = new StringBuilder();
            for (String string : seatsData) {
                builder.append(string);
            }
            seats = builder.toString();
            statement.close();
            switch (studioNum) {
                case 1 -> {
                    studioCode studio = studioCode.Atrium;
                    price = studio.getPrice();
                }
                case 2 -> {
                    studioCode studio = studioCode.Spherex;
                    price = studio.getPrice();
                }
                case 3 -> {
                    studioCode studio = studioCode.Galaxy;
                    price = studio.getPrice();
                }
                default -> throw new AssertionError();
            }
        } catch (SQLException e) {
            System.out.println(e + " di getseats");
        }
        return seats;
    }

    public int totalBill() {
        int total = this.price * this.count;
        return total;
    }

    public String getMovieName(int studioNumber) {
        try {
            String sql = "SELECT * FROM `studio` WHERE `studioId`=" + studioNumber;
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            
            if (resultSet.next()) {
                return resultSet.getString("movieName");
            } else {
                return "";
            }
        } catch (SQLException e) {
            System.out.println(e + " di get moviename");
            return "";
        }
    }

    public int setSeatsPaid(int studioNum) {
        try {
            String sql = "UPDATE `inputan` SET `username`='paid" + username + "' WHERE `username`='" + username + "' AND `studioId`=" + studioNum;
            statement = connection.createStatement();
            int ticketsCount = statement.executeUpdate(sql);
            statement.close();
            return ticketsCount;
        } catch (SQLException e) {
            System.out.println(e+"di setseatspaid");
            return 0;
        }
    }
    
    
}
