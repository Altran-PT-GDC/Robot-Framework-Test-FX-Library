package com.altran.gdc.robotframework.testfxlibrary.utils;




import static com.google.common.base.Preconditions.checkNotNull;

public class TestFxLibraryValidation {

    public static void validateArguments(Object... args){
        for(Object obj : args){
            checkNotNull(obj, String.format("Argument %s is null", obj ));

            if (obj instanceof String ){
                if(((String) obj).isEmpty()){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            } else if (obj instanceof Boolean && ((Boolean) obj) == null ){
                    throw new IllegalArgumentException(String.format("Argument %s is empty", obj));
                }
            }
        }


    public static void validateTimeout(Integer timeout){
        if (timeout < 0) {
            throw new IllegalArgumentException(String.format("Argument %s must be positive", timeout));
        }
    }

    public static void validateIndex(Integer index){
        if (index < 0) {
            throw new IllegalArgumentException(String.format("Argument %s must be positive", index));
        }
    }

}

