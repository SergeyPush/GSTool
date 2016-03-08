import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_Security_analysis.*;
import utils.BaseClass;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test001_SelectCreatedTO.class,
        Test002_QuickSearch_TO.class,
        Test003_Necessity_And_Proposal.class,
        Test004_Changing_Protection_Requirements.class,
        Test005_Applying_Predefined_Filter.class,
        Test006_Creating_Custom_Filter.class,
        Test010_Delete_Created_TO.class
})
public class MAT_SecurityAnalysis extends BaseClass {

    @BeforeClass
    public static void setUp() {
        System.out.println("STARTING SUITE...");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("SUITE IS FINISHED");
    }


}
