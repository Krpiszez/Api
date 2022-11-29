package get_requests;
import base_urls.DummyApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import java.util.Collections;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;

public class Get17 extends DummyApiBaseUrl {
    /*
Given
    https://dummy.restapiexample.com/api/v1/employees
When
    User sends Get Request to the Url
Then
    Status code is 200
And
    There are 24 employees
And
    "Tiger Nixon" and "Garrett Winters" are among the employees
And
    The greatest age is 66
And
    The name of the lowest age is "[Tatyana Fitzpatrick]"
And
    Total salary of all employees is 6,644,770
 */
    @Test
    public void get17(){
        //Set the url
        spec.pathParam("first","employees");

        //Set the expected data

        //Send the request and get the response
        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        //Do assertion
        //Status code is 200, There are 24 employees, "Tiger Nixon" and "Garrett Winters" are among the employees
        response.
                then().
                assertThat().
                statusCode(200).
                body("data", hasSize(24),
                        "data.employee_name",hasItems("Tiger Nixon", "Garrett Winters"));

        //The greatest age is 66
        JsonPath json = response.jsonPath();
        List<Integer> ages = json.getList("data.employee_age");
        System.out.println("ages = " + ages);
        Collections.sort(ages);
        System.out.println("ages = " + ages);
        assertEquals(66, (int)ages.get(ages.size()-1));

        //The name of the lowest age is "[Tatyana Fitzpatrick]"
        String nameOfLowestAge = json.getString("data.findAll{it.employee_age=="+ages.get(0)+"}.employee_name");
        //ages.get(0) will give always the lowest age and will make the code more dynamic.
        System.out.println("nameOfLowestAge = " + nameOfLowestAge);
        assertEquals("[Tatyana Fitzpatrick]",nameOfLowestAge);

        //Total salary of all employees is 6,644,770
        List<Integer> salaries = json.getList("data.employee_salary");
        System.out.println("salaries = " + salaries);

        //1st Way:
        int sumOfSalaries = 0;
        for(int w:salaries){
            sumOfSalaries += w;
        }
        System.out.println("sumOfSalaries = " + sumOfSalaries);
        assertEquals(6644770,sumOfSalaries);

        //2nd Way:
        int sumOfSalariesLambda = salaries.stream().reduce(0,(t,u)->(t+u));
        System.out.println("sumOfSalariesLambda = " + sumOfSalariesLambda);
        assertEquals(6644770,sumOfSalariesLambda);

        //3rd Way:
        int sumOfSalariesLambda2 = salaries.stream().reduce(0,Math::addExact);
        System.out.println("sumOfSalariesLambda2 = " + sumOfSalariesLambda2);
        assertEquals(6644770,sumOfSalariesLambda2);

    }
}