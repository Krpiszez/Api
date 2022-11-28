package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;
import static utils.AuthenticationHerOkuApp.generateToken;

public class S4Delete extends HerOkuAppBaseUrl {

    /*Type an automation smoke test by using "https://restful-booker.herokuapp.com/apidoc/index.html" documentation.
     Create a booking then update, read and delete the booking you created.
    */
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id
    When
        User send Delete request
    Then
        Status Code must be 201
    And
        Response body is like "Created"
     */
    @Test
    public void delete01(){
        //Set the url
        spec.pathParams("first", "booking", "second", bookingid);

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given().spec(spec).header("Cookie", "token="+generateToken()).contentType(ContentType.JSON).when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertEquals(201, response.statusCode());
        assertEquals(expectedData, response.asString());
    }
}
