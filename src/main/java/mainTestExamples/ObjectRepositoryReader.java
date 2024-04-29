package mainTestExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ObjectRepositoryReader {
	
	/*
	 * To read data from the Properties file, we need to use the built-in Properties
	 * class that is available in Java.util.package. So one needs to create an
	 * object of Properties class:
	 */
	
	Properties propObj;

	
	/*
	 * The ObjectRepository class has a constructor that takes a file path (filePath) as a parameter. 
	 * It initializes the Properties object (propObj) and loads the properties file using a FileInputStream.
	 */
	
    public ObjectRepositoryReader(String filePath) {
    	
    	propObj = new Properties();
        
    	try {
    		// need to create an object of FileInputStream class with its path pointing to the .properties file:
            FileInputStream inputStream = new FileInputStream("C:\\Users\\babar.mumtaz\\SATW6\\BareGitRepo\\SATW6\\Config File\\ObjectRepo.properties");
            
            propObj.load(inputStream);
        } 
    	
    	catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    // The getLocator() method retrieves the locator for the specified elementName from the Properties object and returns it.

    public String getLocator(String elementName) {
        return propObj.getProperty(elementName);
    }

}
