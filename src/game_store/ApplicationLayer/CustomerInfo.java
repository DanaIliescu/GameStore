package game_store.ApplicationLayer;

import game_store.ApplicationLayer.dataTypes.Customer;
import game_store.DataAccessLayer.*;

import java.util.List;

// Access the data layer, get the customer array list
public class CustomerInfo {
    private static List<Customer> customers;
    static Customer customer;

    public static List<Customer> selectAllCustomers() throws Exception
    {
        customers = CustomerSQL.loadAllCustomers();
        return customers;
    }

    public static void createCustomer(Customer c) throws Exception
    {
        customer = c;
        CustomerSQL.createCustomer(customer);
    }
}
