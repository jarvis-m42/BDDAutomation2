package org.carnera.utils;


import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

public class ReadConfig {


//    public static void main(String[] args) {
//
//         System.out.println(getBrowser());
//    }

    public static String getAppURL(String appName) {
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("resources/smokeConfig.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Map<String, Object>> obj = yaml.load(inputStream);

        return obj.get(appName).get("webApp").toString();
    }

    public static String getBrowser()
    {
        Yaml yaml = new Yaml();
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("resources/smokeConfig.yml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Map<String, Object> obj = yaml.load(inputStream);

        return obj.get("browser").toString();
    }

}
