package Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Common {
    public static final Logger LOGGER = LoggerFactory.getLogger(Common.class);
    public static PropertyReader pageElements = PropertyReader.getPageElementInstance();
    public static PropertyReader testConfigs = PropertyReader.getTestConfigInstance();
    public static PropertyReader testData = PropertyReader.getTestDataInstance();



}
