package game_store.PresentationLayer;

import game_store.ApplicationLayer.ReviewOrdersInfo;
import game_store.DataAccessLayer.ReviewOrders;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

// Creates a scene for reviewing orders

public class reviewOrdersScene {

    public static void makeReviewOrdersScene(Stage primaryStage) {
        primaryStage = new Stage();

        TableView tableview = new TableView();
        tableview = ReviewOrdersInfo.reviewOrders();
        tableview.setPadding(new Insets(20, 20, 20, 20));
        tableview.setId("table");

        Scene scene = new Scene(tableview, 800, 600);
        scene.getStylesheets().add("CSS.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
