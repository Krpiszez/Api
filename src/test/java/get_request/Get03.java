package get_request;

import bas_urls.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

public class Get03 extends JsonPlaceHolderBaseUrl {

    /*
       Given
           https://jsonplaceholder.typicode.com/todos/23
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "title" is "et itaque necessitatibus maxime molestiae qui quas velit",
   And
       "completed" is false
   And
       "userId" is 2
    */

    @Test
    public void get03(){
        // Set the URL
        spec.pathParams("first", "todos", "second", 23);

        // Set the expected data

        // Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        // Do Assertion
        response
                .then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("userId", equalTo(2))
                .body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"))
                .body("completed", equalTo(false));

    }
}
