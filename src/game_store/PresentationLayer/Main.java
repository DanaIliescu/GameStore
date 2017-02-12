package game_store.PresentationLayer;

import com.sun.org.apache.bcel.internal.generic.LoadClass;
import com.sun.org.apache.xpath.internal.operations.Or;
import game_store.ApplicationLayer.*;
import game_store.ApplicationLayer.dataTypes.*;
import game_store.PresentationLayer.makeOrder;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.PickResult;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//Main Class, in which we get data from database into arrays
//Has only method in start, which creates the first scene (login scene)

public class Main extends Application {

    static List<Game> allGames;
    static List<Order> allOrders;
    static List<Customer> allCustomers;
    static List<Receipt> allReceipts;
    static List<Employee> allEmployees;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        allGames = GameInfo.selectAllGames();
        allCustomers = CustomerInfo.selectAllCustomers();
        allOrders = OrderInfo.selectAllOrders();
        allReceipts = ReceiptInfo.selectAllReceipts();
        allEmployees = EmployeeInfo.selectAllEmployees();

        primaryStage.setTitle("Games");

        VBox logInScene_pic = LogInScene.makeLogInScene_logo(primaryStage);

        Scene scene = new Scene(logInScene_pic, 400, 500);
        scene.getStylesheets().add("CSS.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}