import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.MAT_Security_Analysis.*;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        Test001_Select_Created_TO.class,
        Test002_QuickSearch_TO.class,
        Test003_Necessity_And_Proposal.class,
        Test004_Changing_PR.class,
        Test005_Applying_Predefined_Filter.class,
        Test006_Creating_Custom_Filter.class,
        Test010_Delete_Created_TO.class

})
public class MAT_SecurityAnalysis{

    @BeforeClass
    public static void setUp() {
        System.out.println("STARTING SUITE...");
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("SUITE IS FINISHED");
    }


}
