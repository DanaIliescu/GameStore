package game_store.ApplicationLayer;

import game_store.ApplicationLayer.dataTypes.Order;
import game_store.DataAccessLayer.*;

import java.util.List;

public class OrderInfo {
    private static List<Order> orders;
    static Order order;

    public static List<Order> selectAllOrders() throws Exception
    {
        orders = OrderSQL.loadAllOrders();
        return orders;
    }

    public static void createOrder(Order o)  throws Exception
    {
        order = o;
        OrderSQL.createOrder(order);
    }

}
