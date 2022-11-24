package practicing;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.AssertJUnit.assertTrue;

public class Practice04 extends HerOkuAppBaseUrl {
     /*
        Given
            https://restful-booker.herokuapp.com/booking?firstname=Brandon&lastname=Wilson
        When
            User sends get request to the URL
        Then
            Status code is 200
        And
            Among the data there should be someone whose firstname is "Brandon" and lastname is "Wilson"

 */
    @Test
    public void practice04(){
        spec.pathParams("first", "booking");



        Response response = given().spec(spec).when().get("/{first}");
        //response.prettyPrint();

        BookingDatesPojo bookingDatesObject = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Fabio", "Dominguez", 111, true, bookingDatesObject, "BreakFast");
        System.out.println("expectedData = " + expectedData);




    }
}
