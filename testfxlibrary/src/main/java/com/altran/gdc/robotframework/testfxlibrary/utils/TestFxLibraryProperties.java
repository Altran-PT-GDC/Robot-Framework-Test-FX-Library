package com.altran.gdc.robotframework.testfxlibrary.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestFxLibraryProperties {

    private static final Logger LOG = LoggerFactory.getLogger(TestFxLibraryProperties.class);
    private static Properties props;

    static {
        props = new Properties();
        try {
            TestFxLibraryProperties util = new TestFxLibraryProperties();
            props = util.getPropertiesFromClasspath("TestFXLibrary.properties");
        } catch (IOException e) {
            LOG.error("Error!", e);
        }
    }

    private TestFxLibraryProperties() {
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static String getProperty(String key, String defaultValue) {
        return props.getProperty(key, defaultValue);
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
        Properties properties = new Properties();
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException("Property File '" + propFileName + "' Not Found");
        }

        properties.load(inputStream);
        return properties;
    }
}
