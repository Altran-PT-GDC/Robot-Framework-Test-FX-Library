package com.altran.gdc.robotframework.testfxlibrary.utils;

import com.altran.gdc.robotframework.testfxlibrary.keywords.Logging;
import org.robotframework.javalib.annotation.Autowired;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestFxLibraryProperties {

    private static Properties props;

    @Autowired
    private Logging LOG;

    static {
        props = new Properties();
        try {
            TestFxLibraryProperties util = new TestFxLibraryProperties();
            props = util.getPropertiesFromClasspath("testfxlibrary.properties");
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    private TestFxLibraryProperties() {
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static void setProperty(String keyName, String propertyValue){
        props.setProperty(keyName, propertyValue);
    }

    /**
     * Loads properties file
     *
     * @param propFileName
     * @return
     * @throws IOException
     */
    private Properties getPropertiesFromClasspath(String propFileName) throws IOException {
        Properties props = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException("Property File '" + propFileName + "' Not Found");
        }

        props.load(inputStream);
        return props;
    }
}
