package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GMIBankBaseUrl {

    protected RequestSpecification spec;

    @Before//If you use @Before annotation at the top of the method, it will work just before every test method.
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://www.gmibank.com/api").build();

    }
}
