package get_requests;

import base_urls.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import jdk.jfr.ContentType;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class Get07 extends JsonPlaceHolderBaseUrl {
    /*
        Given
	   	    https://jsonplaceholder.typicode.com/todos
		When
			 I send GET Request to the URL
		Then
			 1)Status code is 200
			 2)Print all ids greater than 190 on the console
			   Assert that there are 10 ids greater than 190
			 3)Print all userIds whose ids are less than 5 on the console
			   Assert that the number of userIds whose ids are less than 5 is 4
			 4)Print all titles whose ids are less than 5
			   Assert that "delectus aut autem" is one of the titles whose id is less than 5
     */
    @Test
    public void get07(){
        //Set the URL
        spec.pathParam("first", "todos");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do Assertion
        //1)Status code is 200
        assertEquals(200, response.statusCode());

        //2)Print all ids greater than 190 on the console
        //	Assert that there are 10 ids greater than 190
        //First Way
        JsonPath jsonPath = response.jsonPath();
        List<Integer> ids = jsonPath.getList("id");
        List<Integer> idsGreaterThan190 = ids.stream().filter(t -> t > 190).toList();
        assertEquals(idsGreaterThan190.size(), 10);

        //2nd Way: Recommended
        List<Integer> idsGreaterThan190Groovy = jsonPath.getList("findAll{it.id>190}.id");//Groovy Language ('it' is like 't->' in lambda )
        System.out.println("idsGreaterThan190Groovy = " + idsGreaterThan190Groovy);
        assertEquals(10,idsGreaterThan190Groovy.size());

        //3)Print all userIds whose ids are less than 5 on the console
        // Assert that the number of userIds whose ids are less than 5 is 4

        List<Integer> userIds = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIds = " + userIds);
        assertEquals(4, userIds.size());

        //4)Print all titles whose ids are less than 5
        //Assert that "delectus aut autem" is one of the titles whose id is less than 5

        List<String> titles = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("titles = " + titles);
        //1st Way:
        assertTrue("'delectus aut autem' does not exist",titles.contains("delectus aut autem"));
        //2nd Way:
        assertTrue("'delectus aut autem' does not exist",titles.stream().anyMatch(t->t.equals("delectus aut autem")));
    }
}

