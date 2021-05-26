package models;

public class User {
    public String id;
    public String userName;
    public String fullName;
    public String address;

    public User(String id, String userName, String fullName, String address) {
        this.id = id;
        this.userName = userName;
        this.fullName = fullName;
        this.address = address;
    }
}
