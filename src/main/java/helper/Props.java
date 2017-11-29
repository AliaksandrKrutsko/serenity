package helper;


public enum Props {

    BROWSER("chrome"),
    GECKODRIVER("src/main/resources/geckodriver.exe"),
    CHROMEDRIVER("src/main/resources/chromedriver.exe"),
    LOGIN("android11@epam.com"),
    USER("android12 android"),
    PASSWORD("abc12345"),
    TIMEOUT("30");

    private String myProp;

    Props(String prop) {
        myProp = prop;
    }

    public String get() {
        return myProp.toLowerCase();
    }

}
