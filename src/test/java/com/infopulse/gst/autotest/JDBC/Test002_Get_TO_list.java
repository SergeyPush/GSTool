package com.infopulse.gst.autotest.JDBC;


import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class Test002_Get_TO_list extends AbstractJDBC {

    @Test
    public void testGetListOfTOs() throws Exception {

        resultSet = statement.executeQuery("select NAME from TARGET_OBJECT");
        List<String> TOs = new ArrayList<String>();

        List<String> TOsExpected = new ArrayList<String>();

        while (resultSet.next()) {
            TOs.add(resultSet.getString(1));

        }

        System.out.println(TOs);

        assertThat(TOs, hasSize(14));
        assertThat(TOs, contains("tempBuilding", "Admin", "Boss", "Database", "Headquarters", "Lawyer Agency", "Local network", "Main room", "Make money", "Microsoft Office", "PC", "Remote Office", "testBuilding", "testuser_23:52:27"));
        assertThat(TOs, hasItems("tempBuilding", "Admin", "Boss"));
        assertThat(TOs, hasItem("Boss"));
        assertThat(TOs, is(not(empty())));

    }
}
