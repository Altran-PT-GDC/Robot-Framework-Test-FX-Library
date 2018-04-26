package com.altran.gdc.robotframework.testfxlibrary.utils;

import java.util.HashMap;
import java.util.Map;

public class TestFXLibraryCache {

    private static TestFXLibraryCache instance = null;
    private Map<String, Object> map = new HashMap<>();
    private TestFXLibraryCache(){
    }

    public static synchronized TestFXLibraryCache getIstance(){
        if (instance == null) {
            instance = new TestFXLibraryCache();
        }
        return instance;
    }

    public void put(String key, Object obj){
        map.put(key, obj);
    }

    public Object get(String key) {
        return map.get(key);
    }

    public Map<String, Object> getMap(){
        return map;
    }

}
