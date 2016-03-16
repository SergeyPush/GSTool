package tests.MAT_USER_AND_ROLES_OLD;


import org.junit.Test;
import pages.Common;
import pages.Extras;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.*;

public class Test008_User_Rights_Verification extends BaseClass{

    @Features("User management")
    @Test
    @Title("Add permission to the role, verify that permissions work")
    public void testVerifyUserRights() throws Exception {
        LoginUser.LoginProperly();

        Extras.USER_ADMINISTRATION().selectUser("testuser");

        Extras.USER_ADMINISTRATION().AddRoleToUser("testrole");

        Common.TOP_MENU().LogOut();


        String username = RandomName.readFromFile().get(0);
        String password = RandomName.readFromFile().get(1);

        LoginUser.loginAs(username, password);

        ToCreation.CreateNewTO("Building");
    }
}
