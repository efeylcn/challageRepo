package Utils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {

    public static String getProperties(String key)throws IOException {
        Properties properties=new Properties();
        properties.load(new FileReader(new File("src/test/resources/Configs/Configuration.properties")));
        String value= properties.getProperty(key);
        return value;
    }
}
