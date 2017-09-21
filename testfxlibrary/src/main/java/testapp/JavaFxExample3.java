package testapp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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


        final Button button1 = new Button("Button1");
        final Button button2 = new Button("Button2");
        final Button button3 = new Button("Button3");

        button1.setId("button");
        button2.setId("button");
        button3.setId("button");

        hBox.getChildren().addAll(button1, button2, button3);

        p.getChildren().addAll(hBox);
        primaryStage.setScene(new Scene(p));
        primaryStage.show();

    }
}
