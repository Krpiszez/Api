package get_request;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class Get02 {
    /*
   Given
       https://restful-booker.herokuapp.com/booking/1
   When
       User send a GET Request to the url
   Then
       HTTP Status code should be 404
   And
       Status Line should be HTTP/1.1 404 Not Found
   And
       Response body contains "Not Found"
   And
       Response body does not contain "TechProEd"
   And
       Server is "Cowboy"
*/
    @Test
    public void get02(){
        // Set the url
        String url = "https://restful-booker.herokuapp.com/booking/1";

        // Set the expected data we do this later post request ??

        // Send the request and get the response
        Response response = given().when().get(url);
        response.prettyPrint();

        // Do Assertion
        response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");

        // Response body contains "Not Found"
        assertTrue(response.asString().contains("Not Found"));

        // Response body does not contain "TechProEd"
        assertFalse(response.asString().contains("TechProEd"));

        // Server is "Cowboy"
        assertEquals("Cowboy", response.getHeader("Server"));



    }
}
