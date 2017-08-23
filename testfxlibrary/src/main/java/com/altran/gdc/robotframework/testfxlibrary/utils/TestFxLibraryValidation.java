package com.altran.gdc.robotframework.testfxlibrary.utils;


import com.altran.gdc.robotframework.testfxlibrary.keywords.Timeout;

import static com.google.common.base.Preconditions.checkNotNull;

public class TestFxLibraryValidation {

    public static void validateArguments(Object... args) throws IllegalArgumentException, NullPointerException{
        for(Object obj : args){
            checkNotNull(obj, String.format("Argument %s is null", obj ));

            if (obj instanceof String ){
                if(((String) obj).isEmpty()){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            } else if (obj instanceof Boolean ){
                if(((Boolean) obj) == null){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            }
        }
    }

    public static void validateTimeout(Integer timeout) throws IllegalArgumentException, NullPointerException {
        if (timeout < 0) {
            throw new IllegalArgumentException(String.format("Argument %s must be positive", timeout));
        }
    }

}

