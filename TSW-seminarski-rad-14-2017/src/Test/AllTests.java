package Test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddAddressTest.class, CheckCartTest.class, CheckRegisterDataTest.class, CompanyDataTest.class,
		LogInTest.class, PerformanceTest.class, RegistrationTest.class, RemoveProductsFromCartTest.class,
		ThreeProductsTest.class, TitleTest.class, UrlTest.class })
public class AllTests {

}
