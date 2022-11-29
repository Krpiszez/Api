package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class AuthenticationGMIBank {

    public static String generateToken(){

        Map<String, Object> map = new HashMap<>();
        map.put("password", "John.123");
        map.put("rememberMe", true);
        map.put("usename", "john_doe");
        Response response = given().contentType(ContentType.JSON).body(map).when().post("https://www.gmibank.com/api/authenticate");

        return response.jsonPath().getString("id_token");



    }

}
