package com;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import static java.lang.Class.forName;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    static final String JBDCDriver= "com.mysql.jdbc.Driver";
    static final String DB_URL= "jdbc:mysql://localhost/cab?";
    static final String USER = "root";
    static final String PASS = "root1234@1234";
    public void writeDriverDetailsInDatabase(String driverId, String driverName, String driverPhoneNumber, String carNumber, String carName, String carColor, double latitude, double longitude)
        throws Exception {
        try{
            forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database...");
            connect = DriverManager.getConnection(DB_URL,USER,PASS);
            String SQL= "insert into  cab.driver values (default, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement= connect.prepareStatement(SQL);
            preparedStatement.setString(1, driverName);
            preparedStatement.setString(2, driverPhoneNumber);
            preparedStatement.setString(3, carNumber);
            preparedStatement.setString(4, carName);
            preparedStatement.setString(5, carColor);
            preparedStatement.setDouble(6, latitude);
            preparedStatement.setDouble(7, longitude);
            preparedStatement.executeUpdate();

        }
        catch (Exception e) {
            throw e;
        }
        finally {
            close();
        }
      }
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}

