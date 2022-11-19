package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Get05 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking
        When
            User sends get request to the URL
        Then
            Status code is 200
	  	And
	  		Among the data there should be someone whose firstname is "Agustin" and lastname is "Bonfanti"
     */

    @Test
    public void get05(){
        //Set the url
        spec.pathParam("first", "booking").
                queryParams("firstname","Agustin","lastname","Bonfanti");

        //Set the expected Data


        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();


        //Do Assertion

        //Status code is 200
        assertEquals(200,response.statusCode());

        //Among the data there should be someone whose firstname is "Agustin" and lastname is "Bonfanti"
        assertTrue(response.asString().contains("bookingid"));

    }
}