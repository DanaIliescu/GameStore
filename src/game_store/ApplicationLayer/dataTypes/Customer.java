package game_store.ApplicationLayer.dataTypes;

/**
 * Created by Dana on 27-Apr-16.
 */
public class Customer {
    private int customer_id;
    private String customer_first_name;
    private String customer_last_name;
    private int customer_phone;
    private String customer_email;

    public Customer(int customer_id, String customer_first_name, String customer_last_name, int customer_phone, String customer_email) {
        this.customer_id = customer_id;
        this.customer_first_name = customer_first_name;
        this.customer_last_name = customer_last_name;
        this.customer_phone = customer_phone;
        this.customer_email = customer_email;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_first_name() {
        return customer_first_name;
    }

    public void setCustomer_first_name(String customer_first_name) {
        this.customer_first_name = customer_first_name;
    }

    public String getCustomer_last_name() {
        return customer_last_name;
    }

    public void setCustomer_last_name(String customer_last_name) {
        this.customer_last_name = customer_last_name;
    }

    public int getCustomer_phone() {
        return customer_phone;
    }

    public void setCustomer_phone(int customer_phone) {
        this.customer_phone = customer_phone;
    }

    public String getCustomer_email() {
        return customer_email;
    }

    public void setCustomer_email(String customer_email) {
        this.customer_email = customer_email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_id=" + customer_id +
                ", customer_first_name='" + customer_first_name + '\'' +
                ", customer_last_name='" + customer_last_name + '\'' +
                ", customer_phone=" + customer_phone +
                ", customer_email='" + customer_email + '\'' +
                '}';
    }
}
