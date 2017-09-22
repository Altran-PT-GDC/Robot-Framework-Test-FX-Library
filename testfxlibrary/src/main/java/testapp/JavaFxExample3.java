package testapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class JavaFxExample3 extends Application {

    public static class HBoxCell extends HBox {
        Label label = new Label();
        Hyperlink hyperlink = new Hyperlink();

        HBoxCell(String labelText, String buttonText) {
            super();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            hyperlink.setText(buttonText);

            this.getChildren().addAll(label, hyperlink);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane p = new Pane();
        p.setPrefSize(800, 600);

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        Button btnAdd1 = new Button("Button 1");
        Button btnDelete1 = new Button("Button 2");
        Button btnMoveUp1 = new Button("Button 3");
        Button btnMoveDown1 = new Button("Button 4");

        btnAdd1.setMaxWidth(Double.MAX_VALUE);
        btnDelete1.setMaxWidth(Double.MAX_VALUE);
        btnMoveUp1.setMaxWidth(Double.MAX_VALUE);
        btnMoveDown1.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons1 = new VBox();
        vbButtons1.setSpacing(10);
        vbButtons1.setPadding(new Insets(10, 20, 10, 20));
        vbButtons1.getChildren().addAll(btnAdd1, btnDelete1, btnMoveUp1, btnMoveDown1);

        Button btnAdd2 = new Button("Button 1");
        Button btnDelete2 = new Button("Button 2");
        Button btnMoveUp2 = new Button("Button 3");
        Button btnMoveDown2 = new Button("Button 4");

        btnAdd2.setMaxWidth(Double.MAX_VALUE);
        btnDelete2.setMaxWidth(Double.MAX_VALUE);
        btnMoveUp2.setMaxWidth(Double.MAX_VALUE);
        btnMoveDown2.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons2 = new VBox();
        vbButtons2.setSpacing(10);
        vbButtons2.setPadding(new Insets(10, 20, 10, 20));
        vbButtons2.getChildren().addAll(btnAdd2, btnDelete2, btnMoveUp2, btnMoveDown2);

        HBox hBox1 = new HBox();
        HBox hBoxButtons = new HBox();
        hBoxButtons.setPadding(new Insets(10, 20, 10, 50));
        Label labelButtons = new Label("Different parent ID's:");
        labelButtons.setFont(Font.font(null, FontWeight.BOLD, 12));
        hBoxButtons.getChildren().addAll(labelButtons);

        hBox1.getChildren().addAll(vbButtons1, vbButtons2);

        VBox vBox1 = new VBox();
        vBox1.getChildren().addAll(hBoxButtons, hBox1);

        vbButtons1.setId("vbuttons1");
        vbButtons2.setId("vbuttons2");

        Button btnAdd3 = new Button("Button 1");
        Button btnDelete3 = new Button("Button 2");
        Button btnMoveUp3 = new Button("Button 3");
        Button btnMoveDown3 = new Button("Button 4");

        btnAdd3.setMaxWidth(Double.MAX_VALUE);
        btnDelete3.setMaxWidth(Double.MAX_VALUE);
        btnMoveUp3.setMaxWidth(Double.MAX_VALUE);
        btnMoveDown3.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons3 = new VBox();
        vbButtons3.setId("vbuttons1");
        Label labelButtons2 = new Label("Same parent ID 1st Column:");
        labelButtons2.setFont(Font.font(null, FontWeight.BOLD, 12));
        vbButtons3.setSpacing(10);
        vbButtons3.setPadding(new Insets(10, 20, 10, 220));
        vbButtons3.getChildren().addAll(labelButtons2, btnAdd3, btnDelete3, btnMoveUp3, btnMoveDown3);

        ObservableList<String> observableList1 =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3",
                        "Option 4",
                        "Option 5"
                );
        final ComboBox comboBox1 = new ComboBox(observableList1);

        ObservableList<String> observableList2 =
                FXCollections.observableArrayList(
                        "Option 1",
                        "Option 2",
                        "Option 3",
                        "Option 4",
                        "Option 5"
                );
        final ComboBox comboBox2 = new ComboBox(observableList2);

        HBox hBox2 = new HBox();
        HBox hBox3 = new HBox();
        VBox vBox2 = new VBox();
        Label label1 = new Label();
        label1.setText("Comboboxes with same items and same parents:");
        label1.setFont(Font.font(null, FontWeight.BOLD, 12));
        vBox2.getChildren().addAll(hBox3, hBox2);
        vBox2.setSpacing(10);
        hBox2.setSpacing(10);
        vBox2.setPadding(new Insets(10,20,10,420));
        hBox2.getChildren().addAll(comboBox1, comboBox2);
        hBox3.getChildren().addAll(label1);

        VBox vBox3 = new VBox();
        vBox3.setPadding(new Insets(200,20,10,20));

        ListView<HBoxCell> listView1 = new ListView<HBoxCell>();
        Label labelListView = new Label("Multiple Selection List View:");
        labelListView.setFont(Font.font(null, FontWeight.BOLD, 12));
        listView1.setMaxHeight(200);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<HBoxCell> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new HBoxCell("Item " + i, "Add Interpretation"));
        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView1.setItems(myObservableList);

        vBox3.getChildren().addAll(labelListView, listView1);

        p.getChildren().addAll(vBox1, vbButtons3, vBox2, vBox3);
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}