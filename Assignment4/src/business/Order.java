package business;

/**
 * This class represents orders placed by clients
 */
public class Order {
    int orderId;
    int clientId;
    int day;
    int month;
    int hour;
    int finalPrice;

    public Order(int orderId, int clientId, int day, int month, int hour) {
        this.orderId = orderId;
        this.clientId = clientId;
        this.day = day;
        this.month = month;
        this.hour = hour;
        this.finalPrice = 0;
    }

    public Order(){
    }

    public int getOrderId() {
        return orderId;
    }

    public int getClientId() {
        return clientId;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getHour() {
        return hour;
    }

}
