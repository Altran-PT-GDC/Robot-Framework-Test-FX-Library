package testapp;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
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
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int TREEITEMS_AMOUNT = 6;



    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setMaxHeight(HEIGHT);
        stage.setMaxWidth(WIDTH);
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setScene(new Scene(new CounterPane(stage), COUNTERPANE_WIDTH, COUNTERPANE_HEIGHT));
        stage.show();
    }
    

    private static class CounterPane extends StackPane {
        private Stage stage;
        FileChooser ch = new FileChooser();
        private final ObservableList<Person> data =
                FXCollections.observableArrayList(new Person("A", "B", "s@s.s"));

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

            //
            TableView table = new TableView();
            table.setId("table");
            TableColumn firstNameCol = new TableColumn("First Name");
            firstNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("firstName"));

            TableColumn lastNameCol = new TableColumn("Last Name");
            lastNameCol.setCellValueFactory(
                    new PropertyValueFactory<>("lastName"));

            TableColumn emailCol = new TableColumn("Email");
            emailCol.setCellValueFactory(
                    new PropertyValueFactory<>("email"));

            table.getColumns().addAll(firstNameCol, lastNameCol, emailCol);

            data.add(new Person("Jonh", "Dow", "jonhdoe@s.s"));
            table.setItems(data);



            TableView table1 = new TableView();
            table1.setId("table1");
            table1.setVisible(false);
            TableColumn address = new TableColumn("Address");
            TableColumn phone = new TableColumn("Phone");
            table1.getColumns().addAll(address, phone);

            TreeItem<String> rootItem = new TreeItem<String> ("Inbox");
            rootItem.setExpanded(true);
            for (int i = 1; i < TREEITEMS_AMOUNT; i++) {
                TreeItem<String> item = new TreeItem<String> ("Message" + i);
                rootItem.getChildren().add(item);
            }
            TreeView<String> tree = new TreeView<String> (rootItem);
            tree.setId("treeView");
            tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            ComboBox combo = new ComboBox();
            combo.setId("comboBox");
            combo.getItems().addAll("B", "C", "D");
            combo.getSelectionModel().select(0);



            // create and add containers.
            HBox box = new HBox(HBOX_SPACING, countButton, countValue, btnDisable, chooser, table, table1, tree, combo);
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
