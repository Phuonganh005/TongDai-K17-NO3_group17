package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ReturnBookAiven {
    public void returnBook(String bookID) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://avnadmin:AVNS_4nU1y6avZRmSrZ0OhWl@mysql-cd52b85-raznopro2k5-c07e.c.aivencloud.com:22996/defaultdb?ssl-mode=REQUIRED",
                "avnadmin", "AVNS_4nU1y6avZRmSrZ0OhWl")) {

            String query = "UPDATE book SET borrowed = FALSE WHERE bookID = ?";
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, bookID);
            pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
