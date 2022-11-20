package test_data;

import java.util.HashMap;
import java.util.Map;

public class GoRestTestData {

    public Map<String, String> goRestDataMapSetUp(String name, String email, String gender, String status){
        Map<String, String> goRestDataMap = new HashMap<>();
        goRestDataMap.put("name", name);
        goRestDataMap.put("email", email);
        goRestDataMap.put("gender", gender);
        goRestDataMap.put("status", status);
        return goRestDataMap;
    }
    public Map<String, Object> expectedDataMapSetUp(Object meta, Map<String, String> data){
        Map<String, Object> goRestMap = new HashMap<>();
        goRestMap.put("meta", meta);
        goRestMap.put("data", data);
        return goRestMap;
    }



    /*
    {
        "meta": null,
        "data": {
            "name": "Dandak Adiga",
            "email": "adiga_dandak@christiansen-schimmel.biz",
            "gender": "female",
            "status": "active"
                 }
            }
     */
}
