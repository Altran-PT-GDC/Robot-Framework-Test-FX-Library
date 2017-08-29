package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testfx.api.FxRobot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RobotKeywords
public class Table {

    private static final Logger LOG = LoggerFactory.getLogger(Table.class);
    /**
     * Return the number of columns for specific table
     *
     * @param identifier
     *      The id of the table
     * @return
     *      The number of columns
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getTableColumnCount(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getColumns().size();
    }

    /**
     * Check if table is visible. If the table is not visible, return exception
     *
     * @param identifier
     *      The id of the table
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void tableShouldBeVisible(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        if (!table.isVisible()){
           throw new TestFxLibraryNonFatalException("Table is not visible");
        }
    }

    /**
     * Check if table is not visible. If the table is visible, return exception
     *
     * @param identifier
     *      The id of the table
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void tableShouldNotBeVisible(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        if (table.isVisible()){
            throw new TestFxLibraryNonFatalException("Table is visible");
        }
    }

    /**
     * Return the number of rows in the table
     *
     * @param identifier
     *      The if of the table
     * @return
     *      The number of rows
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getTableRowCount(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getItems().size();
    }

    /**
     * Return the table headers name of the table
     *
     * @param identifier
     *      The id of the table
     * @return
     *      List of names
     */
    @RobotKeyword
    @ArgumentNames({"ientifier"})
    public List<String> getTableHeaders(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        ObservableList<TableColumn> columns = table.getColumns();

        List<String> columnName = new ArrayList<>();
        for(TableColumn col : columns){
            columnName.add(col.getText());
        }
        return columnName;
    }

    /**
     * Return the values for all rows in the table.
     *
     * @param identifier
     *      The id of the table
     * @return
     *      The list of values
     */
    @RobotKeyword
    @ArgumentNames({"ientifier"})
    public List<String> getTableValues(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getItems();
    }

    /**
     * Return the cell value of the table
     *
     * @param identifier
     *      The id of the table
     * @param rowIndex
     *      The row to get the value. 0 is the first line.
     * @param columnIndex
     *      The column to get the value. 0 is the first column
     *
     * @return
     *      The cell value
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "rowIndex", "columnIndex"})
    public String getTableCellValue(String identifier, int rowIndex, int columnIndex){
        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        Object item = table.getItems().get(rowIndex);

        // Get Column
        TableColumn col = (TableColumn) table.getColumns().get(columnIndex);

        // this gives the value in the selected cell:
        return (String) col.getCellObservableValue(item).getValue();
    }

    /**
     * Check if cell contain the text. If not contains the text, throw TestFxLibraryNonFatalException
     *
     * @param identifier
     *      The id of the table
     * @param rowIndex
     *      The row to get the value. 0 is the first line.
     * @param columnIndex
     *      The column to get the value. 0 is the first column
     * @param text
     *      The text to compare
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "rowIndex", "columnIndex", "text"})
    public void tableCellShouldContain(String identifier, int rowIndex, int columnIndex, String text){
        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        Object item = table.getItems().get(rowIndex);

        // Get Column
        TableColumn col = (TableColumn) table.getColumns().get(columnIndex);

        // this gives the value in the selected cell:
        String data = (String) col.getCellObservableValue(item).getValue();

        if(!data.contains(text)){
            throw new TestFxLibraryNonFatalException(String.format("Cell not contains value %s", text));
        }
    }

    /**
     * Get values from specific column of the table
     * @param identifier
     *      The id of the table
     * @param columnIndex
     *      The column to get the values for all rows. 0 is the first column
     * @return
     *      List of values
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "columnIndex"})
    public List<String> getTableColumnValues(String identifier, int columnIndex){
        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        ObservableList items = table.getItems();

        List<String> list = new ArrayList<>();
        Iterator it = items.iterator();
        while(it.hasNext()){
            // Get Column
            TableColumn col = (TableColumn) table.getColumns().get(columnIndex);

            // this gives the value in the selected cell:
            String data = (String) col.getCellObservableValue(it.next()).getValue();

            list.add(data);
        }

        return list;

    }

    /**
     * et values from specific row of the table
     * @param identifier
     *      The id of the table
     * @param rowIndex
     *      The row to get the values for all rows. 0 is the first column
     *
     * @return
     *      List of values
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "rowIndex"})
    public List<String> getTableRowValues(String identifier, int rowIndex){
        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        Object item = table.getItems().get(rowIndex);

        List<String> list = new ArrayList<>();
        for(int i = 0; i < table.getColumns().size(); i++){
            TableColumn col = (TableColumn) table.getColumns().get(i);
            list.add((String) col.getCellObservableValue(item).getValue());
        }

        return list;
    }

    /**
     * Validate if the text is equal for some text header in the table. If the text is not equal, returns TestFxLibraryNonFatalException
     *
     * @param identifier
     *      The id of the table
     * @param text
     *      The text to compare
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "text"})
    public void getTableHeaderShouldContain(String identifier, String text) {
        TableView table = new FxRobot().lookup(identifier).query();
        ObservableList<TableColumn> columns = table.getColumns();

        boolean flag = false;
        for (TableColumn col : columns) {
            if (col.getText().contains(text)) {
                flag = true;
            }
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The table header not contains the text %s", text));
        }
    }

    @RobotKeyword
    @ArgumentNames({"ientifier", "text"})
    public void getTableShouldContain(String identifier, String text) {
        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        ObservableList items = table.getItems();

        Iterator it = items.iterator();

        boolean flag = false;
        while(it.hasNext()){

            ObservableList<TableColumn> columns = table.getColumns();
            for (TableColumn col : columns) {
                String data = "";
                try{
                    data = (String) col.getCellObservableValue(it.next()).getValue();
                }catch (Exception e) {
                    LOG.error(String.format("The table not contains the text %s", text),e);
                    throw new TestFxLibraryNonFatalException(String.format("The table not contains the text %s", text));
                }

                if (data.contains(text)) {
                    flag = true;
                    break;
                }
            }
            break;
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format("The table not contains the text %s", text));
        }
    }
}
