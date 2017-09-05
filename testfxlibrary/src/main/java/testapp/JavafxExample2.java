package testapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Imports are listed in full to show what's being used
//could just import javafx.*

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @author pcosta
 */

public class JavafxExample2 extends Application {
    private BorderPane componentLayout;
    private HBox hBox;
    private Button toBeErase;
    private static final int TEXT_FIELD_MAX_WIDTH = 80;
    private static final int TEXT_FIELD_MAX_HIGHT = 50;
    private static final int SCROLLPANE_MAX_WIDTH = 100;
    private static final int SCROLLPANE_MAX_HIGHT = 200;
    private static final int SCENE_WIDTH = 500;
    private static final int SCENE_HIGHT = 500;
    private static final int BORDERPANE_INSETS_TOP = 20;
    private static final int BORDERPANE_INSETS_BOTTOM = 20;
    private static final int BORDERPANE_INSETS_LEFT = 20;
    private static final int BORDERPANE_INSETS_RIGHT = 0;
    private static final int FLOWPANE_HGAP = 100;
    private static final int WAIT_TIME = 5;

    //JavaFX applicatoin still use the main method.
    //It should only ever contain the call to the launch method
    public static void main(String[] args) {
        launch(args);


    }

    //starting point for the application
    //this is where we put the code for the user interface
    @Override
    public void start(Stage primaryStage) {

        //The primaryStage is the top-level container
        primaryStage.setTitle("example Gui");

        //The BorderPane has the same areas laid out as the
        //BorderLayout layout manager
        componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(BORDERPANE_INSETS_TOP, BORDERPANE_INSETS_RIGHT,BORDERPANE_INSETS_BOTTOM, BORDERPANE_INSETS_LEFT));

        //The FlowPane is a conatiner that uses a flow layout
        final FlowPane choicePane = new FlowPane();
        choicePane.setHgap(FLOWPANE_HGAP);
        Label choiceLbl = new Label("Fruits");

        //The choicebox is populated from an observableArrayList
        ChoiceBox<String> fruits = new ChoiceBox<>(FXCollections.observableArrayList("Asparagus", "Beans", "Broccoli", "Cabbage"
                , "Carrot", "Celery", "Cucumber", "Leek", "Mushroom"
                , "Pepper", "Radish", "Shallot", "Spinach", "Swede"
                , "Turnip"));


        //Add the label and choicebox to the flowpane
        choicePane.getChildren().add(choiceLbl);
        choicePane.getChildren().add(fruits);

        //put the flowpane in the top area of the BorderPane
        componentLayout.setTop(choicePane);

        final FlowPane listPane = new FlowPane();
        listPane.setHgap(FLOWPANE_HGAP);
        Label listLbl = new Label("Vegetables");

        final ListView<String> vegetables = new ListView<>(FXCollections.observableArrayList("Apple", "Apricot", "Banana"
                , "Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));
        listPane.getChildren().add(listLbl);
        listPane.getChildren().add(vegetables);
        listPane.setVisible(false);

        final TextField name = new TextField();
        name.setText("Diogo");

        final ObservableList<String> oList = FXCollections.observableArrayList("one", "two", "three", "four", "five", "Six", "Seven");

        final ListView<String> listView = new ListView<>();
        listView.setId("listView");
        listView.setItems(oList);

        final VBox rightVbox = new VBox();
        final VBox vBox = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxHeight(SCROLLPANE_MAX_HIGHT);
        scrollPane.setMaxWidth(SCROLLPANE_MAX_WIDTH);
        vBox.getChildren().addAll(name, listView);
        scrollPane.setContent(vBox);

        final CheckBox check = new CheckBox("Check Here");
        check.setId("check");
        check.setVisible(true);

        final Label label = new Label("Label to test");
        label.setId("label");

        rightVbox.getChildren().addAll(scrollPane, check, label);

        componentLayout.setCenter(listPane);
        componentLayout.setRight(rightVbox);
        //The button uses an inner class to handle the button click event
        final Button vegFruitBut = new Button("Fruit or Veg");
        vegFruitBut.setOnAction(event -> {
            //switch the visibility for each FlowPane
            choicePane.setVisible(!choicePane.isVisible());
            listPane.setVisible(!listPane.isVisible());
        });

        Button testWait = new Button("Wait Button");
        testWait.setOnAction(event -> {
            vegFruitBut.setDisable(!vegFruitBut.isDisable());
            Timeline timer = new Timeline(
                    new KeyFrame(Duration.seconds(WAIT_TIME), events -> changeElementForWait(vegFruitBut, false))
            );
            timer.play();
        });


        final TextField text = new TextField("OLA TEST");
        text.setId("text");

        final TextArea textArea = new TextArea("PARA APAGAR");
        textArea.setId("textArea");
        textArea.setMaxWidth(TEXT_FIELD_MAX_WIDTH);
        textArea.setMaxHeight(TEXT_FIELD_MAX_HIGHT);
        textArea.setWrapText(true);

        toBeErase = new Button("To Be Erase");
        toBeErase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.showOpenDialog(primaryStage);
            }
        });


        hBox = new HBox();
        hBox.getChildren().addAll(vegFruitBut, testWait, text, textArea, toBeErase);

        componentLayout.setBottom(hBox);


        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout, SCENE_WIDTH, SCENE_HIGHT);

        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }

    private void changeElementForWait(Button vegFruitBut, boolean value) {
        vegFruitBut.setDisable(value);
        componentLayout.setCenter(new Label("test"));
        hBox.getChildren().remove(toBeErase);


    }
}
