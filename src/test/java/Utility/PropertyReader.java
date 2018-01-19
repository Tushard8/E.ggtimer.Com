package Utility;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    public Properties prop = new Properties();
    InputStream inputStream ;

    private static String User_directory= System.getProperty("user.dir")+ File.separator;
    private static String elementlocatorPath = User_directory+"src/test/resources/Config/elementlocator.properties";
    private static String environmentPath=User_directory+"src/test/resources/Config/environment.properties";
    private static String testDataPath=User_directory+"src/test/resources/TestData/testdata.properties";



    private PropertyReader(String path) {

        //log.log_library_track("in PropertyReader Constructor- start");
        loadProperties(path);
        //log.log_library_track("in PropertyReader Constructor- End");
    }

    static PropertyReader pageElementPropertyInstance = new PropertyReader(elementlocatorPath);
    //make the constructor private so that this class cannot be
    //instantiated


    //Get the only object available
    public static PropertyReader getPageElementInstance(){
        return pageElementPropertyInstance;
    }

    static PropertyReader testDataInstance = new PropertyReader(testDataPath);
    //make the constructor private so that this class cannot be
    //instantiated


    //Get the only object available
    public static PropertyReader getTestDataInstance(){
        return testDataInstance;
    }

    static PropertyReader testConfigPropertyInstance = new PropertyReader(environmentPath);
    //make the constructor private so that this class cannot be
    //instantiated


    //Get the only object available
    public static PropertyReader getTestConfigInstance(){
        return testConfigPropertyInstance;
    }
    public void  loadProperties(String propFilePath) {
        //log.log_library_track("in PropertyReader-LoadProperties- start");

        //String configLocation = System.getProperty("user.dir")+File.separator +"src/test/resources/config/";

                //log.log_library_track("from main file user directory= "+User_directory);
                //System.out.println("from main file user directory= "+User_directory);
                //log.log_library_track("from main file Property File Path= "+propFilePath);

        //inputStream = new FileInputStream(configLocation+propFileName);
        try {
            if (propFilePath!= null) {
                inputStream = new FileInputStream(propFilePath);
                prop.load(inputStream);
                //log.log_library_track("     in LoadProperties- file loaded");
            }
            else {
                //log.log_library_error("     in LoadProperties- file not loaded");
            }
        } catch (IOException e) {
                //log.log_library_error("     in LoadProperties- Exception");
            e.printStackTrace();
        }
                //log.log_library_track("in PropertyReader-LoadProperties- Finish");

    }

    public String readProperty(String key) {
        return prop.getProperty(key);
    }

    public String getDevice() {

        return readProperty("DEVICE");

    }
    public String getBrowser() {

        return readProperty("LOCAL_BROWSER");
    }






}
