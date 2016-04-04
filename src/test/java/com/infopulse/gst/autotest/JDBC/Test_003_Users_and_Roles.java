package com.infopulse.gst.autotest.JDBC;

import org.testng.annotations.Test;

import java.util.HashMap;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class Test_003_Users_and_Roles extends AbstractJDBC{

    @Test
    public void testConnectUsersAndRoles() throws Exception {

        resultSet = statement.executeQuery("select ACCESS_USER.ACCOUNTNAME, ACCESS_ROLE.NAME from ACCESS_USER " +
                "full join ACCESS_USER_ROLE on ACCESS_USER.ID = ACCESS_USER_ROLE.USER_ID " +
                "full join ACCESS_ROLE on ACCESS_USER_ROLE.ROLE_ID = ACCESS_ROLE.ID");

        HashMap<String, String> map = new HashMap<String, String>();

        while (resultSet.next()){

            map.put(resultSet.getString(1), resultSet.getString(2));

        }

        System.out.println(map);
        assertThat(map.get("automan"), equalTo("Adminrolle"));


    }
}
