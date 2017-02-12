package game_store.DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import game_store.ApplicationLayer.dataTypes.Customer;

// Class to receive data from and write in database, customers table

public class CustomerSQL {
    private static ArrayList<Customer> customers = new ArrayList<Customer>();

    public static List<Customer> loadAllCustomers() throws Exception {   //receive data, put in array
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM customers");
        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            int customer_id = rs.getInt("customer_id");
            String customer_first_name = rs.getString("customer_first_name");
            String customer_last_name = rs.getString("customer_last_name");
            int customer_phone = rs.getInt("customer_phone");
            String customer_email = rs.getString("customer_email");
            customers.add(new Customer(customer_id, customer_first_name, customer_last_name, customer_phone, customer_email));
        }

        con.close();
        rs.close();
        st.close();

        return customers;
    }

    public static void createCustomer(Customer customer) throws Exception{ //create new customer and add it to customers table
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("INSERT INTO customers VALUES (" + customer.getCustomer_id() + ", "  + "\""+ customer.getCustomer_first_name() + "\""+ ", "
                + "\"" + customer.getCustomer_last_name()+ "\"" + ", " +  customer.getCustomer_phone() + ", " + "\"" + customer.getCustomer_email() + "\"" + ")");
        st.executeUpdate(sql);

        con.close();
        st.close();
    }
}

