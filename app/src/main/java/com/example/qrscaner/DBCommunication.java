package com.example.qrscaner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCommunication {
    private static Connection conn = DBUtil.getConnection();

    public static QRData getQRData(String qr) {
        QRData res = null;
        try {
            String query = "SELECT events.title, coworkers.firstname, coworkers.lastname, \n" +
                                  "coworkers.email, events.meeting_date\n" +
                           "FROM events, coworkers, coworkers_events \n" +
                           "WHERE (coworkers.id = coworkers_events.id_coworker) AND " +
                           "(events.id = coworkers_events.id_event) AND (qr = ?);";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, qr);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String eventTitle  = rs.getString(1);
                String firstname   = rs.getString(2);
                String lastname    = rs.getString(3);
                String email       = rs.getString(4);
                Date   meetingDate = rs.getDate(5);

                res = new QRData(eventTitle, firstname, lastname, email, meetingDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
