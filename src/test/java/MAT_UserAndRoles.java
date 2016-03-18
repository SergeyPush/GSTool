import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_USER_AND_ROLES.*;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test001_LoginTest.class,
        Test002_Add_New_User.class,
        Test003_Cancel_Button_Verification.class,
        Test004_Convert_User_To_Employee.class,
        Test005_Linking_Roles.class,
        Test006_Create_New_Role.class,
        Test007_Cancel_Button_Verification.class,
        Test008_Changing_Role_Permissions.class,
        Test009_User_Rights_Verification.class,
        Test010_Delete_Created_Role.class,
        Test011_Delete_Created_User.class


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
