package get_requests;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Get12Pojo extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/55
        When
 		    I send GET Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                        "firstname": "Fabio",
                                        "lastname": "Dominguez",
                                        "totalprice": 111,
                                        "depositpaid": true,
                                        "bookingdates": {
                                            "checkin": "2018-01-01",
                                            "checkout": "2019-01-01"
                                        },
                                        "additionalneeds": "Breakfast"
                                    }
     */

    @Test
    public void get12(){
        //Set the url
        spec.pathParams("first", "booking", "second", 12);

        //Set the expected data
        BookingDatesPojo bookingDatesObject = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Fabio", "Dominguez", 111, true, bookingDatesObject, "BreakFast");
        System.out.println("expectedData = " + expectedData);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        BookingPojo actualData = response.as(BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());
        //1.Way
        assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());
        //2.Way
        assertEquals(bookingDatesObject.getCheckin(), actualData.getBookingdates().getCheckin());
        assertEquals(bookingDatesObject.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(expectedData.getAdditionalNeeds(), actualData.getAdditionalNeeds());

    }
}
