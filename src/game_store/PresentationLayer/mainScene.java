package game_store.PresentationLayer;

import game_store.ApplicationLayer.dataTypes.Game;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.List;

// Main Scene. From here, you can:
       // View info about a game + picture
       // Search for a game by name or category
       // Review orders

public class mainScene {

    static List<Game> allGames;
    static Stage window;
    static Button buttonSellGames, buttonReviewOrder;
    static Game game;
    static TextField textFieldSearch;
    static HBox hBoxImage, hBoxButtons, hBoxSearch;
    static VBox vBoxMain;

    public static VBox makeMainScene(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Game Shop");

        Image image = new Image(mainScene.class.getResourceAsStream("Shop Logo.png"));
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(400);

        hBoxImage = new HBox();
        hBoxImage.getChildren().addAll(imageView);
        hBoxImage.setPadding(new Insets(10,10,10,10));
        hBoxImage.setAlignment(Pos.TOP_CENTER);

        //Fills array with all games
        allGames = Main.allGames;

        //Combobox with all games
        ComboBox<String> gamesBox = new ComboBox<>();
        gamesBox.setMaxWidth(160);
        gamesBox.setPromptText("View Game Info");
        gamesBox.setId("gamesBox");

        for(int i = 0; i < allGames.size(); i++) {              //adding games to the combobox
            gamesBox.getItems().add(allGames.get(i).getGame_title());
        }

        gamesBox.setOnAction(e -> {
            for(int i = 0; i < allGames.size(); i++){           //gets the game object when a game title is selected
                if (gamesBox.getValue().toString().equals(allGames.get(i).getGame_title()))
                    game = allGames.get(i);
            }
            gamesBoxClicked(gamesBox);});

        buttonSellGames = new Button("Sell Games");
        buttonSellGames.setMinWidth(160);
        buttonSellGames.setOnAction(e -> makeOrder.MakeOrderButtonClicked(primaryStage)); //goes to the orders scene

        buttonReviewOrder = new Button("Review Orders");
        buttonReviewOrder.setMinWidth(160);
        buttonReviewOrder.setOnAction(e -> reviewOrdersScene.makeReviewOrdersScene(primaryStage));

        textFieldSearch = new TextField();
        textFieldSearch.setMaxWidth(350);
        textFieldSearch.setMinWidth(350);
        textFieldSearch.setPromptText("Search");
        textFieldSearch.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER) {
                searchScene.makeSearchScene(primaryStage, textFieldSearch.getText());
                textFieldSearch.clear();
            }
        });

        Button search = new Button("Search");
        search.setOnAction(e -> searchScene.makeSearchScene(primaryStage, textFieldSearch.getText()));

        //boxes
        hBoxSearch = new HBox(20);
        hBoxSearch.setPadding(new Insets(50,10,10,10));
        hBoxSearch.setAlignment(Pos.CENTER);
        hBoxSearch.getChildren().addAll(textFieldSearch, search);

        hBoxButtons = new HBox(50);
        hBoxButtons.setPadding(new Insets(10,10,10,10));
        hBoxButtons.setAlignment(Pos.CENTER);
        hBoxButtons.getChildren().addAll(gamesBox, buttonSellGames, buttonReviewOrder);

        vBoxMain = new VBox();
        vBoxMain.setPadding(new Insets(10,10,10,10));
        vBoxMain.getChildren().addAll(hBoxImage, hBoxButtons, hBoxSearch);

        return vBoxMain;
    }

    //Displays selected game with info
    public static void gamesBoxClicked(ComboBox<String> gamesBox) {
        Stage gamesStage = new Stage();

        gamesStage.setTitle("Game info");

        String title = "";
        title = gamesBox.getSelectionModel().getSelectedItem();

        //Gets image of selected game
        Image image = new Image(mainScene.class.getResourceAsStream(title + ".jpg")); // to avoid writing code for all games
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        imageView.setPreserveRatio(true);
        imageView.setFitWidth(200);

        //Labels for all info of the game
        Label labelTitle = new Label("Title: " + game.getGame_title());
        Label labelPlatform = new Label("Platform: " + game.getGame_platform());
        Label labelPrice = new Label("Price: " + game.getGame_price());
        Label labelGenre = new Label("Genre: " + game.getGame_genre());
        Label labelRelease = new Label("Release Date: " + game.getGame_release_date());
        Label labelAge = new Label("Age: " + game.getGame_age());
        Label labelSysReq = new Label("System Requirements: " + game.getGame_sys_req());

        VBox vBoxLabelInfo = new VBox(10);
        vBoxLabelInfo.setPadding(new Insets(10,10,10,10));
        vBoxLabelInfo.getChildren().addAll(labelTitle, labelPlatform, labelPrice, labelGenre, labelRelease, labelAge, labelSysReq);

        HBox hBox = new HBox();

        hBox.getChildren().addAll(imageView, vBoxLabelInfo);

        Scene gamesDisplayScene = new Scene(hBox, 500, 300);
        gamesDisplayScene.getStylesheets().add("GamesInfoCSS.css");
        gamesStage.setScene(gamesDisplayScene);
        gamesStage.show();
    }
}
