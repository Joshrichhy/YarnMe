package dtos.requests;

public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String password;
    private String userName;

    @Override
    public String toString() {
        return "RegisterRequest{" +
                "\n firstName='" + firstName + '\'' +
                ",\n lastName='" + lastName + '\'' +
                ", \n password='" + password + '\'' +
                ", \n userName='" + userName + '\'' +
                '}';
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
