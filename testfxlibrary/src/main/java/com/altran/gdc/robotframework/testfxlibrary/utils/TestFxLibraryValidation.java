package com.altran.gdc.robotframework.testfxlibrary.utils;


import static com.google.common.base.Preconditions.checkNotNull;

public class TestFxLibraryValidation {

    public static void validateArguments(Object... args) throws IllegalArgumentException, NullPointerException{
        for(Object obj : args){
            checkNotNull(obj, String.format("Argument %s is null", obj ));

            if (obj instanceof String ){
                if(((String) obj).isEmpty()){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            }
        }
    }
}
