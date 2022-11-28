package delete_request;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import utils.AuthenticationHerOkuApp;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Delete02 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/{bookingId}
        When
	 		I send DELETE Request to the Url
	 	Then
		 	Status code is 200
		 	And Response body is "Created"
     */
    @Test
    public void delete02(){
        //Set the url
        spec.pathParams("first", "booking", "second", 1149);

        //Set the expected data
        String expectedData = "Created";

        //Send the request and get the response
        Response response = given()
                .spec(spec)
                .headers("Cookie", "token="+ AuthenticationHerOkuApp.generateToken()
                        ,"Content-Type", "application/json").when().delete("/{first}/{second}");
        response.prettyPrint();

        //Do Assertion
        assertTrue(response.statusCode()==201);
        assertEquals(expectedData, response.asString());


    }
}
