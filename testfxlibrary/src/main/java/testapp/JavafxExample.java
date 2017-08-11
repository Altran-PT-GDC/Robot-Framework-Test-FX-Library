package testapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author pcosta
 */
public class JavafxExample extends Application {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    
    private static class CounterPane extends StackPane {
        public CounterPane() {
            // create countButton.
            Button countButton = new Button("count");
            countButton.setId("countButton");

            Button btnDisable = new Button("Disable");
            btnDisable.setId("btnDisable");
            btnDisable.setDisable(true);

            // create countValue.
            final TextField countValue = new TextField("0");
            countValue.setId("countValue");

            // initialize controls.
            countButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent e) {
                int value = asInteger(countValue.getText());
                int incrementedValue = value + 1;
                countValue.setText(asString(incrementedValue));
            }
        });
            countValue.setEditable(false);
            countValue.setPrefWidth(50);

            // create and add containers.
            HBox box = new HBox(10, countButton, countValue, btnDisable);
            box.setPadding(new Insets(10));
            box.setAlignment(Pos.CENTER);
            getChildren().add(box);
        }
        
        
    }
    
    

    private static int asInteger(String value) { return Integer.parseInt(value); }
    private static String asString(int value) { return value + ""; }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new CounterPane(), 200, 50));
        stage.show();
    }

    
}
