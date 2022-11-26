package post_requests;

import base_urls.DummyApiBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import pojos.DummyApiDataPojo;
import pojos.DummyApiResponsePojo;
import utils.JsonUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Post05ObjectMapper extends DummyApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    @Test
    public void post05() throws IOException {
        //Set the url
        spec.pathParam("first", "create");

        //Set the expected data
        DummyApiDataPojo expectedData = new DummyApiDataPojo("Ali Can", 111111, 23, "Perfect Image");
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do Assertion
        DummyApiResponsePojo actualData = new ObjectMapper().readValue(response.asString(), DummyApiResponsePojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals("success", actualData.getStatus());
        assertEquals("Successfully! Record has been added.", actualData.getMessage());
        assertEquals(actualData.getData().getEmployee_name(), expectedData.getEmployee_name());
        assertEquals(actualData.getData().getEmployee_age(), expectedData.getEmployee_age());
        assertEquals(actualData.getData().getEmployee_salary(), expectedData.getEmployee_salary());
        assertEquals(actualData.getData().getEmployee_image(), expectedData.getEmployee_image());


    }
}
