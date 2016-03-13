import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.SecurityConceptCreation.Test001_CreateNewSecurityConcept;
import tests.SecurityConceptCreation.Test002_CreateITAssetSet;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        Test001_CreateNewSecurityConcept.class,
        Test002_CreateITAssetSet.class


})
public class CreateConceptSuite {
}
