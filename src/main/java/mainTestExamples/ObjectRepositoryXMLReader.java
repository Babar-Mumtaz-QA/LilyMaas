package mainTestExamples;

import java.io.FileInputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;
import org.dom4j.DocumentException;

public class ObjectRepositoryXMLReader {

    String usernameField;
    String passwordField;
    String loginButton;

    public ObjectRepositoryXMLReader(String filePath) throws IOException, DocumentException 
    
    {
        FileInputStream inputFile = new FileInputStream("/SATW6/properties.xml");
        SAXReader saxReader = new SAXReader();
        
        Document document = saxReader.read(inputFile);
        usernameField = document.selectSingleNode("//menu/usernameField").getText();
        passwordField = document.selectSingleNode("//menu/passwordField").getText();
        loginButton = document.selectSingleNode("//menu/loginButton").getText();
    }

    // Getter methods for accessing the values
    public String getMobileTesting() {
        return usernameField;
    }

    public String getEmailTextBox() {
        return passwordField;
    }

    public String getSignUpButton() {
        return loginButton;
    }
}
