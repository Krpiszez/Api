package get_requests;

import base_urls.HerOkuAppBaseUrl;
import org.junit.Test;

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
                                    "firstname": "Sally",
                                    "lastname": "Wilson",
                                    "totalprice": 111,
                                    "depositpaid": true,
                                    "bookingdates": {
                                        "checkin": "2013-02-23",
                                        "checkout": "2014-10-23"
                                    },
                                    "additionalneeds": "Breakfast"
                                 }
     */

    @Test
    public void get12(){
        //Set the url
        spec.pathParams("first", "booking", "second", 1);

        //Set the expected data



    }
}
