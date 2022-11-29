package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryPost {

    private String name;
    private ArrayList<States> states;

    public CountryPost(String name, ArrayList<States> states) {
        this.name = name;
        this.states = states;
    }

    public CountryPost() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<States> getStates() {
        return states;
    }

    public void setStates(ArrayList<States> states) {
        this.states = states;
    }

    @Override
    public String toString() {
        return "CountryPost{" +
                "name='" + name + '\'' +
                ", states=" + states +
                '}';
    }
}
