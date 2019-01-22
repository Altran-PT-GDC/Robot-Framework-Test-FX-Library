package com.altran.gdc.robotframework.testfxlibrary.utils;

import static java.util.Objects.requireNonNull;

public class TestFxLibraryValidation {

    private TestFxLibraryValidation(){
    }

    /**
     * Validate arguments. This method validate:
     *      If String is null or empty
     *      If Boolean is null
     *
     * @param args
     *      The arguments to validate
     */
    public static void validateArguments(Object... args){
        for(Object obj : args){
            requireNonNull(obj, String.format("Argument %s is null", obj ));

            if (obj instanceof String ){
                if(((String) obj).isEmpty()){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            } else if (obj instanceof Boolean ){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            }
        }


    /**
     * Validate if the parameter timeout is bigger than 0.
     *
     * @param timeout
     *      The timeout parameter
     */
    public static void validateTimeout(Integer timeout){
        if (timeout < 0) {
            throw new IllegalArgumentException(String.format("Argument %s must be positive", timeout));
        }
    }

    /**
     * Validate if the index used to get certain element from list bigger than 0.
     *
     * @param index
     *      The parameter index
     */
    public static void validateIndex(Integer index){
        if (index < 0) {
            throw new IllegalArgumentException(String.format("Argument %s must be positive", index));
        }
    }

}

