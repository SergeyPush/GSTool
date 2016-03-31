package com.infopulse.gst.autotest.JDBC;


import java.sql.*;

public class SimpleQuery {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        String username = "gst";
        String password = "tsg6102";
        String command = "select ID, ACCOUNTNAME from ACCESS_USER";

        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:" + username + "/" + password + "@localhost:1521:xe");
            st = conn.createStatement();
            rs = st.executeQuery("select ID, ACCOUNTNAME from ACCESS_USER");
            while (rs.next()) {
                System.out.print(rs.getInt(1) + "\t");
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }


}