package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.exceptions.TestFxLibraryFatalException;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class ToolBar {

    @Autowired
    private Wait wait;

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String[] getToolBarItems (String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        ObservableList<Node> items = toolBar.getItems();
        String[] itemList = new String[items.size()];
        for (int i=0; i<items.size(); i++){
            itemList[i] = items.get(i).toString();
        }
        return itemList;
    }

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toolBarShouldBeEnabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        try {
            if(toolBar.isDisabled()){
                throw new TestFxLibraryFatalException("ToolBar is disabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }

    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void toolBarShouldBeDisabled(String identifier){
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        javafx.scene.control.ToolBar toolBar = TestFxLibraryCommon.lookup(identifier);
        try {
            if(!toolBar.isDisabled()){
                throw new TestFxLibraryFatalException("ToolBar is enabled.");
            }
        } catch (IllegalArgumentException | NullPointerException e){
            throw  new TestFxLibraryFatalException(e);
        }
    }
}
