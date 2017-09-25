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

        HBox hBox1 = new HBox();
        hBox1.setId("hbox1");

        VBox vBox = new VBox();
        vBox.setId("vbox1");


        final Button button1 = new Button("Button1");
        final Button button2 = new Button("Button2");
        final Button button3 = new Button("Button3");
        final Button button7 = new Button("Button2");

        button3.setStyle("-fx-base: #b6e7c9;");

        Pane pane = new Pane();
        pane.setId("pane1");
        pane.getChildren().add(button2);

        hBox1.getChildren().addAll(button1, pane, button3, button7);

        HBox hBox2 = new HBox();
        VBox vBox2 = new VBox();
        vBox.setId("vbox2");
        hBox2.setId("hbox2");
        //hBox2.set
        vBox.getChildren().addAll(hBox1, hBox2);
        //vBox.getChildren().add(hBox2);

        final Button button4 = new Button("Button1");
        final Button button5 = new Button("Button2");
        final Button button6 = new Button("Button3");

        hBox2.getChildren().addAll(button4, button5, button6);

        p.getChildren().addAll(vBox);
        primaryStage.setScene(new Scene(p));
        primaryStage.show();

    }
}
