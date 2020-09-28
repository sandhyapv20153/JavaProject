package main;

public class Constants {
	
	/** The Constant WORKING_DIRECTORY. */
	public static final String WORKING_DIRECTORY = System.getProperty("user.dir");

	/** The Constant CHROME_DRIVER_PATH. */
	public final static String CHROME_DRIVER_PATH = WORKING_DIRECTORY + "\\src\\main\\resources\\drivers\\chromedriver.exe";

	/** The Constant PROJECT_PROPERTYFILE_PATH. */
	public final static String PROJECT_PROPERTYFILE_PATH = WORKING_DIRECTORY + "\\src\\test\\resources\\project.properties";
	
	/** The Constant OFFERVALUE_JSON_PATH. */
	public final static String OFFERVALUE_JSON_PATH = WORKING_DIRECTORY + "\\src\\test\\resources\\OfferValue.json";
	
	
	/** The Constant USER_JSON_PATH. */
	public final static String USER_JSON_PATH = WORKING_DIRECTORY + "\\src\\test\\resources\\User.json";



}
