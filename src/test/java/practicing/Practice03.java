package practicing;

import base_urls.ReqresBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;

public class Practice03 extends ReqresBaseUrl {
    /*
       Given
           https://reqres.in/api/users/2
       When
           User send GET Request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response format should be “application/json”
       And
           “email” is “janet.weaver@reqres.in”,
       And
           “first_name” is "Janet"
       And
           “last_name” is "Weaver"
       And
           "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
    */
    @Test
    public void practice03(){
        spec.pathParams("first", "users", "second", 2);

        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();
        assertEquals(response.statusCode(), 200);
        response.then().assertThat().contentType(ContentType.JSON)
                .body("data.email", equalTo("janet.weaver@reqres.in"));
        response.then().assertThat().body("data.first_name", equalTo("Janet"));
        response.then().assertThat().body("data.last_name", equalTo("Weaver"));
        response.then().assertThat().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"));






    }
}
