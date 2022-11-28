package practicing;

import base_urls.DummyApiBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.DummyApiDataPojo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.AssertJUnit.assertEquals;
import static utils.JsonUtils.convertJsonToJava;

public class Get02 extends DummyApiBaseUrl {
     /*
    http://dummy.restapiexample.com/api/v1/employees url ine bir istek gönderildiğinde
    Status kodun 200 olduğunu,
      5. Çalışan isminin "Airi Satou" olduğunu ,
      çalışan sayısının 24 olduğunu,
    Sondan 2. çalışanın maaşının 106450 olduğunu
    40,21 ve 19 yaslarında çalışanlar olup olmadığını
    11. Çalışan bilgilerinin
    {
            "id":"11"
             "employee_name": "Jena Gaines",
            "employee_salary": "90560",
            "employee_age": "30",
            "profile_image": "" }
        } gibi olduğunu test edin.
*/
    @Test
    public void get02(){
        spec.pathParam("first", "employees");

        Response response = given().spec(spec).when().get("/{first}");
       // response.prettyPrint();

        List<Integer> data = response.jsonPath().getList("data.findAll{it.id==1}");
        System.out.println("data = " + data);
        List<Integer> data2 = response.jsonPath().getList("data.findAll{it.employee_age==30}.employee_name");
        System.out.println("data2 = " + data2);
        System.out.println("data.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()) = " + data.stream().sorted(Comparator.reverseOrder()).toList().get(0));
        System.out.println("data = " + data);

        JsonPath json = response.jsonPath();
        Set<Integer> expected = new HashSet<>();
        expected.add(40);
        expected.add(21);
        expected.add(19);
        System.out.println(json.getList("data.employee_age").containsAll(expected));
        assertEquals(11, json.getInt("data.id[10]"));
        assertEquals("Jena Gaines", json.getString("data.employee_name[10]"));
        assertEquals(90560, json.getInt("data.employee_salary[10]"));
        assertEquals(30, json.getInt("data.employee_age[10]"));
        assertEquals("", json.getString("data.profile_image[10]"));
        assertEquals(106450, json.getInt("data.employee_salary[-2]"));


    }
}
