package pl.ciszemar.mqwebpublisher.model;

public class RegisterForm {
    private String firstName;
    private String lastName;
    private String city;
    private String brithDate;

    public RegisterForm(String firstName, String lastName, String city, String brithDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.brithDate = brithDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBrithDate() {
        return brithDate;
    }

    public void setBrithDate(String brithDate) {
        this.brithDate = brithDate;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", brithDate='" + brithDate + '\'' +
                '}';
    }
}
