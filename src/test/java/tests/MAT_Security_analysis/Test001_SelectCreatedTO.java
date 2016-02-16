package tests.MAT_Security_analysis;


import org.junit.Test;
import pages.GrundSchutz;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Title;
import utils.BaseClass;
import utils.CreateBuilding;
import utils.LoginUser;

public class Test001_SelectCreatedTO extends BaseClass{

    @Features("Security Analysis")
    @Test
    @Title("Test create new user")
    public void testSelectExistingTO() throws Exception {

        LoginUser.LoginProperly();

        String TOname = "testBuilding";

        CreateBuilding.generalBuilding(TOname);

        GrundSchutz.SECURITY_ANALYSIS().SelectCreatedTO(TOname);


    }
}
