import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.text.ParseException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Table");
        primaryStage.setScene(new Scene(root, 600, 450));
        primaryStage.show();
    }


    public static void main(String[] args) throws ParseException {


        launch(args);
    }
}
