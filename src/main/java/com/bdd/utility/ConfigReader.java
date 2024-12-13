package com.bdd.utility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
public class ConfigReader {

    Properties props;
    public ConfigReader LoadConfig(String properties_file_withextension) throws IOException {
        String file =System.getProperty("user.dir")+"/src/test/resources/"+properties_file_withextension;
        FileReader reader=new FileReader(file);
        Properties props=new Properties();
        try {
            props.load(reader);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public String GetValue(String key)
    {
        return props.getProperty(key);
    }
}