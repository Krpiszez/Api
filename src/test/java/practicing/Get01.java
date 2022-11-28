package practicing;

import base_urls.HerOkuAppBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.JsonUtils.convertJsonToJava;

public class Get01 extends HerOkuAppBaseUrl {

     /*
    Given
        "https://restful-booker.herokuapp.com/booking/5 "
    When
      I send a GET request to the Url
   And
       Accept type is "application/json"
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       first name should be "Der"
   And
       And total price should be 11111
   And
       And checkin date should be "2020-11-02"

 */
    @Test
    public void get01(){
        spec.pathParams("first", "booking", "second", 5);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{first}/{second}");
        response.prettyPrint();

        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2021-11-11", "2022-12-12");
        BookingPojo expectedData = new BookingPojo("Nick","Smith",100,true,bookingDatesPojo,"Breakfast");
        System.out.println("expectedData = " + expectedData);
        BookingPojo actualData = convertJsonToJava(response.asString(), BookingPojo.class);
        System.out.println("actualData = " + actualData);

        assertEquals(response.contentType(), "application/json; charset=utf-8");
        assertEquals(response.statusCode(), 200);
        assertEquals(response.jsonPath().getString("firstname"), "Nick");
        assertEquals(response.jsonPath().getString("totalprice"), "100");
        assertEquals(response.jsonPath().getString("bookingdates.checkin"), "2021-11-11");
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());
    }
}
