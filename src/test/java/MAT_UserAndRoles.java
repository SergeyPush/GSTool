import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_USER_AND_ROLES.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test001_Add_New_User.class,
        Test002_Cancel_Button_Verification.class,
        Test003_Convert_User_To_Employee.class,
        Test004_Linking_Roles.class,
        Test005_Create_New_Role.class,
        Test006_Cancel_Button_Verif_Role.class,
        Test007_Changing_Permissions_Roles.class,
        Test008_User_Rights_Verification.class,
        Test009_Delete_Created_Role.class,
        Test010_Delete_User.class

})
public class MAT_UserAndRoles {

    @Before
    public void setUp() throws Exception {

        System.out.println("SUITE USERS AND ROLE ADMINISTRATION IS STARTING...");
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("SUITE IS FINISHED");
    }
}
