package by.fpmibsu.slastymordasty.entity;

public class User extends Entity{
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private int role;
    private String address;

    public User(long id, String name, String email, String phoneNumber, String password, int role, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.address = address;
    }

    public User(String name, String email, String phoneNumber, String password, int role, String address) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.role = role;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





    @Override
    public String toString() {
        return id + " " + name + " " + email + " " + phoneNumber + " " + role + " " + address;
    }
}
