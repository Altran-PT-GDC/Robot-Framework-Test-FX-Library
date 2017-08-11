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
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author pcosta
 */

public class JavafxExample2 extends Application {

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
        BorderPane componentLayout = new BorderPane();
        componentLayout.setPadding(new Insets(20,0,20,20));
        
        //The FlowPane is a conatiner that uses a flow layout
        final FlowPane choicePane = new FlowPane();
        choicePane.setHgap(100);
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
        listPane.setHgap(100);
        Label listLbl = new Label("Vegetables");
        
        final ListView<String> vegetables = new ListView<>(FXCollections.observableArrayList("Apple", "Apricot", "Banana"
         ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));
        listPane.getChildren().add(listLbl);
        listPane.getChildren().add(vegetables);
        listPane.setVisible(false);

        final TextField name = new TextField();
        name.setText("Diogo");

        final ObservableList<String> oList = FXCollections.observableArrayList("um", "dois", "tres", "quatro", "cinco", "seis", "sete");

        final ListView<String> listView = new ListView<>();
        listView.setItems(oList);

        final VBox vBox = new VBox();
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setMaxHeight(200);
        scrollPane.setMaxWidth(100);
        vBox.getChildren().addAll(name, listView);
        scrollPane.setContent(vBox);

        componentLayout.setCenter(listPane);
        componentLayout.setRight(scrollPane);
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
                    new KeyFrame(Duration.seconds(3), events -> vegFruitBut.setDisable(false))
            );
            timer.play();
        });


        final TextField text = new TextField("OLA TEST");
        text.setId("text");




        HBox hBox = new HBox();
        hBox.getChildren().addAll(vegFruitBut, testWait, text);
        
        componentLayout.setBottom(hBox);

        
        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout,500,500);
        
        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }
}
