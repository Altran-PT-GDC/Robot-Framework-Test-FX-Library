package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryNonFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.control.MenuItem;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;

import java.util.ArrayList;

@RobotKeywords
public class Menu {

    private static final String IDENTIFIER_NOT_EXIST = "The identifier %s not exists!";

    /**
     * <b>Description:</b> This keyword returns the Menus
     * specified with <i>identifier</i>.
     *
     * @param identifier
     * : The menu id
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
     *  The list of menus
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Menu Items</td>
     *         <td>\# menuId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public java.util.List<String> getMenus(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        java.util.List<String> list = new ArrayList<>();

        try {
            javafx.scene.control.MenuBar menuBar = TestFxLibraryCommon.lookup(identifier);

            for(javafx.scene.control.Menu menu : menuBar.getMenus()){
                list.add(menu.getText());
            }
        } catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return list;
    }


    /**
     * <b>Description:</b> This keyword returns the items for specific menu.
     *
     * @param identifier
     * : The menu id
     *
     * @param menuName
     * : The menu name to get the items
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
     *  The list of items
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Get Menu Items</td>
     *         <td>\# menuId menuName</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier","menuName"})
    public java.util.List<String> getMenuItems(String identifier, String menuName){
        TestFxLibraryValidation.validateArguments(identifier, menuName);

        java.util.List<String> list = new ArrayList<>();

        try {
            javafx.scene.control.MenuBar menuBar = TestFxLibraryCommon.lookup(identifier);

            ObservableList<MenuItem> menuItemList = null;
            for(javafx.scene.control.Menu menu : menuBar.getMenus()){
                if(menu.getText().equals(menuName)){
                    menuItemList = menu.getItems();
                }
            }
            
            if(menuItemList != null && !menuItemList.isEmpty()){
                for(MenuItem item : menuItemList){
                    list.add(item.getText());
                }
            }
            
        } catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        return list;
    }


    /**
     * <b>Description:</b> This keyword check if the Menu specified with <i>identifier</i> should have item
     * specified with <i>item</i>.
     *
     * @param identifier
     * : The menu id
     * @param item
     * : The item
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
     *         <td>item</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Menu Should Have Item</td>
     *         <td>\# menuId</td>
     *         <td>item</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void menuShouldHaveItem(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier, item);

        boolean found = false;
        try {
            javafx.scene.control.MenuBar menuBar = TestFxLibraryCommon.lookup(identifier);

            found = this.compareItem(menuBar, item);

        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier), e);
        }

        if(!found){
            throw new TestFxLibraryNonFatalException(String.format("The item %s not found!", item));
        }
    }

    /**
     * <b>Description:</b> This keyword check if the Menu specified with <i>identifier</i> should not have item
     * specified with <i>item</i>.
     *
     * @param identifier
     * : The menu id
     * @param item
     * : The item
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
     *         <td>item</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Menu Should Have Item</td>
     *         <td>\# menuId</td>
     *         <td>item</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier", "item"})
    public void menuShouldNotHaveItem(String identifier, String item){
        TestFxLibraryValidation.validateArguments(identifier, item);

        boolean found = false;
        try {
            javafx.scene.control.MenuBar menuBar = TestFxLibraryCommon.lookup(identifier);

            found = this.compareItem(menuBar, item);

        }catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier),e);
        }

        if(found){
            throw new TestFxLibraryNonFatalException(String.format("The item %s exists ", item));
        }
    }

    /**
     * Compare if the Menu passed in the parameter contains the item.
     *
     * @param menuBar
     *      The MenuBar
     * @param item
     *      The item to compare
     * @return
     *      true is contains or false if not contains.
     */
    private boolean compareItem(javafx.scene.control.MenuBar menuBar, String item){
        boolean found = false;
        for(javafx.scene.control.Menu menu : menuBar.getMenus()){
            for (MenuItem menuItem: menu.getItems()){
                if (menuItem.getText().equals(item)){
                    found = true;
                    break;
                }
            }
        }
        return found;
    }

    /**
     * <b>Description:</b> This keyword check if the Menu specified with <i>identifier</i> is visible.
     *
     * @param identifier
     * : The menu id
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
     *     <tr>
     *         <td>item</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Menu Should Be Visible</td>
     *         <td>\# menuId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void menuShouldBeVisible(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        javafx.scene.control.MenuBar menuBar;
        try {
            menuBar = TestFxLibraryCommon.lookup(identifier);

        } catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier),e);
        }

        if(!menuBar.isVisible()){
            throw new TestFxLibraryNonFatalException(String.format("The menu %s is not visible ", menuBar));
        }
    }

    /**
     * <b>Description:</b> This keyword check if the Menu specified with <i>identifier</i> is not visible.
     *
     * @param identifier
     * : The menu id
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
     *     <tr>
     *         <td>item</td>
     *         <td>Yes</td>
     *         <td>string</td>
     *         <td>N/A</td>
     *     </tr>
     * </table>
     *
     * <br><br>
     * <b>Examples:</b>
     * <table summary="">
     *     <tr>
     *         <td>Menu Should Not Be Visible</td>
     *         <td>\# menuId</td>
     *     </tr>
     * </table>
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void menuShouldNotBeVisible(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);

        javafx.scene.control.MenuBar menuBar;
        try {
            menuBar = TestFxLibraryCommon.lookup(identifier);

        } catch (Exception e){
            throw new TestFxLibraryNonFatalException(String.format(IDENTIFIER_NOT_EXIST, identifier),e);
        }

        if(menuBar.isVisible()){
            throw new TestFxLibraryNonFatalException(String.format("The menu %s is visible ", menuBar));
        }
    }
}
