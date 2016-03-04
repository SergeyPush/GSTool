package utils;

import java.io.IOException;
import java.util.Properties;


public class Property_Loader {

    private static final String PROP_FILE = "/application.properties";

    public static String loadProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(Property_Loader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
