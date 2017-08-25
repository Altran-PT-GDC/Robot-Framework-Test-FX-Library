package testapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author pcosta
 */
public class JavafxExample extends Application {

    private static final int HBOX_INSETS = 10;
    private static final int HBOX_SPACING = 10;
    private static final int COUNTERPANE_WIDTH = 200;
    private static final int COUNTERPANE_HEIGHT = 50;
    private static final int TEXTFIELD_PREF_WIDTH = 50;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setScene(new Scene(new CounterPane(stage), COUNTERPANE_WIDTH, COUNTERPANE_HEIGHT));
        stage.show();
    }
    

    private static class CounterPane extends StackPane {
        private Stage stage;
        FileChooser ch = new FileChooser();

        public CounterPane(Stage stage) {
            this.stage = stage;
            setId("counterPane");
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
                @Override
                public void handle(ActionEvent e) {
                    int value = asInteger(countValue.getText());
                    int incrementedValue = value + 1;
                    countValue.setText(asString(incrementedValue));
                }
            });
            countValue.setEditable(false);
            countValue.setPrefWidth(TEXTFIELD_PREF_WIDTH);

            Button chooser = new Button("Chooser");
            chooser.setId("chooser");
            chooser.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    showFileChooser();


                }
            });

            // create and add containers.
            HBox box = new HBox(HBOX_SPACING, countButton, countValue, btnDisable, chooser);
            box.setPadding(new Insets(HBOX_INSETS));
            box.setAlignment(Pos.CENTER);
            getChildren().add(box);
        }

        private void showFileChooser(){
            ch.setTitle("File Chooser");
            ch.showOpenDialog(stage);
        }
        
    }
    

    private static int asInteger(String value) { return Integer.parseInt(value); }
    private static String asString(int value) { return value + ""; }

}
