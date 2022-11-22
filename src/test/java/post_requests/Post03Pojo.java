package post_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;

public class Post03Pojo extends JsonPlaceHolderBaseUrl {
    //To use Pojo class is the most common one it is secure and fast.
    //Until you learn it can be challenging.
        /*
    How do we handle different key-values in response?
    We use @JsonIgnoreProperties(ignoreUnknown = true) annotation at the top of the pojo class.
    It comes from "org.codehaus.jackson.annotate.JsonIgnoreProperties"
     */

    /*
         Given
            1) https://jsonplaceholder.typicode.com/todos
            2)  {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false
                }
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like {
                                    "userId": 55,
                                    "title": "Tidy your room",
                                    "completed": false,
                                    "id": 201
                                    }
     */
    @Test
    public void post03(){
        //Set the url
        spec.pathParam("first", "todos");

        //Set the expected data
        JsonPlaceHolderPojo expectedData = new JsonPlaceHolderPojo(55,"Tidy your room", false);
        System.out.println("expectedData = " + expectedData);

        //Send the request and get the response
        Response response = given().spec(spec).contentType(ContentType.JSON).body(expectedData).when().post("/{first}");
        response.prettyPrint();

        //Do assertion
        JsonPlaceHolderPojo actualData = response.as(JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);
        assertEquals(201, response.statusCode());
        assertEquals(actualData.getUserId(), expectedData.getUserId());
        assertEquals(actualData.getTitle(), expectedData.getTitle());
        assertEquals(actualData.getCompleted(), expectedData.getCompleted());


    }

}
