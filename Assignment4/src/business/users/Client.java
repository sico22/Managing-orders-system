package business.users;

/**
 * @author Alexandra Maria Sicobean
 * This class was used to keep track of all client users in the application. It keeps information regarding the identity and location of clients as well as a username and a password used to uniquely identify each client.
 */
public class Client extends User {
    private int noOrders = 0;
    private double maxSum = 0;

    public Client(String username, String password, String name, String address, int id) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.address = address;
        this.id = id;
    }

    public Client() {

    }

    public double getMaxSum() {
        return maxSum;
    }

    public void setMaxSum(double maxSum) {
        this.maxSum = maxSum;
    }

    public int getNoOrders() {
        return noOrders;
    }

    public void setNoOrders(int noOrders) {
        this.noOrders = noOrders;
    }
}
