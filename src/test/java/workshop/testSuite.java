package workshop;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({

        CreateBuilding.class,
        testSelenide.class

})
public class testSuite {

    @Before
    public void setUp() throws Exception {

        System.out.println("Suite is started");
    }

    @After
    public void tearDown() throws Exception {

        System.out.println("Suite finished");
    }
}
