package testapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author pcosta
 */
//Imports are listed in full to show what's being used
//could just import javafx.*
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

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
        ChoiceBox fruits = new ChoiceBox(FXCollections.observableArrayList("Asparagus", "Beans", "Broccoli", "Cabbage"
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
        
        final ListView vegetables = new ListView(FXCollections.observableArrayList("Apple", "Apricot", "Banana"
         ,"Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));
        listPane.getChildren().add(listLbl);
        listPane.getChildren().add(vegetables);
        listPane.setVisible(false);
        
        componentLayout.setCenter(listPane);
        
        //The button uses an inner class to handle the button click event
        final Button vegFruitBut = new Button("Fruit or Veg");
        vegFruitBut.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                //switch the visibility for each FlowPane
                choicePane.setVisible(!choicePane.isVisible());
                listPane.setVisible(!listPane.isVisible());
            }
        });

        Button testWait = new Button("Wait Button");
        testWait.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vegFruitBut.setDisable(!vegFruitBut.isDisable());
                Timeline timer = new Timeline(
                        new KeyFrame(Duration.seconds(3), events -> vegFruitBut.setDisable(false))
                );
                timer.play();
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().addAll(vegFruitBut, testWait);
        
        componentLayout.setBottom(hBox);

        
        //Add the BorderPane to the Scene
        Scene appScene = new Scene(componentLayout,500,500);
        
        //Add the Scene to the Stage
        primaryStage.setScene(appScene);
        primaryStage.show();
    }
}
