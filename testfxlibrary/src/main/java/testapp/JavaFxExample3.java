package testapp;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    public void start(Stage primaryStage) throws InterruptedException {
        Pane p = new Pane();
        p.setPrefSize(800, 600);

        VBox vBoxMaster = new VBox();
        HBox hBoxMaster1 = new HBox();
        HBox hBoxMaster2 = new HBox();
        p.getChildren().addAll(vBoxMaster);
        vBoxMaster.getChildren().addAll(hBoxMaster1, hBoxMaster2);
        vBoxMaster.setPadding(new Insets(10,10,10,10));
        hBoxMaster1.setPadding(new Insets(10,10,10,10));
        hBoxMaster2.setPadding(new Insets(10,10,10,10));
        vBoxMaster.autosize();

        BorderPane border = new BorderPane();
        border.setPadding(new Insets(20, 0, 20, 20));

        Button btn1 = new Button("Button 1");
        Button btn2 = new Button("Button 2");
        Button btn3 = new Button("Button 3");
        Button btn4 = new Button("Button 4");

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons1 = new VBox();
        vbButtons1.setSpacing(10);
        vbButtons1.getChildren().addAll(btn1, btn2, btn3, btn4);

        Button btn5 = new Button("Button 1");
        Button btn6 = new Button("Button 2");
        Button btn7 = new Button("Button 3");
        Button btn8 = new Button("Button 4");

        btn5.setMaxWidth(Double.MAX_VALUE);
        btn6.setMaxWidth(Double.MAX_VALUE);
        btn7.setMaxWidth(Double.MAX_VALUE);
        btn8.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons2 = new VBox();
        vbButtons2.setSpacing(10);
        vbButtons2.getChildren().addAll(btn5, btn6, btn7, btn8);

        HBox hBox1 = new HBox();
        HBox hBoxButtons = new HBox();
        Label labelButtons = new Label("Different parent ID's:");
        labelButtons.setFont(Font.font(null, FontWeight.BOLD, 12));
        hBoxButtons.getChildren().addAll(labelButtons);

        hBox1.getChildren().addAll(vbButtons1, vbButtons2);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(10);
        vBox1.getChildren().addAll(hBoxButtons, hBox1);

        vbButtons1.setId("vbuttons1");
        vbButtons2.setId("vbuttons2");

        Button btn9 = new Button("Button 1");
        Button btn10 = new Button("Button 2");
        Button btn11 = new Button("Button 3");
        Button btn12 = new Button("Button 4");

        btn9.setMaxWidth(Double.MAX_VALUE);
        btn10.setMaxWidth(Double.MAX_VALUE);
        btn11.setMaxWidth(Double.MAX_VALUE);
        btn12.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons3 = new VBox();
        vbButtons3.setId("vbuttons1");
        Label labelButtons2 = new Label("Same parent ID 1st Column:");
        labelButtons2.setFont(Font.font(null, FontWeight.BOLD, 12));
        vbButtons3.setSpacing(10);
        //vbButtons3.setPadding(new Insets(10, 20, 10, 220));
        vbButtons3.getChildren().addAll(labelButtons2, btn9, btn10, btn11, btn12);

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
        HBox hBoxCombo1 = new HBox();
        HBox hBoxCombo2 = new HBox();
        VBox vBoxCombo = new VBox();
        vBoxCombo.setId("vboxcombo");
        Label labelCombo = new Label();
        labelCombo.setText("Comboboxes with same items and same parents:");
        labelCombo.setFont(Font.font(null, FontWeight.BOLD, 12));

        Button buttonNewWindow = new Button("Open New Window");
        buttonNewWindow.setId("btnwindow");
        buttonNewWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane p2 = new Pane();
                p2.setPrefSize(50, 50);
                Scene scene2 = new Scene(p2);
                Stage secondaryStage = new Stage();
                secondaryStage.setScene(scene2);
                secondaryStage.setTitle("New Window For Test");
                secondaryStage.show();
            }
        });

        Button buttonNewWindow2 = new Button("Open New Window V2");
        buttonNewWindow2.setId("btnwindow2");
        buttonNewWindow2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane p3 = new Pane();
                p3.setPrefSize(50, 50);
                Scene scene3 = new Scene(p3);
                Stage thirdStage = new Stage();
                thirdStage.setScene(scene3);
                thirdStage.setTitle("New Window For Test V2");
                thirdStage.show();
            }
        });

        vBoxCombo.getChildren().addAll(hBoxCombo2, hBoxCombo1, buttonNewWindow, buttonNewWindow2);
        vBoxCombo.setSpacing(10);
        hBoxCombo1.setSpacing(10);
        hBoxCombo1.getChildren().addAll(comboBox1, comboBox2);
        hBoxCombo2.getChildren().addAll(labelCombo);

        VBox vBoxListView = new VBox();
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

        HBox hBoxTables = new HBox();
        hBoxTables.setId("hboxtables");
        VBox vBoxTables = new VBox();
        hBoxTables.getChildren().add(vBoxTables);

        TableRow tableRow1 = new TableRow();
        final ObservableList<Person> data =
                FXCollections.observableArrayList(
                        new Person("Jacob", "Smith", "jacob.smith@example.com"),
                        new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new Person("Ethan", "Williams", "ethan.williams@example.com"),
                        new Person("Emma", "Jones", "emma.jones@example.com"),
                        new Person("Michael", "Brown", "michael.brown@example.com")
                );
        final ObservableList<Person> data2 =
                FXCollections.observableArrayList(
                        new Person("Jacob", "Smith", "jacob.smith@example.com"),
                        new Person("Isabella", "Johnson", "isabella.johnson@example.com"),
                        new Person("Ethan", "Williams", "ethan.williams@example.com"),
                        new Person("Emma", "Jones", "emma.jones@example.com"),
                        new Person("Michael", "Brown", "michael.brown@example.com")
                );
        TableView<Person> tableView1 = new TableView<Person>();
        TableView<Person> tableView2 = new TableView<Person>();
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("email")
        );
        TableColumn firstNameCol2 = new TableColumn("First Name");
        firstNameCol2.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        TableColumn lastNameCol2 = new TableColumn("Last Name");
        lastNameCol2.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );
        TableColumn emailCol2 = new TableColumn("Email");
        emailCol2.setMinWidth(200);
        emailCol2.setCellValueFactory(
                new PropertyValueFactory<Person,String>("email")
        );
        tableView1.getSelectionModel().setCellSelectionEnabled(true);
        tableView2.getSelectionModel().setCellSelectionEnabled(true);

        tableView1.setItems(data);
        tableView1.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        tableView2.setItems(data2);
        tableView2.getColumns().addAll(firstNameCol2, lastNameCol2, emailCol2);
        tableView1.setPrefSize(370, 170);
        tableView2.setPrefSize(370, 170);
        vBoxTables.getChildren().addAll(tableView1, tableView2);
        vBoxListView.getChildren().addAll(labelListView, listView1);

        vBox1.setPadding(new Insets(10,10,10,10));
        vbButtons3.setPadding(new Insets(10,10,10,10));
        vBoxCombo.setPadding(new Insets(10,10,10,10));
        vBoxListView.setPadding(new Insets(10,10,10,10));
        hBoxTables.setPadding(new Insets(10,10,10,10));

        hBoxMaster1.getChildren().addAll(vBox1, vbButtons3, vBoxCombo);
        hBoxMaster2.getChildren().addAll(vBoxListView, hBoxTables);
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Example Application 3");
        primaryStage.show();
    }
}
