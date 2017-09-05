package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
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
    private static String ERROR_MSG = "The table not contains the text %s";
    /**
     * <b>Description:</b> This keyword returns the number of columns from a specific
     * table specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the table
     *
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     * : The number of columns
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${integer}=</td>
     *         <td>Get Table Column Count</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getTableColumnCount(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getColumns().size();
    }

    /**
     * <b>Description:</b> This keyword checks if a table is visible. This table is specified
     * with <i>identifier</i>. If the table is not visible an exception is thrown.<br>
     *
     * @param identifier
     * : The id of the table
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Table Should Be Visible</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     *
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
     * <b>Description:</b> This keyword checks if a table is not visible. This table is
     * specified with <i>identifier</i>. If the table is visible an exception is thrown.<br>
     *
     * @param identifier
     * : The id of the table
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Table Should Not Be Visible</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     *
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
     * <b>Description:</b> This keyword returns the number of rows in a table specified
     * with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The if of the table
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  The number of rows
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${integer}=</td>
     *         <td>Get Table Row Count</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public int getTableRowCount(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getItems().size();
    }

    /**
     * <b>Description:</b> This keyword returns a list of header names from a table specified
     * with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the table
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  List of names
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get Table Headers</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
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
     * <b>Description:</b> This keyword returns a list with values from all rows in a table
     * specified with <i>identifier</i>.<br>
     *
     * @param identifier
     * : The id of the table
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  The list of values
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get Table Values</td>
     *         <td>idTable05</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public List<String> getTableValues(String identifier){
        TableView table = new FxRobot().lookup(identifier).query();
        return table.getItems();
    }

    /**
     * <b>Description:</b> This keyword returns the cell value from a table specified with <i>identifier</i>.
     * <i>rowIndex</i> and <i>columnIndex</i> identify row and column indexes. An Exception is thrown
     * if values are out of range.<br>
     *
     * @param identifier
     * : The id of the table
     * @param rowIndex
     * : Row to get the value from. First row has 0 index.
     * @param columnIndex
     * : Column to get the value from. First column has 0 index.
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>rowIndex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max row index)</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>columnIdex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max column index)</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  The cell value
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>${string}=</td>
     *         <td>Get Table Cell Value</td>
     *         <td>idTable05</td>
     *         <td>2</td>
     *         <td>12</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "rowIndex", "columnIndex"})
    public String getTableCellValue(String identifier, int rowIndex, int columnIndex){
        TestFxLibraryValidation.validateIndex(rowIndex);
        TestFxLibraryValidation.validateIndex(columnIndex);

        TableView table = new FxRobot().lookup(identifier).query();

        // Item row
        Object item = table.getItems().get(rowIndex);

        // Get Column
        TableColumn col = (TableColumn) table.getColumns().get(columnIndex);

        // this gives the value in the selected cell:
        return (String) col.getCellObservableValue(item).getValue();
    }

    /**
     * <b>Description:</b> This keyword checks if a given cell in a table contains specified text. Table is
     * specified with <i>identifier</i>; <i>rowIndex</i> and <i>columnIndex</i> identify row and column
     * indexes. <i>text</i> specifies text to be validated. If the given cell does not contain <i>text</i>
     * a TestFxLibraryNonFatalException is thrown. An Exception is thrown if index values are out of range.<br>
     *
     * @param identifier
     * : The id of the table
     * @param rowIndex
     * : Row to get the value from. first line index is 0
     * @param columnIndex
     * : Column to get the value from. first column index is 0
     * @param text
     * : Text to compare
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>rowIndex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max row index)</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>columnIdex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max column index)</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Table Cell Should Contain</td>
     *         <td>idTable05</td>
     *         <td>5</td>
     *         <td>15</td>
     *         <td>Hello World</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "rowIndex", "columnIndex", "text"})
    public void tableCellShouldContain(String identifier, int rowIndex, int columnIndex, String text){
        TestFxLibraryValidation.validateIndex(rowIndex);
        TestFxLibraryValidation.validateIndex(columnIndex);

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
     * <b>Description:</b> This keyword gets a list of values from a specific column of a given table. Table
     * is specified with <i>identifier</i> and <i>columnIndex</i> specifies column index. An Exception
     * is thrown if column index is out of bounds.<br>
     *
     * @param identifier
     * : The id of the table
     * @param columnIndex
     * : Column to get the values from for all rows. 0 is for first column
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>columnIndex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max column index)</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  List of values
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get Table Column Values</td>
     *         <td>idTable23</td>
     *         <td>12</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "columnIndex"})
    public List<String> getTableColumnValues(String identifier, int columnIndex){
        TestFxLibraryValidation.validateIndex(columnIndex);

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
     * <b>Description:</b> This keyword gets a list of values from a specific row of a given table. The table
     * is specified with <i>identifier</i> and <i>rowIndex</i> specifies row index. An Exception
     * is thrown if row index is out of bounds.<br>
     *
     * @param identifier
     * : The id of the table
     * @param rowIndex
     * : Row to get the values for all columns. 0 is for first row
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>rowIndex</td>
     *         <td>Yes</td>
     *         <td>int (0 to max row index)</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * @return
     *  List of values
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>@{list}=</td>
     *         <td>Get Table Row Values</td>
     *         <td>idTable3A</td>
     *         <td>8</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "rowIndex"})
    public List<String> getTableRowValues(String identifier, int rowIndex){
        TestFxLibraryValidation.validateIndex(rowIndex);
        
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
     * <b>Description:</b> This keyword validates if a text is equal to some text header in a table.
     * <i>identifier</i> specifies table and <i>text</i> specifies text. If text
     * is not equal a TestFxLibraryNonFatalException is thrown.<br>
     *
     * @param identifier
     * : The id of the table
     * @param text
     * : The text to compare
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Table Header Should Contain</td>
     *         <td>idTable12</td>
     *         <td>Hello World</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "text"})
    public void tableHeaderShouldContain(String identifier, String text) {
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


    /**
     * <b>Description:</b> This keyword validates if a text is present in a given table. Table
     * is specified with <i>identifier</i> and <i>text</i> specifies text to compare. If
     * <i>text</i> is not found within <i>identifier</i> a TestFxLibraryNonFatalException is thrown.<br>
     *
     * @param identifier
     * : The id of the table
     * @param text
     * : Text to compare
     * <br><br>
     * <table summary="">
     *     <tr>
     *         <th>Parameter</th>
     *         <th>Mandatory</th>
     *         <th>Values</th>
     *         <th>Default</th>
     *     </tr>
     *     <tr>
     *         <td>identifier</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     *     <tr>
     *         <td>text</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Table Should Contain</td>
     *         <td>idTable12</td>
     *         <td>Hello World</td>
     *     </tr>
     * </table>
     *
     */
    @RobotKeyword
    @ArgumentNames({"ientifier", "text"})
    public void tableShouldContain(String identifier, String text) {
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
                    LOG.error(String.format(ERROR_MSG, text),e);
                    throw new TestFxLibraryNonFatalException(String.format(ERROR_MSG, text));
                }

                if (data.contains(text)) {
                    flag = true;
                    break;
                }
            }
            break;
        }

        if(!flag){
            throw new TestFxLibraryNonFatalException(String.format(ERROR_MSG, text));
        }
    }
}
