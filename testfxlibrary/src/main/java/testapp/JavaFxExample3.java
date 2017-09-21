package testapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;



public class JavaFxExample3 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane p = new Pane();
        p.setPrefSize(300, 400);

        HBox hBox = new HBox();

        VBox vBox = new VBox();
        vBox.setId("vbox1");
        vBox.getChildren().add(hBox);

        final Button button1 = new Button("Button");
        final Button button2 = new Button("Button");
        final Button button3 = new Button("Button");

        button3.setStyle("-fx-base: #b6e7c9;");

        Pane pane = new Pane();
        pane.getChildren().add(button2);

        hBox.getChildren().addAll(button1, pane, button3);

        p.getChildren().addAll(hBox);
        primaryStage.setScene(new Scene(p));
        primaryStage.show();

    }
}