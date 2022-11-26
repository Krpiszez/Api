package test_data;

import java.util.HashMap;
import java.util.Map;

public class JsonPlaceHolderTestData {

    protected Map<String, Object> map = new HashMap<>();

    public JsonPlaceHolderTestData() {
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderTestData{" +
                "map=" + map +
                '}';
    }

    public JsonPlaceHolderTestData(Integer userId, String title, Boolean completed) {
        map.put("userId", userId);
        map.put("title", title);
        map.put("completed", completed);
    }

    public Map<String, Object> expectedDataJPH(Integer userId, String title, Boolean completed){

        Map<String, Object> expectedData = new HashMap<>();
        if (userId!=null){
        expectedData.put("userId", userId);
        }
        if (title!=null){
        expectedData.put("title", title);
        }
        if (completed!=null){
        expectedData.put("completed", completed);
        }

        return expectedData;
    }
    public String expectedDataInString(Integer userId, String title, Boolean completed){
        String expectedData = "{\n" +
                "    \"userId\": "+userId+",\n" +
                "    \"title\": \""+title+"\",\n" +
                "    \"completed\": "+completed+"\n" +
                "  }";
        return expectedData;
    }


    public Map<String, Object> expectedDataJPH(String firstname, String lastname, Integer totalprice,
                                               Boolean depositpaid, Map<String,String> bookingdatesMap, String additionalneeds) {
        Map<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", firstname);
        expectedData.put("lastname", lastname);
        expectedData.put("totalprice", totalprice);
        expectedData.put("depositpaid", depositpaid);
        expectedData.put("bookingdates", bookingdatesMap);
        expectedData.put("additionalneeds", additionalneeds);

        return expectedData;
    }
}
