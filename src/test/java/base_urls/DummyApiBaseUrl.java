package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyApiBaseUrl {

    protected RequestSpecification spec;

    @Before//If you use @Before annotation at the top of the method, it will work just before every test method.
    public void setUp() {

        spec = new RequestSpecBuilder().setBaseUri("https://dummy.restapiexample.com/api/v1/").build();

    }
}
