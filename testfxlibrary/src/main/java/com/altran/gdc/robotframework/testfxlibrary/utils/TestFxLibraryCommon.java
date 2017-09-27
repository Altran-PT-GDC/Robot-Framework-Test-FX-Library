package com.altran.gdc.robotframework.testfxlibrary.utils;

import javafx.scene.Node;
import org.python.google.common.collect.Iterables;
import org.testfx.api.FxRobot;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestFxLibraryCommon {

    private static final String PATTERN_COMPILE = ".*\\[\\d\\].*";
    private static final int FIRST_POSITION = 1;
    private static final int SECOND_POSITION = 2;
    private static final int THIRD_POSITION = 3;

    /**
     * Method lookup to search specific Node.
     *
     * Example: {id_parent}//{id_component}[x]
     *
     * @param lookup
     *      The string to search
     * @param <T>
     *      Generic Node Object
     * @return
     *      The Node
     */
    public static <T extends Node> T lookup(String lookup){
        T node = null;

        List<Node> nodes = new ArrayList<>();
        String nth = null;
        String identifier = null;

        String[] lookupStr = lookup.split("//");

        // Check if has position to get element from Node list
        String position = lookupStr[lookupStr.length-1];

        int positionLength = position.length();

        if(hasPosition(position)){
            nth = position.substring(positionLength-SECOND_POSITION, positionLength-FIRST_POSITION);
            identifier = position.substring(0, positionLength-THIRD_POSITION);

        } else {
            identifier = position.substring(0, positionLength);
        }

        // Search Nodes and check if have children
        if(lookupStr.length > 1){

            if(hasPosition(lookupStr[0])){

                String index = lookupStr[0].substring(lookupStr[0].length()-SECOND_POSITION, lookupStr[0].length()-FIRST_POSITION);
                String id = lookupStr[0].substring(0, lookupStr[0].length()-THIRD_POSITION);
                Set<T> n = new FxRobot().lookup(id).queryAll();
                nodes.add(Iterables.get(n,Integer.valueOf(index)));
            } else {
                for(int i=0 ; i<lookupStr.length - 1; i++){
                    Node n = new FxRobot().lookup(lookupStr[i]).query();
                    nodes.add(n);
                }
            }

            if(nth != null){
                Set<T> nodeList = new FxRobot().from(nodes).lookup(identifier).queryAll();
                node = Iterables.get(nodeList, Integer.valueOf(nth));
            } else {
                node = new FxRobot().from(nodes).lookup(identifier).query();
            }

        }else{
            if(nth != null){
                Set<T> nodeList = new FxRobot().lookup(identifier).queryAll();
                node = Iterables.get(nodeList, Integer.valueOf(nth));
            } else {
                node = new FxRobot().lookup(identifier).query();
            }
        }
        return node;
    }

    /**
     * Verify if the string has the characters [x]
     *
     * @param position
     *      The string to validate the text
     * @return
     *      true if contains or false if not contains.
     */
    private static boolean hasPosition(String position){
        Pattern pattern = Pattern.compile(PATTERN_COMPILE);
        Matcher matcher = pattern.matcher(position);
        return matcher.matches();
    }
}
