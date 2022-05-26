package business.users;

/**
 * @author Alexandra Maria Sicobean
 *
 * This class is the superclass of the class Client as well as of the future subclasses Admin and Employee
 */
public class User {
    protected String username;
    protected String password;
    protected String name;
    protected String address;
    protected int id;

    public User() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
