package helper;

import java.io.InputStream;
import java.util.Properties;

public class DriverConfig {

    private static Properties config = new Properties();
    private static InputStream is = DriverConfig.class.getResourceAsStream("/DriverConfig.properties");

    static {
        try {
            config.load(is);
        } catch (Exception e) {
            System.out.println("Error reading from property file");
        }
    }

    public static String browser() {
        return config.getProperty("browser");
    }

    public static String geckodriver() {
        return config.getProperty("geckodriver");
    }

    public static String chromedriver() {
        return config.getProperty("chromedriver");
    }

    public static String login() {
        return config.getProperty("login");
    }

    public static String user() {
        return config.getProperty("user");
    }

    public static String password() {
        return config.getProperty("password");
    }

    public static int timeout() {
        int result = 15;
        try {
            result = Integer.parseInt(config.getProperty("timeOut"));
        } catch (NumberFormatException e) {
            //todo logging
        }
        return result;
    }

}
