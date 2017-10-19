package testapp;

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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

    public static class HBoxCell1 extends HBox {
        Label label = new Label();
        Hyperlink hyperlink = new Hyperlink();

        HBoxCell1(String labelText, String buttonText) {
            super();
            label.setText(labelText);
            label.setMaxWidth(Double.MAX_VALUE);
            HBox.setHgrow(label, Priority.ALWAYS);

            hyperlink.setText(buttonText);
            hyperlink.setDisable(true);
            hyperlink.setId("hyperlinkDisabled");

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
    private static  final int MAIN_PANE_WIDTH = 1000;
    private static  final int MAIN_PANE_HEIGHT = 650;
    private static  final int SEC_PANE_WIDTH = 50;
    private static  final int SEC_PANE_HEIGHT = 50;
    private static  final int TABLE_WIDTH = 370;
    private static  final int TABLE_HEIGHT = 170;
    private static  final int LIST_VIEW_MAX_HEIGHT = 200;
    private static  final int DEFAULT_FONT_SIZE = 12;
    private static  final int LIST_ITEMS = 10;
    private static  final int TEXT_AREA_WIDTH = 100;
    private static  final int TEXT_AREA_HEIGHT = 50;
    private static  final int DEFAULT_SELECTED_LIST_ITEM = 0;
    private static  final int LIST_VIEW_SIMPLE_WIDTH = 100;
    private static  final int LIST_VIEW_SIMPLE_HEIGHT = 150;
    private static  final int TREE_VIEW_MAX_HEIGHT = 300;
    private static final int WAIT_TIME = 3;
    private static final int SPINNER_DEFAULT_VALUE = 100;
    private static final int FLOWPANE_HGAP = 100;
    private static final int TREEITEMS_AMOUNT = 6;
    private static final double PROGRESSBAR_WIDTH = 100;
    private static final double PROGRESSBAR1_SCALE = 0.6;
    private static final double PROGRESSBAR1_WIDTH = 200;
    private static  final int SLEEP_ONE_SECUND = 1000;
    private static  final int PROGRESSBAR_SIZE = 5;
    private static  final double PROGRESSINDICATOR_PROGRESS = 0.3;
    private static  final double SCROLLBAR_MAX_VALUE = 150.2;
    private static  final double SCROLLBAR_MIN_VALUE = 10.6;
    private static  final double SCROLLBAR_DEFAULT_VALUE = 135;
    private static  final double SCROLLPANE_HMAX = 0.5;
    private static  final double SCROLLPANE_HMIN = 0.1;
    private static  final double SCROLLPANE_VMAX = 0.4;
    private static  final double SCROLLPANE_VMIN = 0.2;
    private static  final double SCROLLPANE_DEFAULT_VERTICAL_VALUE = 0.35;
    private static  final double SCROLLPANE_DEFAULT_HORIZONTAL_VALUE = 0.23;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws InterruptedException {
        //Set main pane
        Pane p = new Pane();
        p.setPrefSize(MAIN_PANE_WIDTH, MAIN_PANE_HEIGHT);
        p.setId("rootPane");

        //Add Menu to test
        MenuBar menuBar = new MenuBar();
        menuBar.setId("menuBar");
        Menu menuFile = new Menu("File");
        menuFile.setId("menuFile");
        Menu menuView = new Menu("View");
        menuView.setId("menuView");
        MenuItem menuItemSave = new MenuItem("Save");
        MenuItem menuItemExit = new MenuItem("Exit");
        menuFile.getItems().addAll(menuItemSave, menuItemExit);
        menuBar.getMenus().addAll(menuFile, menuView);

        MenuBar menuBar1 = new MenuBar();
        menuBar1.setId("menuBar1");
        menuBar1.setVisible(false);

        //Add Toolbar to test
        Button btnToolBarOk = new Button();
        Button btnToolBarCancel = new Button();
        btnToolBarOk.setId("btnToolBarOk");
        btnToolBarOk.setText("OK");
        btnToolBarCancel.setText("Cancel");
        btnToolBarCancel.setId("btnToolBarCancel");
        ToolBar toolBar = new ToolBar(btnToolBarOk, btnToolBarCancel);
        toolBar.setId("toolbar");
        ToolBar toolBarDisabled = new ToolBar();
        toolBarDisabled.setId("toolbarDisabled");
        toolBarDisabled.setDisable(true);
        toolBarDisabled.setVisible(false);

        //Tab to test
        Tab tabOne = new Tab("Tab One");
        tabOne.setId("tabOne");
        Tab tabTwo = new Tab("Tab Two");
        tabTwo.setId("tabTwo");
        Tab tabThree = new Tab("Tab Three");
        tabOne.setId("tabThree");
        Tab tabDisabled = new Tab("Disabled Tab");
        tabDisabled.setId("tabDisabled");
        tabDisabled.setDisable(true);
        TabPane tabPane = new TabPane(tabOne, tabTwo, tabThree, tabDisabled);
        tabPane.getSelectionModel().select(tabOne);
        tabPane.setId("tabPane");

        //Hbox for toolbars and tabs
        HBox hBoxToolbar = new HBox(toolBar, toolBarDisabled, tabPane);

        //Set master VBox and HBox
        VBox vBoxMaster = new VBox();
        HBox hBoxMaster1 = new HBox();
        HBox hBoxMaster2 = new HBox();
        p.getChildren().addAll(vBoxMaster);

        ProgressBar progressBar = new ProgressBar();
        progressBar.setId("progressBar");
        progressBar.setPrefWidth(PROGRESSBAR_WIDTH);
        progressBar.setVisible(true);

        int size = PROGRESSBAR_SIZE;
        new Thread(() -> {
            for (int i = 0; i <= size; i++){
                final double step = i;

                progressBar.setProgress( step / size );

                try {
                    Thread.sleep(SLEEP_ONE_SECUND);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();


        ProgressBar progressBar1 = new ProgressBar(PROGRESSBAR1_SCALE);
        progressBar1.setId("progressBar1");
        progressBar1.setDisable(true);
        progressBar1.setPrefWidth(PROGRESSBAR1_WIDTH);
        progressBar1.setVisible(true);


        ProgressIndicator progressIndicator = new ProgressIndicator(0);
        progressIndicator.setId("progressIndicator");
        progressIndicator.setProgress(PROGRESSINDICATOR_PROGRESS);

        ProgressIndicator progressIndicator1 = new ProgressIndicator(0);
        progressIndicator1.setId("progressIndicator1");
        progressIndicator1.setProgress(PROGRESSINDICATOR_PROGRESS);
        progressIndicator1.setDisable(true);

        HBox hBoxProgressIndicator = new HBox();
        hBoxProgressIndicator.getChildren().addAll(progressIndicator, progressIndicator1);

        int sizeIndicator = PROGRESSBAR_SIZE;
        new Thread(() -> {
            for (int i = 0; i <= sizeIndicator; i++){
                final double step = i;

                progressIndicator.setProgress( step / size );

                try {
                    Thread.sleep(SLEEP_ONE_SECUND);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        //ScrollBar to test
        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setId("scrollBar");
        scrollBar.setMax(SCROLLBAR_MAX_VALUE);
        scrollBar.setMin(SCROLLBAR_MIN_VALUE);
        scrollBar.setValue(SCROLLBAR_DEFAULT_VALUE);

        vBoxMaster.getChildren().addAll(menuBar,menuBar1, hBoxToolbar, hBoxMaster1, hBoxMaster2 );
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
        comboBox1.getSelectionModel().selectFirst();

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
                Label label = new Label("Test");
                label.setId("testLabel");
                p2.getChildren().add(label);
            }
        });

        //Open new window second button
        Button buttonNewWindow2 = new Button("Disabled Button");
        p.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    buttonNewWindow2.setDisable(false);
                }
            }
        });
        p.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.ENTER){
                    buttonNewWindow2.setDisable(true);
                }
            }
        });

        buttonNewWindow2.setId("disableBtn");
        buttonNewWindow2.setDisable(true);
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
        HBox hBoxText = new HBox();
        TextField textField = new TextField("Default Text");
        textField.setId("textfield");
        TextArea textArea = new TextArea("Text Area Text");
        textArea.setId("textarea");
        textArea.setMaxSize(TEXT_AREA_WIDTH, TEXT_AREA_HEIGHT);
        hBoxText.getChildren().addAll(textField, textArea);

        vBoxCombo.getChildren().addAll(hBoxCombo2, hBoxCombo1, buttonNewWindow, buttonNewWindow2, hBoxText);
        vBoxCombo.setSpacing(DEFAULT_SPACING);
        hBoxCombo1.setSpacing(DEFAULT_SPACING);
        hBoxCombo1.getChildren().addAll(comboBox1, comboBox2);
        hBoxCombo2.getChildren().addAll(labelCombo);

        VBox vBoxListViewSimple = new VBox();
        HBox hBoxLabelSimpleListView = new HBox();
        HBox hBoxSimpleListView = new HBox();
        ListView listViewSimple = new ListView();
        listViewSimple.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        final ObservableList<String> oList = FXCollections.observableArrayList("one", "two", "three", "four", "five", "six");
        listViewSimple.setItems(oList);
        listViewSimple.getSelectionModel().selectFirst();
        listViewSimple.setId("listviewsimple");
        Label labelSimpleListView = new Label("Simple List View Items:");
        labelSimpleListView.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        labelSimpleListView.setId("label");
        vBoxListViewSimple.getChildren().addAll(hBoxLabelSimpleListView, hBoxSimpleListView);
        listViewSimple.setMaxSize(LIST_VIEW_SIMPLE_WIDTH, LIST_VIEW_SIMPLE_HEIGHT);
        hBoxLabelSimpleListView.getChildren().add(labelSimpleListView);
        hBoxSimpleListView.getChildren().add(listViewSimple);


        //List view with text and buttons for each element
        VBox vBoxListView = new VBox();
        ListView<HBox> listView1 = new ListView<>();
        listView1.setId("listView");
        Label labelListView = new Label("Multiple Selection List View:");
        labelListView.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        listView1.setMaxHeight(LIST_VIEW_MAX_HEIGHT);
        listView1.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        List<HBox> list = new ArrayList<>();
        list.add(new HBoxCell1("Item 0", "Hyperlink Button"));
        for (int i = 1; i < LIST_ITEMS; i++) {
            list.add(new HBoxCell("Item " + i, "Hyperlink Button"));
        }
        ObservableList<HBox> myObservableList = FXCollections.observableList(list);
        listView1.setItems(myObservableList);
        listView1.getSelectionModel().select(DEFAULT_SELECTED_LIST_ITEM);

        //Add two checkboxes, one enabled and another disabled
        final VBox vBoxCheckBoxes = new VBox();
        final HBox hBoxCheckBoxes = new HBox();
        final Label labelCheckBoxes = new Label("Two checkboxes, enabled and disabled:");
        final DatePicker datePicker = new DatePicker();
        final HBox toggleButtonsHBox = new HBox();
        final ToggleButton toggleButton = new ToggleButton();
        toggleButton.setSelected(true);
        toggleButton.setDisable(true);
        toggleButton.setId("toggleButtonDisableSelected");
        final ToggleButton toggleButton1 = new ToggleButton();
        toggleButton1.setId("toggleButton");
        toggleButtonsHBox.getChildren().addAll(toggleButton, toggleButton1);

        datePicker.setId("datePicker");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDate = LocalDate.parse("10-10-2017", formatter);
        datePicker.setValue(localDate);
        labelCheckBoxes.setFont(Font.font(null, FontWeight.BOLD, DEFAULT_FONT_SIZE));
        vBoxCheckBoxes.getChildren().addAll(labelCheckBoxes, hBoxCheckBoxes, datePicker, toggleButtonsHBox);
        final CheckBox check = new CheckBox();
        final CheckBox checkDisabled = new CheckBox();
        final CheckBox checkInvisible = new CheckBox();
        hBoxCheckBoxes.getChildren().addAll(check, checkDisabled, checkInvisible);
        check.setId("checkbox");
        check.setVisible(true);
        checkDisabled.setId("disabledCheckbox");
        checkDisabled.setDisable(true);
        checkInvisible.setId("checkInvisible");
        checkInvisible.setVisible(false);

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
        TableView<Object> tableView3 = new TableView<>();

        //Table columns definition
        TableColumn firstNameCol = new TableColumn("First Name");
        firstNameCol.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameCol = new TableColumn("Last Name");
        lastNameCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName")
        );
        TableColumn emailCol = new TableColumn("Email");
        emailCol.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email")
        );
        TableColumn firstNameCol2 = new TableColumn("First Name");
        firstNameCol2.setCellValueFactory(new PropertyValueFactory<Person, String>("firstName"));
        TableColumn lastNameCol2 = new TableColumn("Last Name");
        lastNameCol2.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName")
        );
        TableColumn emailCol2 = new TableColumn("Email");
        emailCol2.setCellValueFactory(
                new PropertyValueFactory<Person, String>("email")
        );
        tableView1.getSelectionModel().setCellSelectionEnabled(true);
        tableView2.getSelectionModel().setCellSelectionEnabled(true);

        tableView1.setItems(data);
        tableView1.setId("tableView");
        tableView1.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        tableView2.setItems(data2);
        tableView2.setId("tableView2");
        tableView2.getColumns().addAll(firstNameCol2, lastNameCol2, emailCol2);
        tableView1.setPrefSize(TABLE_WIDTH, TABLE_HEIGHT);
        tableView2.setPrefSize(TABLE_WIDTH, TABLE_HEIGHT);
        tableView3.setId("tableView3");
        tableView3.setVisible(false);
        vBoxTables.getChildren().addAll(tableView1, tableView2, tableView3);
        vBoxListView.getChildren().addAll(labelListView, listView1, vBoxCheckBoxes);

        //Elements padding
        vBoxMaster.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxMaster1.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxMaster2.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        border.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        vBox1.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        vbButtons3.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        vBoxCombo.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        vBoxListView.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxTables.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxLabelSimpleListView.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxSimpleListView.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxCheckBoxes.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        vBoxCheckBoxes.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));

        VBox vboxWait = new VBox();

        //Wait Button
        final FlowPane choicePane = new FlowPane();
        choicePane.setHgap(FLOWPANE_HGAP);
        Label choiceLbl = new Label("Fruits");
        final FlowPane listPane = new FlowPane();
        listPane.setHgap(FLOWPANE_HGAP);
        Label listLbl = new Label("Vegetables");

        final ListView<String> vegetables = new ListView<>(FXCollections.observableArrayList("Apple", "Apricot", "Banana"
                , "Cherry", "Date", "Kiwi", "Orange", "Pear", "Strawberry"));
        listPane.getChildren().add(listLbl);
        listPane.getChildren().add(vegetables);
        listPane.setVisible(false);
        vegetables.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        final Button btnTooltip = new Button("Tooltip Button");
        final Tooltip tooltip = new Tooltip("Test Tooltip");
        btnTooltip.setId("btntooltip");
        btnTooltip.setTooltip(tooltip);
        btnTooltip.setOnAction(event -> {
            //switch the visibility for each FlowPane
            choicePane.setVisible(!choicePane.isVisible());
            listPane.setVisible(!listPane.isVisible());
        });

        final Button toBeErase = new Button("To Be Erased");
        toBeErase.setId("toErase");
        toBeErase.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                fileChooser.showOpenDialog(primaryStage);
            }
        });

        Button testWait = new Button("Wait Button");
        testWait.setId("btnwait");
        testWait.setOnAction(event -> {
            btnTooltip.setDisable(!btnTooltip.isDisable());
            Timeline timer = new Timeline(
                    new KeyFrame(Duration.seconds(WAIT_TIME), events -> changeElementForWait(btnTooltip, false, vboxWait, toBeErase))
            );
            timer.play();
        });

        choicePane.getChildren().add(choiceLbl);

        //Spinner
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

        //RadioButton
        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Radio Button1");
        rb1.setToggleGroup(group);
        rb1.setId("rb1");
        rb1.setSelected(true);

        RadioButton rb2 = new RadioButton("Radio Button2");
        rb2.setToggleGroup(group);
        rb2.setId("rb2");
        rb2.setDisable(true);

        RadioButton rb3 = new RadioButton("Radio Button3");
        rb3.setToggleGroup(group);
        rb3.setId("rb3");
        rb3.isDisable();

        ColorPicker colorPicker = new ColorPicker();
        colorPicker.setId("colorPiker");
        colorPicker.setValue(Color.BLUE);
        colorPicker.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                p.setBackground(new Background(new BackgroundFill(colorPicker.getValue(), null,null)));
            }
        });

        //ChoiceBox
        ChoiceBox cb = new ChoiceBox();
        cb.setItems(FXCollections.observableArrayList(
                "One", "Two", "Three", "Four")
        );
        cb.setId("cb");
        cb.getSelectionModel().select(1);
        ChoiceBox cbDisabled = new ChoiceBox();
        cbDisabled.setId("cbDisabled");
        cbDisabled.setDisable(true);
        cbDisabled.setVisible(false);
        HBox hBoxChoiceBox = new HBox();
        hBoxChoiceBox.getChildren().addAll(cb, cbDisabled);

        vboxWait.getChildren().addAll(spinner, testWait, toBeErase, btnTooltip, rb1, rb2, rb3, hBoxChoiceBox, colorPicker);
        vboxWait.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));


        //TreeView
        TreeItem<String> rootItem = new TreeItem<String> ("Inbox");
        rootItem.setExpanded(true);
        for (int i = 1; i < TREEITEMS_AMOUNT; i++) {
            TreeItem<String> item = new TreeItem<String> ("Message" + i);
            rootItem.getChildren().add(item);
        }
        TreeView<String> tree = new TreeView<String> (rootItem);
        TreeView<String> treeDisabled = new TreeView<String> (rootItem);
        tree.setId("treeView");
        treeDisabled.setId("treeViewDisabled");
        treeDisabled.setDisable(true);
        treeDisabled.setVisible(false);
        tree.setMaxHeight(TREE_VIEW_MAX_HEIGHT);
        tree.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tree.setPrefSize(LIST_VIEW_SIMPLE_WIDTH, LIST_VIEW_SIMPLE_HEIGHT);

        VBox vBoxTreeProgress = new VBox();
        vBoxTreeProgress.getChildren().addAll(tree, progressBar, progressBar1, hBoxProgressIndicator, toggleButtonsHBox, scrollBar);
        vBoxTreeProgress.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        hBoxProgressIndicator.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));
        toggleButtonsHBox.setPadding(new Insets(TOP_PADDING, RIGHT_PADDING, BOTTOM_PADDING, LEFT_PADDING));

        //ScrollPane to test
        ScrollPane scrollPane = new ScrollPane(vBoxTreeProgress);
        scrollPane.setId("scrollPane");
        scrollPane.setHmax(SCROLLPANE_HMAX);
        scrollPane.setHmin(SCROLLPANE_HMIN);
        scrollPane.setVmax(SCROLLPANE_VMAX);
        scrollPane.setVmin(SCROLLPANE_VMIN);
        scrollPane.setHvalue(SCROLLPANE_DEFAULT_HORIZONTAL_VALUE);
        scrollPane.setVvalue(SCROLLPANE_DEFAULT_VERTICAL_VALUE);

        //Add elements to master elements and start primary stage
        hBoxMaster1.getChildren().addAll(vBox1, vbButtons3, vBoxCombo, vBoxListViewSimple, vboxWait);
        hBoxMaster2.getChildren().addAll(vBoxListView, hBoxTables, scrollPane, treeDisabled);
        Scene scene = new Scene(p);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Example Application 3");
        primaryStage.show();

    }
    private void changeElementForWait(Button vegFruitBut, boolean value, VBox vboxWait, Button toBeErase) {
        vegFruitBut.setDisable(value);
        vboxWait.getChildren().add(new Label("test"));
        vboxWait.getChildren().remove(toBeErase);
    }
}
