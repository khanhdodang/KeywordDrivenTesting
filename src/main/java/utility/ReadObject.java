package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadObject {

    Properties properties = new Properties();

    public Properties getObjectRepository() {
        try {
            //Read object repository file
            InputStream stream = new FileInputStream(new File(System.getProperty("user.dir") + "/src/test/resources/objects.properties"));
            //load all objects
            properties.load(stream);
            return properties;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

}
