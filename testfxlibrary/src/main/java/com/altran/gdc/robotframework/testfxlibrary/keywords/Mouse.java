/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.altran.gdc.robotframework.testfxlibrary.keywords;

import com.altran.gdc.robotframework.testfxlibrary.utils.TestFXLibraryCache;
import com.sun.javafx.binding.StringFormatter;
import javafx.geometry.HorizontalDirection;
import javafx.geometry.VerticalDirection;
import javafx.scene.Node;
import org.robotframework.javalib.annotation.*;
import org.testfx.api.FxRobot;
import org.testfx.robot.Motion;
import java.util.Set;
import java.util.concurrent.TimeoutException;

/**
 *
 * @author pcosta
 */
@RobotKeywords
public class Mouse {

    @Autowired
    private Logging logging;

    /**
     * Clicks on a indentifier.<br>
     *
     * @throws TimeoutException
     *      If something goes wrong
     */
    @RobotKeywordOverload
    public void clickOn(String identifier) throws TimeoutException {
        clickOn(identifier, null);
    }

    @RobotKeyword
    @ArgumentNames({"identifier", "nodeKey=null"})
    public void clickOn(String identifier, String nodeKey) throws TimeoutException {
        if(nodeKey != null){
            Node node = (Node) TestFXLibraryCache.getIstance().get(nodeKey);
            //logging.info(String.format("CLICK OK - The node is %s", node));
            System.out.println(String.format("CLICK OK - The node is %s", node));
            Node n = new FxRobot().from(node).lookup(identifier).query();
            new FxRobot().clickOn(n);
        } else {
            new FxRobot().clickOn(identifier);
        }
    }

    /**
     * Double Click on a node.
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void doubleClickOn(String identifier) {
        new FxRobot().doubleClickOn(identifier);
    }

    /**
     * Drag a node.<br>
     *
     * @param identifier
     *             The identifier of the node to be draged.
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drag(String identifier) {
        new FxRobot().drag(identifier);
    }

    /**
     * Drop a node that is being draged.
     *
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void drop(String identifier) {
        new FxRobot().drop();
    }

    /**
     * Drop to specific node.<br>
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void dropTo(String identifier) {
        new FxRobot().dropTo(identifier);
    }

    /**
     * Move the mouse to a x,y coordinate
     *
     * @param xCoordinate
     *            The x coordinate
     * @param yCoordinate
     *            The y coordinate
     */
    @RobotKeyword
    @ArgumentNames({"xCoordinate", "yCoordinate"})
    public void moveBy(double xCoordinate, double yCoordinate) {
        new FxRobot().moveBy(0, 0, Motion.DIRECT);
    }

    /**
     * Move Mouse to node
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void moveTo(String identifier) {
        new FxRobot().moveTo(identifier, Motion.DIRECT);
    }

    /**
     * Right Click on node
     *
     * @param identifier
     *            The identifier of the node
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public void rightClickOn(String identifier) {
        new FxRobot().rightClickOn(identifier, Motion.DIRECT);
    }

    /**
     * Scroll left
     *
     * @param amount
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollLeft(int amount) {
        new FxRobot().scroll(0, HorizontalDirection.LEFT);
    }

    /**
     * Scroll right
     *
     * @param amount
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollRight(int amount) {
        new FxRobot().scroll(0, HorizontalDirection.RIGHT);
    }

    /**
     * Scroll up
     *
     * @param amount
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollUp(int amount) {
        new FxRobot().scroll(0, VerticalDirection.UP);
    }

    /**
     * Scroll down
     *
     * @param amount
     *            The amount to be scrolled
     */
    @RobotKeyword
    @ArgumentNames({"amount"})
    public void scrollDown(int amount) {
        new FxRobot().scroll(0, VerticalDirection.DOWN);
    }

    /**
     * Get Node list
     *
     * @param identifier
     *          The node identifier that has the list to be returned
     * @return
     *          The nodes
     */
    @RobotKeyword
    @ArgumentNames({"identifier"})
    public Set<Node> getNodeList(String identifier) {
        return new FxRobot().lookup(identifier).queryAll();
    }
}
