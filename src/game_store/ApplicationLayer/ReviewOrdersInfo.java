package game_store.ApplicationLayer;

import game_store.DataAccessLayer.ReviewOrders;
import javafx.scene.control.TableView;

public class ReviewOrdersInfo {
    public static TableView reviewOrders()
    {
        TableView tableView = new TableView();
        return ReviewOrders.buildData(tableView);
    }

    public static TableView getSearchTableview(String text)
    {
        TableView tableView = new TableView();
        return ReviewOrders.buildDataSearch(tableView, text);
    }
}
