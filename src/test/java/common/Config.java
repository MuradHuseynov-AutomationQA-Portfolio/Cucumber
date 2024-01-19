package common;
public class Config {
    /**
     * Specify the browser for test
     * CHROME
     * MOZILA
     * EDGE
     * OPERA
     **/
    public static final String BROWSER = "CHROME";

    /** Clean browser cookies after each test method */
    public static final Boolean CLEAR_COOKIES = true;

    /** Close the browser after each test method */
    public static final Boolean CLOSE_BROWSER = true;

    /** Clear the directory with the screenshots before the build */
    public static final Boolean CLEAR_REPORTS_DIR = true;
}
