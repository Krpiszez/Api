package practicing;

import base_urls.ReqresBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Practice02 extends ReqresBaseUrl {
    /*
        Given
            https://reqres.in/api/users/23
        When
            User send a GET Request to the url
        Then
            HTTP Status code should be 404
        And
            Status Line should be HTTP/1.1 404 Not Found
        And
            Server is "cloudflare"
        And
            Response body should be empty

     */

    @Test
    public void practice02(){
        spec.pathParams("first", "users", "second", 23);

        Response response = given()
                .spec(spec)
                .when()
                .get("/{first}/{second}");
                response
                        .then()
                .assertThat()
                .statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .header("Server", "cloudflare");
                assertEquals(response.asString().replaceAll("[^A-aZ-z0-9]", "").length(), 0);







    }
}
