package com.infopulse.gst.autotest.JDBC;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test001_Get_Users_list extends AbstractJDBC {


    @Test
    public void testGetUsersList() throws Exception {
        resultSet = statement.executeQuery("select ID, ACCOUNTNAME, ACTIVE from ACCESS_USER");

        List<String> users = new ArrayList<String>();
        List<String> expectedUsers = Arrays.asList("tuser", "admin", "automan");


        while (resultSet.next()) {

            Integer id = resultSet.getInt("ID");
            String name = resultSet.getString("ACCOUNTNAME");
            Integer active = resultSet.getInt("ACTIVE");

            users.add(name);

        }

        System.out.println(users);

        assertThat("admin", "automan", isIn(users));
        assertThat(users, hasSize(3));
        assertThat(users, hasItems("admin", "automan", "tuser"));
        assertThat("admin", isIn(users));
        assertThat(users, containsInAnyOrder(expectedUsers.toArray()));
    }

}
