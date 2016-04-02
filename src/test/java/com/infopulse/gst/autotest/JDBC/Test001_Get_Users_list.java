package com.infopulse.gst.autotest.JDBC;


import org.testng.annotations.Test;
import org.testng.collections.Lists;

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
        List<String> expectedUsers = Arrays.asList("testuser_23:52:27", "admin", "automan");


        while (resultSet.next()) {

            Integer id = resultSet.getInt(1); // get first column returned
            String name = resultSet.getString(2);
            Integer active = resultSet.getInt(3);

            users.add(name);

        }

        System.out.println(users);

        assertThat("admin", "automan", isIn(users));
        assertThat(users, hasSize(3));
        assertThat(users, hasItems("admin", "automan", "testuser_23:52:27"));
        assertThat("admin", isIn(users));
        assertThat(users, containsInAnyOrder(expectedUsers.toArray()));
    }

}
