package HerOkuAppSmokeTest;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static HerOkuAppSmokeTest.S1Post.bookingid;
import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class S5Get extends HerOkuAppBaseUrl {

    /*Type an automation smoke test by using "https://restful-booker.herokuapp.com/apidoc/index.html" documentation.
     Create a booking then update, read and delete the booking you created.
    */
    /*
    Given
        https://restful-booker.herokuapp.com/booking/:id

    When
        User send Get request
    Then
        Status Code must be 200
    And
        Response body is like {
                                "firstname" : "James",
                                "lastname" : "Brown",
                                "totalprice" : 500,
                                "depositpaid" : false,
                                "bookingdates" : {
                                    "checkin" : "2022-11-27",
                                    "checkout" : "2022-11-29"
                                     },
                                "additionalneeds" : "Breakfast"
                                }
     */
    @Test
    public void get02(){
        //Set the url
        spec.pathParams("first", "booking", "second", bookingid);

        //Set the expected data
        String expectedData = "Not Found";

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        assertEquals(404, response.statusCode());
        assertEquals(expectedData, response.asString());


    }
}
