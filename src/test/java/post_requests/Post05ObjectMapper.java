package post_requests;

import base_urls.DummyApiBaseUrl;
import org.junit.Test;

public class Post05ObjectMapper extends DummyApiBaseUrl {
    /*
       URL: https://dummy.restapiexample.com/api/v1/create
       HTTP Request Method: POST Request
       Request body: {
                        "employee_name": "Ali Can",
                        "employee_salary": 111111,
                        "employee_age": 23,
                        "profile_image": "Perfect image"
                     }
       Test Case: Type by using Gherkin Language
       Assert:
                i) Status code is 200
                ii) Response body should be like the following
                    {
                        "status": "success",
                        "data": {
                            "employee_name": "Ali Can",
                            "employee_salary": 111111,
                            "employee_age": 23,
                            "profile_image": "Perfect image",
                            "id": 6344
                        },
                        "message": "Successfully! Record has been added."
                    }
     */
    @Test
    public void post05(){
        //Set the url
        spec.pathParam("first", "create");

        //Set the expected data





    }
}
