import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_Security_analysis.Test001_SelectCreatedTO;
import tests.MAT_Security_analysis.Test010_Delete_Created_TO;
import utils.BaseClass;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test001_SelectCreatedTO.class,
        Test010_Delete_Created_TO.class
})
public class TestSuite_MAT_SecurityAnalysis extends BaseClass {

    @BeforeClass
    public static void setUp() {
        System.out.println("Start suite");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Stop suite");
    }


}
