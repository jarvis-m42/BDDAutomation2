package org.carnera.Utility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {

    public Properties getProperty(){
        Properties properties=new Properties();
        try{
            properties.load(new FileInputStream("/Users/harender/IdeaProjects/BDDAutomation2/src/test/resources/browserConfig.properties"));
        }catch (Exception e){
            System.out.println("Exception: "+e);
        }
        return properties;
    }

}
