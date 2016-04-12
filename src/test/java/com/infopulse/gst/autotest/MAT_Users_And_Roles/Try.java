package com.infopulse.gst.autotest.MAT_Users_And_Roles;


import com.infopulse.gst.autotest.utils.RandomName;
import org.testng.annotations.Test;

public class Try {

    private String username = RandomName.readFromFile().get(0);
    private String password = RandomName.readFromFile().get(1);

    @Test
    public void testReadFile() throws Exception {

        RandomName.deleteFile();


    }
}
