package post_requests;

import base_urls.GMIBankBaseUrl;
import org.junit.Test;

public class Post06 extends GMIBankBaseUrl {
    /*
         Given
            https://www.gmibank.com/api/tp-countries
            {
              "name": "USA",
              "states": [
                {
                  "id": 12,
                  "name": "California",
                  "tpcountry": null
                }
              ]
            }
        When
 		    I send POST Request to the URL
 	    Then
 		    Status code is 200
 		And
 		    Response body is like {
                                    "id": 171555,
                                    "name": "USA",
                                    "states": [
                                        {
                                            "id": 12,
                                            "name": "California",
                                            "tpcountry": null
                                        }
                                    ]
                                  }
     */
    @Test
    public void post06(){



    }

}
