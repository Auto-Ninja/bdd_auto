package com.bdd.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    static Properties props;
    public ConfigReader LoadConfig(String properties_file_withextension) throws IOException {
        String filePathString =System.getProperty("user.dir")+"/src/test/resources/"+properties_file_withextension;
        System.out.println(filePathString);
        File f = new File(filePathString);
        if(f.exists() && !f.isDirectory()) {
            FileReader reader = new FileReader(filePathString);
            props = new Properties();
            try {
                props.load(reader);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            throw new FileNotFoundException("No file found with name "+properties_file_withextension);
        }
        return this;
    }

    public String GetValue(String key)
    {
        return this.props.getProperty(key);
    }
}