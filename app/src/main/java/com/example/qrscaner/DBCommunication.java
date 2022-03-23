package com.example.qrscaner;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBCommunication {
    private static Connection conn = DBUtil.getConnection();

    public static QREventData getQREventData(String qr) {
        QREventData res = null;
        try {
            String query = "SELECT events.title, coworkers.firstname, coworkers.lastname, \n" +
                                  "coworkers.email, events.meeting_date\n" +
                           "FROM events, coworkers, coworkers_events \n" +
                           "WHERE (coworkers.id = coworkers_events.id_coworker) AND " +
                           "(events.id = coworkers_events.id_event) AND (coworkers_events.qr = ?);";

            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, qr);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String eventTitle  = rs.getString(1);
                String firstname   = rs.getString(2);
                String lastname    = rs.getString(3);
                String email       = rs.getString(4);
                Date   meetingDate = rs.getDate(5);

                res = new QREventData(eventTitle, firstname, lastname, email, meetingDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static QRCoworkingData getQRCoworkingData(String qr) {
        QRCoworkingData res = null;
        try {
            String query = "SELECT spaces.title, coworkers.firstname, coworkers.lastname, \n" +
                    "coworkers.email, coworkers_spaces.start_session, coworkers_spaces.end_session,\n" +
                    "purposes.title\n" +
                    "FROM spaces, coworkers, coworkers_spaces, purposes \n" +
                    "WHERE (coworkers.id = coworkers_spaces.id_coworker) AND " +
                    "(spaces.id = coworkers_spaces.id_space) AND (purposes.id = coworkers_spaces.id_purpose) " +
                    "AND (coworkers_spaces.qr = ?);";
            PreparedStatement stmt = conn.prepareStatement(query);

            stmt.setString(1, qr);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String spaceTitle       = rs.getString(1);
                String firstname            = rs.getString(2);
                String lastname             = rs.getString(3);
                String email                = rs.getString(4);
                Date   startSessionDateTime = rs.getDate(5);
                Date   endSessionDateTime   = rs.getDate(6);
                String purpose              = rs.getString(7);

                res = new QRCoworkingData(spaceTitle, firstname, lastname, email, startSessionDateTime, endSessionDateTime, purpose);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return res;
    }
}
