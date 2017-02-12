package game_store.PresentationLayer;

import game_store.ApplicationLayer.CustomerInfo;
import game_store.ApplicationLayer.GameInfo;
import game_store.ApplicationLayer.OrderInfo;
import game_store.ApplicationLayer.ReceiptInfo;
import game_store.ApplicationLayer.dataTypes.Customer;
import game_store.ApplicationLayer.dataTypes.Game;
import game_store.ApplicationLayer.dataTypes.Order;
import game_store.ApplicationLayer.dataTypes.Receipt;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

// In this class you can make a new order

public class makeOrder {
    static Label orderTitle;
    static Game game;
    static ComboBox comboBox;
    static TextField qInput;
    static TextField employeeIDInput;
    static TextField phoneInput;
    static TextField emailInput;
    static TextField lastNameInput;
    static TextField firstNameInput;
    static VBox orderVBox;
    static Label actualPrice;
    static Order order1;
    static int customer_id;
    static List<Game> allGames;
    static List<Order> productList;
    static List<Order> allOrders;
    static List<Customer> allCustomers;
    static List<Receipt> allReceipts;


    public static void MakeOrderButtonClicked(Stage primaryStage) {

        try {
            allGames = Main.allGames;
            allCustomers = Main.allCustomers;
            allOrders = Main.allOrders;
            allReceipts = Main.allReceipts;
            productList = new ArrayList<Order>();

            Stage orderStage = new Stage();
            primaryStage = orderStage;

            //First Title
            Label firstTitle = new Label("Game Info");
            firstTitle.setId("header");
            firstTitle.setAlignment(Pos.CENTER);

            //HBox for ComboBox, TextField and Labels
            HBox upperBox = makeUpperBox();

            //Second Title
            Label secondTitle = new Label("Customer Info");
            secondTitle.setId("header");
            secondTitle.setAlignment(Pos.CENTER);

            //Information about the customer = create new customer object
            GridPane customerInfo = makeCustomerInfo();

            //Third Title
            Label thirdTitle = new Label("Employee Info");
            thirdTitle.setId("header");
            thirdTitle.setAlignment(Pos.CENTER);

            //Information about the employee
            HBox employeeInfo = makeEmployeeInfo();

            //Sell Button, New Order Button & Cancel Button - in a HBox
            HBox buttons = new HBox(20);
            //Sell Button
            Button sell = new Button("Sell");
            sell.setOnAction(e -> {
                try{
                    sellClicked();
                }
                catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            });
            //Cancel Button - closes this stage, goes to main stage
            Button cancel = new Button("Cancel");
            cancel.setOnAction(e -> orderStage.close());

            //New Order Button - clears orders vbox and all textfields
            Button newOrder = new Button("New Order");
            newOrder.setOnAction(e -> {
                try{
                    newOrderClicked();
                }
                catch (Exception ex) {
                    System.out.println(ex.toString());
                }
            });


            buttons.getChildren().addAll(sell, newOrder, cancel);
            buttons.setAlignment(Pos.CENTER);

            //VBox
            VBox bigVBox = new VBox(30);
            bigVBox.getChildren().addAll(firstTitle, upperBox, secondTitle, customerInfo, thirdTitle, employeeInfo, buttons);
            bigVBox.setPadding(new Insets(40, 20, 20, 40));

            //Order VBox
            orderTitle = new Label("Order");
            orderTitle.setId("header");
            orderTitle.setAlignment(Pos.CENTER);
            orderVBox = new VBox(20);
            orderVBox.getChildren().addAll(orderTitle);
            orderVBox.setId("vbox");
            orderVBox.setPadding(new Insets(40, 10, 10, 40));
            orderVBox.setPrefSize(450, 600);

            //Layout - HBox
            HBox layout = new HBox(100);
            layout.getChildren().addAll(bigVBox, orderVBox);

            //Make Order Scene & Stage
            Scene scene2 = new Scene(layout);
            scene2.getStylesheets().add("CSS.css");
            primaryStage.setScene(scene2);
            primaryStage.show();
        }
        catch(Exception e){}
    }

    //Checks if input from qInput TextField is numeric
    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c))
                return false;
        }
        return true;
    }

    //String to int converter
    public static int getAuxText(Label aux){
        int price = Integer.parseInt(aux.getText());
        return price;
    }

    public static HBox makeUpperBox(){
        try {

            //Auxiliary Label - helps to calculate the price
            Label aux = new Label();

            //ComboBox for  selecting the games
            comboBox = new ComboBox();
            comboBox.setMaxWidth(150);
            comboBox.setId("gamesBox");
            comboBox.setPromptText("Select Game...");
            for (int i = 0; i < allGames.size(); i++)
                comboBox.getItems().add(allGames.get(i).getGame_title());

            comboBox.setOnAction(e -> {
                //finds the game object corresponding to the ComboBox choice
                for (int i = 0; i < allGames.size(); i++) {
                    if (comboBox.getValue().toString().equals(allGames.get(i).getGame_title()))
                        game = allGames.get(i);
                }
                //after the game is found, auxiliary label's text is set to the price of that game
                aux.setText(Integer.toString(game.getGame_price()));
            });

            //Quantity input
            qInput = new TextField();
            qInput.setMaxWidth(70);
            qInput.setPromptText("Quantity");
            qInput.setMinWidth(60);
            qInput.setAlignment(Pos.CENTER);
            qInput.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.ENTER) {
                    addOrderClicked();
                }
            });

            //Labels for price
            Label price = new Label("Price: ");
            actualPrice = new Label();
            actualPrice.setMinWidth(50);
            Label dkk = new Label("dkk");

            //Calculate actual price
            qInput.textProperty().addListener((observable, oldValue, newValue) -> {
                //checks if the ComboBox has a value - first you need to choose game, and only after input quantity
                //if not, shows alert
                if (comboBox.getValue() == null) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Please select game first.");
                    alert.showAndWait();
                    qInput.clear();
                } else {
                    //checks if the String input represents a numeric value
                    //if not, shows alert
                    if (!isNumeric(qInput.getText())) {
                        Alert alert = new Alert(Alert.AlertType.ERROR);
                        alert.setTitle("ERROR");
                        alert.setHeaderText(null);
                        alert.setContentText("Please enter numeric value.");
                        alert.showAndWait();
                        qInput.clear();
                    } else {
                        if (qInput.getText().isEmpty())
                            actualPrice.setText(" ");
                        else {
                            //calculates the price - price/game (from auxiliary label) * quantity (from qInput TextField)
                            int actPrice = getAuxText(aux) * Integer.parseInt(qInput.getText());
                            newValue = Integer.toString(actPrice);
                            actualPrice.setText(newValue);
                        }
                    }
                }
            });

            //Add to order Button
            Button addOrder = new Button("Add");
            addOrder.setOnAction(e -> addOrderClicked());

            HBox upperBox = new HBox(20);
            upperBox.getChildren().addAll(comboBox, qInput, price, actualPrice, dkk, addOrder);
            upperBox.setAlignment(Pos.CENTER);
            return upperBox;
        }catch (Exception e){}
        return null;
    }

    public static GridPane makeCustomerInfo(){
        try{
            //GridPane with 10px padding around edge
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(8);
            grid.setHgap(10);

            //First Name Label - constrains use (child, column, row)
            Label firstNameLabel = new Label("Customer first name:");
            GridPane.setConstraints(firstNameLabel, 0, 0);

            //First Name Input
            firstNameInput = new TextField();
            firstNameInput.setPromptText("First name");
            firstNameInput.setAlignment(Pos.CENTER);
            GridPane.setConstraints(firstNameInput, 1, 0);

            //Last Name Label
            Label lastNameLabel = new Label("Customer last name:");
            GridPane.setConstraints(lastNameLabel, 0, 1);

            //Last Name Input
            lastNameInput = new TextField();
            lastNameInput.setPromptText("Last name");
            lastNameInput.setAlignment(Pos.CENTER);
            GridPane.setConstraints(lastNameInput, 1, 1);

            //Telephone Number Label
            Label phoneLabel = new Label("Phone Number:");
            GridPane.setConstraints(phoneLabel, 0, 2);

            //Telephone Number Input
            phoneInput = new TextField();
            phoneInput.setPromptText("Phone Number");
            phoneInput.setAlignment(Pos.CENTER);
            GridPane.setConstraints(phoneInput, 1, 2);
            phoneInput.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!isNumeric(phoneInput.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter numeric value.");
                    alert.showAndWait();
                    phoneInput.clear();
                }
            });

            //Email Label
            Label emailLabel = new Label("Email:");
            GridPane.setConstraints(emailLabel, 0, 3);

            //Email Input
            emailInput = new TextField();
            emailInput.setPromptText("Email");
            emailInput.setAlignment(Pos.CENTER);
            GridPane.setConstraints(emailInput, 1, 3);

            grid.setAlignment(Pos.CENTER);
            grid.getChildren().addAll(firstNameLabel, firstNameInput, lastNameLabel, lastNameInput, phoneLabel, phoneInput, emailLabel, emailInput);
            return grid;
        }catch(Exception e){}
        return null;
    }

    public static HBox makeEmployeeInfo(){
        try{
            HBox employeeInfo = new HBox(20);

            //Employee ID Label
            Label employeeIDLabel = new Label("Employee ID:");

            //Employee ID Input
            employeeIDInput = new TextField();
            employeeIDInput.setPromptText("Employee ID");
            employeeIDInput.setAlignment(Pos.CENTER);
            employeeIDInput.textProperty().addListener((observable, oldValue, newValue) -> {
                if (!isNumeric(employeeIDInput.getText())) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("ERROR");
                    alert.setHeaderText(null);
                    alert.setContentText("Please enter numeric value.");
                    alert.showAndWait();
                    employeeIDInput.clear();
                }
            });

            employeeInfo.getChildren().addAll(employeeIDLabel, employeeIDInput);
            employeeInfo.setAlignment(Pos.CENTER);

            return employeeInfo;
        }catch (Exception e) {}
        return null;
    }

    public static void addOrderClicked(){
        // if there is no game selected or no quantity input, shows alert
        if (comboBox.getValue() == null || qInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please select game and quantity first.");
            alert.showAndWait();
            qInput.clear();
        }else {
            // Else, adds order to the VBox in the right side
            // The order is also added to an array of orders which will be written to the database when the sell button is clicked
            Label order = new Label("Game:            " + comboBox.getValue().toString() +
                    "\nPrice/game:    "    + game.getGame_price() +
                    "\nQuantity:         "  + qInput.getText() +
                    "\nTotal:              "   + actualPrice.getText() + " dkk");
            orderVBox.getChildren().add(order);
            order1 = new Order(game.getGame_ID(), Integer.parseInt(qInput.getText()), game.getGame_price(), Integer.parseInt(actualPrice.getText()));
            productList.add(order1);
            comboBox.setPromptText("Select Game...");
            qInput.clear();
            actualPrice.setText("");
        }
    }

    public static void sellClicked() throws Exception{
        //Checks if all fields are filled out
        //if not, shows alert
        if (comboBox.getValue() == null  || firstNameInput.getText().isEmpty()
                || lastNameInput.getText().isEmpty() || phoneInput.getText().isEmpty() || emailInput.getText().isEmpty()
                || employeeIDInput.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please fill out all fields.");
            alert.showAndWait();
            qInput.clear();
        } else {
            //else, it creates an order with the same receipt id, customer id, employee id, and different game ids, quantities, prices
            createReceipt();
            Label total = new Label("");
            int sum = 0;
            //Calculates total sum of an order
            for (int i = 0; i < productList.size(); i++){
                sum += productList.get(i).getGame_price() * productList.get(i).getGame_quantity();
            }
            total.setText("TOTAL PRICE: " + sum);
            orderVBox.getChildren().add(total);
        }
    }

    public static void createReceipt() throws Exception{
        int receipt_id = allReceipts.size();
        int customerid = handleCustomer();
        int employee_id = Integer.parseInt(employeeIDInput.getText());
        for(int i = 0; i < productList.size(); i++){
            Order order = new Order(0, receipt_id, customerid, employee_id, productList.get(i).getGame_id(), productList.get(i).getGame_quantity(),
                    productList.get(i).getGame_price(), productList.get(i).getTotal_price());
            OrderInfo.createOrder(order);
        }
        Receipt receipt = new Receipt(allReceipts.size() + 1);
        ReceiptInfo.createReceipt(receipt);
        allReceipts.add(receipt);
    }

    //if the telephone number is the same, then there is a previous customer and therefore it does not create another one
    public static int handleCustomer() throws Exception{
        List<Customer> cus = CustomerInfo.selectAllCustomers();
        customer_id = 0;
        for(int i = 0; i < cus.size(); i++){
            if(cus.get(i).getCustomer_phone() == Integer.parseInt(phoneInput.getText())) {
                customer_id = cus.get(i).getCustomer_id();
                break;
            }
        }
        if(customer_id == 0){ //if the telephone number doesn't match, then it creates a new customer and returns its id
            customer_id = cus.size() + 1;
            Customer customer = new Customer(customer_id, firstNameInput.getText(), lastNameInput.getText(),
                    Integer.parseInt(phoneInput.getText()), emailInput.getText());
            CustomerInfo.createCustomer(customer);
        }
        return customer_id;
    }

    public static void newOrderClicked() throws  Exception{
        qInput.clear();
        firstNameInput.clear();
        lastNameInput.clear();
        phoneInput.clear();
        emailInput.clear();
        employeeIDInput.clear();
        orderVBox.getChildren().clear();
        orderVBox.getChildren().add(orderTitle);
        for(int i = 0; i < productList.size(); i++){
            productList.remove(i);
        }

    }
}
