package game_store.DataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import game_store.ApplicationLayer.dataTypes.Order;

// Class to receive data from and write in database, orders table

public class OrderSQL {
    private static ArrayList<Order> orders = new ArrayList<Order>();

    public static List<Order> loadAllOrders() throws Exception{   // receive data from database, put in array
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("SELECT * FROM orders");
        ResultSet rs = st.executeQuery(sql);

        while(rs.next()) {
            int order_id = rs.getInt("order_id");
            int receipt_id = rs.getInt("receipt_id");
            int customer_id = rs.getInt("customer_id");
            int employee_id = rs.getInt("employee_id");
            int game_id = rs.getInt("game_id");
            int game_quantity = rs.getInt("game_amount");
            int game_price = rs.getInt("game_price");
            int total_price = rs.getInt("total_price");
            orders.add(new Order(order_id, receipt_id, customer_id, employee_id, game_id, game_quantity, game_price, total_price));
        }

        con.close();
        rs.close();
        st.close();

        return orders;
    }

    public static void createOrder(Order order) throws Exception{   // create new order
        Connection con = MySqlConnection.getConnection();
        Statement st = con.createStatement();
        String sql = ("INSERT INTO orders VALUES (DEFAULT, " + order.getReceipt_id() + ", "  + order.getCustomer_id() + ", " + order.getEmployee_id() + ", "
                        + order.getGame_id() + ", " + order.getGame_quantity() + ", " + order.getGame_price() + ", "
                        + order.getTotal_price() + ")");
        st.executeUpdate(sql);

        con.close();
        st.close();
    }
}

