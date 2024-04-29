package mainTestExamples;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	public Properties prop;

    public ConfigFileReader(String filePath) {
        
    	prop = new Properties();
        
    	try {
            FileInputStream fis = new FileInputStream("C:\\Users\\babar.mumtaz\\SATW6\\BareGitRepo\\SATW6\\Config File\\config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }   	
    	
    }
       

    public String getPropertyValues(String key) {
        return prop.getProperty(key);  
    }
}
	
	

//    public static String getUrl() {
//        return propertiesObj.getProperty("url");
//    }

