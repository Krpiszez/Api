package get_requests;

import base_urls.GMIBankBaseUrl;
import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Country;
import pojos.Customer;
import pojos.User;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.AuthenticationGMIBank.generateToken;
import static utils.JsonUtils.convertJsonToJava;

public class Get18 extends GMIBankBaseUrl {
    /*
        Given
	       https://www.gmibank.com/api/tp-customers/110452
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
                                        "id": 110452,
                                        "firstName": "Jasmine",
                                        "lastName": "Stehr",
                                        "middleInitial": "V",
                                        "email": "marni.zboncak@yahoo.com",
                                        "mobilePhoneNumber": "463-609-2097",
                                        "phoneNumber": "1-112-497-0270",
                                        "zipCode": "16525",
                                        "address": "14387 Al Ridge5343 Bert Burgs",
                                        "city": "Waltermouth",
                                        "ssn": "761-59-2911",
                                        "createDate": "2021-11-28T21:00:00Z",
                                        "zelleEnrolled": false,
                                        "country": {
                                            "id": 3,
                                            "name": "USA",
                                            "states": null
                                        },
                                        "state": "California",
                                        "user": {
                                            "id": 110016,
                                            "login": "leopoldo.reinger",
                                            "firstName": "Jasmine",
                                            "lastName": "Stehr",
                                            "email": "marni.zboncak@yahoo.com",
                                            "activated": true,
                                            "langKey": "en",
                                            "imageUrl": null,
                                            "resetDate": null
                                        },
                                        "accounts": []
                                    }
     */
    @Test
    public void get18(){
        //Set the url
        spec.pathParams("first", "tp-customers", "second", 110452);

        //Set the expected data
        Country country = new Country(3, "USA", null);
        User user = new User(110016, "leopoldo.reinger", "Jasmine", "Stehr",
                "marni.zboncak@yahoo.com", true, "en", null, null);
        ArrayList<Object> accounts = new ArrayList<>();
        Customer expectedData = new Customer(110452, "Jasmine", "Stehr", "V", "marni.zboncak@yahoo.com",
                "463-609-2097", "1-112-497-0270", "16525", "14387 Al Ridge5343 Bert Burgs", "Waltermouth",
                "761-59-2911", "2021-11-28T21:00:00Z", false, country, "California", user, accounts);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).headers("Authorization", "Bearer "+generateToken()).when().get("/{first}/{second}");
        response.prettyPrint();

        //Do assertion
        Customer actualData = convertJsonToJava(response.asString(), Customer.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getId(), actualData.getId());
        assertEquals(expectedData.getFirstName(), actualData.getFirstName());
        assertEquals(expectedData.getLastName(), actualData.getLastName());
        assertEquals(expectedData.getMiddleInitial(), actualData.getMiddleInitial());
        assertEquals(expectedData.getEmail(), actualData.getEmail());
        assertEquals(expectedData.getMobilePhoneNumber(), actualData.getMobilePhoneNumber());
        assertEquals(expectedData.getPhoneNumber(), actualData.getPhoneNumber());
        assertEquals(expectedData.getZipCode(), actualData.getZipCode());
        assertEquals(expectedData.getAddress(), actualData.getAddress());
        assertEquals(expectedData.getCity(), actualData.getCity());
        assertEquals(expectedData.getSsn(), actualData.getSsn());
        assertEquals(expectedData.getCreateDate(), actualData.getCreateDate());
        assertEquals(expectedData.isZelleEnrolled(), actualData.isZelleEnrolled());
        assertEquals(country.getId(), actualData.getCountry().getId());
        assertEquals(country.getName(), actualData.getCountry().getName());
        assertEquals(country.getStates(), actualData.getCountry().getStates());
        assertEquals(expectedData.getState(), actualData.getState());
        assertEquals(user.getId(), actualData.getUser().getId());
        assertEquals(user.getLogin(), actualData.getUser().getLogin());
        assertEquals(user.getFirstName(), actualData.getUser().getFirstName());
        assertEquals(user.getLastName(), actualData.getUser().getLastName());
        assertEquals(user.getEmail(), actualData.getUser().getEmail());
        assertEquals(user.isActivated(), actualData.getUser().isActivated());
        assertEquals(user.getLangKey(), actualData.getUser().getLangKey());
        assertEquals(user.getImageUrl(), actualData.getUser().getImageUrl());
        assertEquals(user.getResetDate(), actualData.getUser().getResetDate());
        assertEquals(expectedData.getAccounts(), actualData.getAccounts());


    }


}
