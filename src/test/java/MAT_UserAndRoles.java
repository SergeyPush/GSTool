import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_USER_AND_ROLES.Test002_Add_New_User;
import tests.MAT_USER_AND_ROLES.Test003_Cancel_Button_Verification;
import tests.MAT_USER_AND_ROLES.Test004_Convert_User_To_Employee;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        Test002_Add_New_User.class,
        Test003_Cancel_Button_Verification.class,
        Test004_Convert_User_To_Employee.class


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
