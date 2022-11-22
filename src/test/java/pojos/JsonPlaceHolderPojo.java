package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

        /*
        How do we handle different key-values in response?
        We use @JsonIgnoreProperties(ignoreUnknown = true) annotation at the top of the pojo class.
        It comes from "org.codehaus.jackson.annotate.JsonIgnoreProperties"
         */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonPlaceHolderPojo {

    private Integer userId;
    private String title;
    private Boolean completed;

    public JsonPlaceHolderPojo() {
    }

    public JsonPlaceHolderPojo(Integer userId, String title, Boolean completed) {
        this.userId = userId;
        this.title = title;
        this.completed = completed;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public String toString() {
        return "JsonPlaceHolderPojo\n{" +
                "userId='" + userId + '\'' +
                ",\n title='" + title + '\'' +
                ",\n completed=" + completed +
                '}';
    }

}
