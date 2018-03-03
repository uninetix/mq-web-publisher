package pl.ciszemar.mqwebpublisher.model;

public class RegisterForm {
    private String firstName;
    private String lastName;
    private String city;
    private String birthDate;

    public RegisterForm(String firstName, String lastName, String city, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.birthDate = birthDate;
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

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String brithDate) {
        this.birthDate = brithDate;
    }

    @Override
    public String toString() {
        return "RegisterForm{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", brithDate='" + birthDate + '\'' +
                '}';
    }
}
