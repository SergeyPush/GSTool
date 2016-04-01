package com.infopulse.gst.autotest.JDBC;

import org.testng.Assert;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleQuery2 {

    public static void main(String[] args) throws SQLException {

        // Connect to Oracle Database
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:gst/tsg6102@localhost:1521:xe");
        Statement statement = con.createStatement();

        // Enables us to retrieve values as if querying from a table
        ResultSet rs = statement.executeQuery("select ID, ACCOUNTNAME, ACTIVE from ACCESS_USER");

        String[] expectedSet = {"automan", "admin", "tuser"};
        List<String> expected = new ArrayList<String>(Arrays.asList(expectedSet));
        List<String> users = new ArrayList<String>();

        while (rs.next()) {

            Integer id = rs.getInt(1); // get first column returned
            String name = rs.getString(2);
            Integer active = rs.getInt(3);

            users.add(name);

            System.out.println("Id : |" + id + "| Name: |" + name + "| Active: | " + active);
        }


        System.out.println(users);

        Assert.assertTrue(users.size()==3);
        Assert.assertTrue(users.contains("admin"));
        Assert.assertEquals(expected, users);

        rs.close();
        statement.close();
        con.close();
    }
}
