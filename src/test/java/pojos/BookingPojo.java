package pojos;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingPojo {

    private String firstname;
    private String lastname;
    private Integer totalprice;
    private Boolean depositpaid;
    private BookingDatesPojo bookingdates;
    private String additionalNeeds;

    public BookingPojo() {
    }

    public BookingPojo(String firstname, String lastname, Integer totalprice, Boolean depositpaid, BookingDatesPojo bookingdates, String additionalNeeds) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.totalprice = totalprice;
        this.depositpaid = depositpaid;
        this.bookingdates = bookingdates;
        this.additionalNeeds = additionalNeeds;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getTotalprice() {
        return totalprice;
    }

    public Boolean getDepositpaid() {
        return depositpaid;
    }

    public BookingDatesPojo getBookingdates() {
        return bookingdates;
    }

    public String getAdditionalNeeds() {
        return additionalNeeds;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setTotalprice(Integer totalprice) {
        this.totalprice = totalprice;
    }

    public void setDepositpaid(Boolean depositpaid) {
        this.depositpaid = depositpaid;
    }

    public void setBookingdates(BookingDatesPojo bookingdates) {
        this.bookingdates = bookingdates;
    }

    public void setAdditionalNeeds(String additionalNeeds) {
        this.additionalNeeds = additionalNeeds;
    }

    @Override
    public String toString() {
        return "BookingPojo{\n" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", totalprice=" + totalprice +
                ", depositpaid=" + depositpaid +
                ", bookingdates=" + bookingdates +
                ", additionalNeeds='" + additionalNeeds + '\'' +
                '}';
    }
}
