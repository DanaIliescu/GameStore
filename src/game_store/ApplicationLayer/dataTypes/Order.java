package game_store.ApplicationLayer.dataTypes;

import java.util.ArrayList;

/**
 * Created by Dana on 27-Apr-16.
 */
public class Order {
    private int order_id;
    private int receipt_id;
    private int game_id;
    private int game_price;
    private int game_quantity;
    private int total_price;
    private int employee_id;
    private int customer_id;
    private ArrayList<Order> productlist;

    public Order(int game_id, int game_quantity, int game_price, int total_price) {
        this.game_id = game_id;
        this.game_price = game_price;
        this.game_quantity = game_quantity;
        this.total_price = total_price;
    }

    public Order(int order_id, int receipt_id, int customer_id, int employee_id, int game_id, int game_quantity, int game_price, int total_price) {
        this.order_id = order_id;
        this.receipt_id = receipt_id;
        this.game_id = game_id;
        this.game_price = game_price;
        this.game_quantity = game_quantity;
        this.total_price = total_price;
        this.employee_id = employee_id;
        this.customer_id = customer_id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public int getGame_price() {
        return game_price;
    }

    public void setGame_price(int game_price) {
        this.game_price = game_price;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getGame_quantity() {
        return game_quantity;
    }

    public void setGame_quantity(int game_quantity) {
        this.game_quantity = game_quantity;
    }

    public int getTotal_price() {
        return total_price;
    }

    public void setTotal_price(int total_price) {
        this.total_price = total_price;
    }

    public int getReceipt_id() {
        return receipt_id;
    }

    public void setReceipt_id(int receipt_id) {
        this.receipt_id = receipt_id;
    }

    @Override
    public String toString() {
        return "Order{" +
                "game_id=" + game_id +
                ", game_price=" + game_price +
                ", game_quantity=" + game_quantity +
                ", total_price=" + total_price +
                '}';
    }
}
