package get_requests;

import base_urls.GoRestBaseUrl;
import org.junit.Test;

public class Get13Pojo extends GoRestBaseUrl {
    /*
        Given
            https://gorest.co.in/public/v1/users/13
        When
            User send GET Request to the URL
        Then
            Status Code should be 200
        And
            Response body should be like
                          {
                            "meta": null,
                            "data": {
                                "id": 13,
                                "name": "Rahul Jha",
                                "email": "jha_rahul@beahan.co",
                                "gender": "male",
                                "status": "active"
                            }
                         }
    */
    @Test
    public void get13Pojo(){
        //Set the url
        spec.pathParams("first", "users", "second",13);

        //Set the expected data

    }
}
