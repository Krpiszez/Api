package pojos;

public class DummyApiResponsePojo {

    private String status;
    private DummyApiDataPojo dummyApiData;
    private String message;

    public DummyApiResponsePojo() {
    }

    public DummyApiResponsePojo(String status, DummyApiDataPojo dummyApiData, String message) {
        this.status = status;
        this.dummyApiData = dummyApiData;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DummyApiDataPojo getDummyApiData() {
        return dummyApiData;
    }

    public void setDummyApiData(DummyApiDataPojo dummyApiData) {
        this.dummyApiData = dummyApiData;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "DummyApiResponsePojo{" +
                "status='" + status + '\'' +
                ", dummyApiData=" + dummyApiData +
                ", message='" + message + '\'' +
                '}';
    }
}
