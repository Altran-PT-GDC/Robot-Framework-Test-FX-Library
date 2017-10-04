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
import javafx.scene.paint.Paint;
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
    private static final int SPINNER_DEFAULT_VALUE = 100;

    //JavaFX applicatoin still use the main method.
    //It should only ever contain the call to the launch method
    public static void main(String[] args) {
        launch(args);


    }

    //starting point for the application
    //this is where we put the code for the user interface
    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("example Gui");

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

        HBox a = new HBox();
        a.getChildren().add(new Label("First"));

        HBox b = new HBox();
        b.getChildren().add(new Label("Secund"));

        HBox c = new HBox();
        c.getChildren().add(new Label("Third"));

        Spinner spinner = new Spinner();
        SpinnerValueFactory<Integer> value = new SpinnerValueFactory<Integer>() {
            @Override
            public void decrement(int steps) {
                spinner.getValueFactory ().setValue((int)spinner.getValueFactory().getValue() + steps);
            }

            @Override
            public void increment(int steps) {
                spinner.getValueFactory ().setValue((int)spinner.getValueFactory().getValue() - steps);
            }
        };
        value.setValue(SPINNER_DEFAULT_VALUE);
        spinner.setValueFactory(value);
        spinner.setId("spinner");


        ComboBox cb = new ComboBox();
        cb.setId("cb");

        cb.getItems().addAll(a,b,c);
        Pane p = new Pane();
        p.setId("PANE_COMBO");
        p.setBackground(new Background(new BackgroundFill(Paint.valueOf("black"), CornerRadii.EMPTY,Insets.EMPTY)));
        cb.getItems().add(p);

        //Add the label and choicebox to the flowpane
        choicePane.getChildren().add(choiceLbl);
        choicePane.getChildren().add(fruits);
        choicePane.getChildren().add(cb);
        choicePane.getChildren().add(spinner);

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
        vegetables.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        final TextField name = new TextField();
        name.setText("Diogo");

        final ObservableList<String> oList = FXCollections.observableArrayList("one", "two", "three", "four", "five", "Six", "Seven");

        final ListView<String> listView = new ListView<>();
        listView.setId("listView");
        listView.setItems(oList);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        final VBox rightVbox = new VBox();
        final VBox vBox = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxHeight(SCROLLPANE_MAX_HIGHT);
        scrollPane.setMaxWidth(SCROLLPANE_MAX_WIDTH);
        vBox.getChildren().addAll(name, listView);
        scrollPane.setContent(vBox);
        scrollPane.setId("scrollPane");

        final CheckBox check = new CheckBox();
        final CheckBox check2 = new CheckBox();
        check.setId("check");
        check.setVisible(true);
        check2.setId("disabledCheckbox");
        check2.setDisable(true);

        final Label label = new Label("Label to test");
        label.setId("label");

        rightVbox.getChildren().addAll(scrollPane, check, check2, label);

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
