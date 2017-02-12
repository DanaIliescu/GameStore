package game_store.PresentationLayer;

import game_store.ApplicationLayer.dataTypes.Employee;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//Log in scene for employees

public class LogInScene
{
    static private GridPane logInPane;
    static private TextField employeeNameInput;
    static private PasswordField employeePWInput;
    static private Label logInMessage;
    static private Button logInButton;
    static private ImageView imageView_logo;

    public static VBox makeLogInScene_logo(Stage primaryStage)
    {
        logInPane = makeLogInScene(primaryStage); //creates login scene
        imageView_logo = makeLogo();

        VBox logInScene_pic = new VBox(10);
        logInScene_pic.getChildren().addAll(imageView_logo, logInPane);
        logInScene_pic.setAlignment(Pos.CENTER);

        return logInScene_pic;
    }

    public static GridPane makeLogInScene(Stage primaryStage)
    {
        logInPane = new GridPane();
        logInPane.setMinWidth(250);
        logInPane.setMinHeight(200);
        logInPane.setHgap(10);
        logInPane.setVgap(10);

        Label employeeName_label = new Label("Username");
        employeeNameInput = new TextField();
        Label password = new Label("Password");
        employeePWInput = new PasswordField();
        employeePWInput.setOnKeyPressed(e -> { // when you press enter, it checks input for username and password
            if(e.getCode() == KeyCode.ENTER) {
                setLogInButtonAction(primaryStage);
            }
        });
        logInMessage = new Label();
        logInButton = new Button("Log in");
        logInButton.setOnAction(e -> setLogInButtonAction(primaryStage));

        logInPane.add(employeeName_label, 0, 0);
        logInPane.add(employeeNameInput, 1, 0);
        logInPane.add(password, 0, 1);
        logInPane.add(employeePWInput, 1, 1);
        logInPane.add(logInButton, 1, 2);
        logInPane.add(logInMessage, 1, 3, 2, 3);

        logInPane.setAlignment(Pos.CENTER);

        return logInPane;
    }

    public static void setLogInButtonAction(Stage primaryStage) // checks if username and password of employees are correct
    {
        {
            String checkName = employeeNameInput.getText().toString();
            String checkPassword = employeePWInput.getText().toString();
            try
            {
                int employeesSize = Main.allEmployees.size();

                for(int i = 0; i < employeesSize; i++)
                {
                    Employee employee = Main.allEmployees.get(i);
                    String employeeNameInput = employee.getEmployee_first_name() + " "
                            + employee.getEmployee_last_name();
                    String employeePW = employee.getEmployee_password();

                    // if yes, it creates the main scene
                    if (checkPassword.equalsIgnoreCase(employeePW) && checkName.equalsIgnoreCase(employeeNameInput))
                    {
                        VBox layout = mainScene.makeMainScene(primaryStage);
                        Scene scene = new Scene(layout, 800, 600);
                        scene.getStylesheets().add("CSS.css");
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        break;
                    }
                    // else, it displays message
                    else
                    {
                        logInMessage.setText("Sorry, user does not exist.");
                    }
                }
            } catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }
    }

    public static ImageView makeLogo()  // the logo
    {
        Image logoImage = new Image(LogInScene.class.getResourceAsStream("Shop Logo.png"));
        logoImage.getClass().getResourceAsStream("Shop Logo.png");
        ImageView imageView_logo = new ImageView(logoImage);
        imageView_logo.setFitWidth(250);
        imageView_logo.setPreserveRatio(true);
        imageView_logo.setSmooth(true);
        return imageView_logo;
    }
}
