package game_store.PresentationLayer;

import game_store.ApplicationLayer.ReviewOrdersInfo;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

// It creates a scene for searching games (the result of searching)

public class searchScene {
    public static void makeSearchScene(Stage primaryStage, String text) {
        Stage searchStage = new Stage();
        primaryStage = searchStage;

        TableView tableview = new TableView();
        tableview = ReviewOrdersInfo.getSearchTableview(text);
        tableview.setPadding(new Insets(20, 20, 20, 20));
        tableview.setId("table");


        Scene scene = new Scene(tableview, 825, 300);
        scene.getStylesheets().addAll("CSS.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
