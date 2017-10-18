package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryCommon;
import com.altran.gdc.robotframework.testfxlibrary.utils.TestFxLibraryValidation;
import javafx.collections.ObservableList;
import javafx.scene.control.TabPane;
import org.robotframework.javalib.annotation.ArgumentNames;
import org.robotframework.javalib.annotation.Autowired;
import org.robotframework.javalib.annotation.RobotKeyword;
import org.robotframework.javalib.annotation.RobotKeywords;


@RobotKeywords
public class Tab {

    @Autowired
    private Wait wait;


    @RobotKeyword
    @ArgumentNames({"identifier"})
    public String[] getTabPaneTabs(String identifier) {
        TestFxLibraryValidation.validateArguments(identifier);
        wait.waitUntilPageContains(identifier);

        TabPane tabPane = TestFxLibraryCommon.lookup(identifier);
        ObservableList<javafx.scene.control.Tab> tabs = tabPane.getTabs();
        String[] items = new String[tabs.size()];
        for (int i=0; i<tabs.size(); i++){
            items[i] = tabs.get(i).getText();
        }
        return items;
    }


}
