package com.infopulse.gst.autotest.JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AbstractJDBC {
    Statement statement;
    ResultSet resultSet;
    private Connection connection;
    private String username = "gst";
    private String password = "tsg6102";

    @BeforeClass
    public void setUpClass() throws Exception {
        // DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        connection = DriverManager.getConnection("jdbc:oracle:thin:gst/tsg6102@localhost:1521:XE");
        statement = connection.createStatement();

    }

    @AfterClass
    public void tearDownClass() throws Exception {
        resultSet.close();
        statement.close();
        connection.close();

    }
}
