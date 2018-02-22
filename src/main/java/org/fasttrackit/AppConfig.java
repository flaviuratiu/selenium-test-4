package org.fasttrackit;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppConfig {

    private static Properties properties = new Properties();

    static {
        InputStream inputStream =
                AppConfig.class.getClassLoader().getResourceAsStream("production.properties");

        try {
            properties.load(inputStream);
        } catch (IOException e) {
            System.out.println("Could not read properties file.");
        }
    }

    private static String chromeDriverPath = properties.getProperty("chrome.driver.path");
    private static String siteUrl = properties.getProperty("site.url");

    public static String getChromeDriverPath() {
        return chromeDriverPath;
    }

    public static String getSiteUrl() {
        return siteUrl;
    }
}
