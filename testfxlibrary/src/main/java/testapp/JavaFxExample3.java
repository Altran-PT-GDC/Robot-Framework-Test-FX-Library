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

    private static final String FIRST_BUTTON_TEXT = new String("Button 1");
    private static final String SECOND_BUTTON_TEXT = new String("Button 2");
    private static final String THIRD_BUTTON_TEXT = new String("Button 3");
    private static final String FOURTH_BUTTON_TEXT = new String("Button 4");
    private static  final int DEFAULT_SPACING = 10;
    private static  final int TOP_PADDING = 10;
    private static  final int RIGHT_PADDING = 10;
    private static  final int BOTTOM_PADDING = 10;
    private static  final int LEFT_PADDING = 10;
    private static  final int MAIN_PANE_WIDTH = 800;
    private static  final int MAIN_PANE_HEIGHT = 600;
    private static  final int SEC_PANE_WIDTH = 50;
    private static  final int SEC_PANE_HEIGHT = 50;
    private static  final int TABLE_WIDTH = 370;
    private static  final int TABLE_HEIGHT = 170;
    private static  final int LIST_VIEW_MAX_HEIGHT = 200;
    private static  final int DEFAULT_FONT_SIZE = 12;
    private static  final int LIST_ITEMS = 10;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        //Set main pane
        Pane p = new Pane();
        p.setPrefSize(MAIN_PANE_WIDTH, MAIN_PANE_HEIGHT);

        //Set master VBox and HBox
        VBox vBoxMaster = new VBox();
        HBox hBoxMaster1 = new HBox();
        HBox hBoxMaster2 = new HBox();
        p.getChildren().addAll(vBoxMaster);
        vBoxMaster.getChildren().addAll(hBoxMaster1, hBoxMaster2);
        vBoxMaster.autosize();

        BorderPane border = new BorderPane();

        //Buttons with same text
        Button btn1 = new Button(FIRST_BUTTON_TEXT);
        Button btn2 = new Button(SECOND_BUTTON_TEXT);
        Button btn3 = new Button(THIRD_BUTTON_TEXT);
        Button btn4 = new Button(FOURTH_BUTTON_TEXT);

        btn1.setMaxWidth(Double.MAX_VALUE);
        btn2.setMaxWidth(Double.MAX_VALUE);
        btn3.setMaxWidth(Double.MAX_VALUE);
        btn4.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons1 = new VBox();
        vbButtons1.setSpacing(DEFAULT_SPACING);
        vbButtons1.getChildren().addAll(btn1, btn2, btn3, btn4);

        Button btn5 = new Button(FIRST_BUTTON_TEXT);
        Button btn6 = new Button(SECOND_BUTTON_TEXT);
        Button btn7 = new Button(THIRD_BUTTON_TEXT);
        Button btn8 = new Button(FOURTH_BUTTON_TEXT);

        btn5.setMaxWidth(Double.MAX_VALUE);
        btn6.setMaxWidth(Double.MAX_VALUE);
        btn7.setMaxWidth(Double.MAX_VALUE);
        btn8.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons2 = new VBox();
        vbButtons2.setSpacing(DEFAULT_SPACING);
        vbButtons2.getChildren().addAll(btn5, btn6, btn7, btn8);

        //Buttons with different parent IDs
        HBox hBox1 = new HBox();
        HBox hBoxButtons = new HBox();
        Label labelButtons = new Label("Different parent ID's:");
        labelButtons.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        hBoxButtons.getChildren().addAll(labelButtons);

        hBox1.getChildren().addAll(vbButtons1, vbButtons2);

        VBox vBox1 = new VBox();
        vBox1.setSpacing(DEFAULT_SPACING);
        vBox1.getChildren().addAll(hBoxButtons, hBox1);

        vbButtons1.setId("vbuttons1");
        vbButtons2.setId("vbuttons2");

        Button btn9 = new Button(FIRST_BUTTON_TEXT);
        Button btn10 = new Button(SECOND_BUTTON_TEXT);
        Button btn11 = new Button(THIRD_BUTTON_TEXT);
        Button btn12 = new Button(FOURTH_BUTTON_TEXT);

        btn9.setMaxWidth(Double.MAX_VALUE);
        btn10.setMaxWidth(Double.MAX_VALUE);
        btn11.setMaxWidth(Double.MAX_VALUE);
        btn12.setMaxWidth(Double.MAX_VALUE);

        VBox vbButtons3 = new VBox();
        vbButtons3.setId("vbuttons1");
        Label labelButtons2 = new Label("Same parent ID 1st Column:");
        labelButtons2.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        vbButtons3.setSpacing(DEFAULT_SPACING);
        vbButtons3.getChildren().addAll(labelButtons2, btn9, btn10, btn11, btn12);

        //Combo boxes with same buttons
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
        labelCombo.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));

        //Open new windows with button
        Button buttonNewWindow = new Button("Open New Window");
        buttonNewWindow.setId("btnwindow");
        buttonNewWindow.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane p2 = new Pane();
                p2.setPrefSize(SEC_PANE_WIDTH, SEC_PANE_HEIGHT);
                Scene scene2 = new Scene(p2);
                Stage secondaryStage = new Stage();
                secondaryStage.setScene(scene2);
                secondaryStage.setTitle("New Window For Test");
                secondaryStage.show();
            }
        });

        //Open new window second button
        Button buttonNewWindow2 = new Button("Open New Window V2");
        buttonNewWindow2.setId("btnwindow2");
        buttonNewWindow2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Pane p3 = new Pane();
                p3.setPrefSize(SEC_PANE_WIDTH, SEC_PANE_HEIGHT);
                Scene scene3 = new Scene(p3);
                Stage thirdStage = new Stage();
                thirdStage.setScene(scene3);
                thirdStage.setTitle("New Window For Test V2");
                thirdStage.show();
            }
        });

        //Add text field with default text
        TextField textField = new TextField("Default Text");
        textField.setId("textfield");

        vBoxCombo.getChildren().addAll(hBoxCombo2, hBoxCombo1, buttonNewWindow, buttonNewWindow2, textField);
        vBoxCombo.setSpacing(DEFAULT_SPACING);
        hBoxCombo1.setSpacing(DEFAULT_SPACING);
        hBoxCombo1.getChildren().addAll(comboBox1, comboBox2);
        hBoxCombo2.getChildren().addAll(labelCombo);

        //List view with text and buttons for each element
        VBox vBoxListView = new VBox();
        ListView<HBoxCell> listView1 = new ListView<>();
        Label labelListView = new Label("Multiple Selection List View:");
        labelListView.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        listView1.setMaxHeight(LIST_VIEW_MAX_HEIGHT);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<HBoxCell> list = new ArrayList<>();
        for (int i = 0; i < LIST_ITEMS; i++) {
            list.add(new HBoxCell("Item " + i, "Hyperlink Button"));
        }
        ObservableList<HBoxCell> myObservableList = FXCollections.observableList(list);
        listView1.setItems(myObservableList);

        //Tables with same items and same IDs
        HBox hBoxTables = new HBox();
        hBoxTables.setId("hboxtables");
        VBox vBoxTables = new VBox();
        hBoxTables.getChildren().add(vBoxTables);

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
        TableView<Person> tableView1 = new TableView<>();
        TableView<Person> tableView2 = new TableView<>();

        //Table columns definition
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person,String>("firstName"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person,String>("lastName")
        );
        TableColumn emailCol = new TableColumn("Email");
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
        emailCol2.setCellValueFactory(
                new PropertyValueFactory<Person,String>("email")
        );
        tableView1.getSelectionModel().setCellSelectionEnabled(true);
        tableView2.getSelectionModel().setCellSelectionEnabled(true);

        tableView1.setItems(data);
        tableView1.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        tableView2.setItems(data2);
        tableView2.getColumns().addAll(firstNameCol2, lastNameCol2, emailCol2);
        tableView1.setPrefSize(TABLE_WIDTH, TABLE_HEIGHT);
        tableView2.setPrefSize(TABLE_WIDTH, TABLE_HEIGHT);
        vBoxTables.getChildren().addAll(tableView1, tableView2);
        vBoxListView.getChildren().addAll(labelListView, listView1);

        //Elements padding
        vBoxMaster.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        hBoxMaster1.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        hBoxMaster2.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        border.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        vBox1.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        vbButtons3.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        vBoxCombo.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        vBoxListView.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));
        hBoxTables.setPadding(new Insets(TOP_PADDING,RIGHT_PADDING,BOTTOM_PADDING,LEFT_PADDING));

        //Add elements to master elements and start primary stage
        hBoxMaster1.getChildren().addAll(vBox1, vbButtons3, vBoxCombo);
        hBoxMaster2.getChildren().addAll(vBoxListView, hBoxTables);
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Example Application 3");
        primaryStage.show();
    }
}
