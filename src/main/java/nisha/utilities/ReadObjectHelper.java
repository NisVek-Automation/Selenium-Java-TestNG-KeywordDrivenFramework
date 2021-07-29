package nisha.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * Represents the excelsheet functionality helper class.
 * @author Nisha Vekariya
 * @version 1.0
 */
public class ReadObjectHelper {
	
	Properties p = new Properties();
	
    public Properties getObjectRepository(String objectPropertyFileName) throws IOException{
        //Read object repository file
        InputStream stream = new FileInputStream(new File(ConstantsHelper.pageObjectPropertyPath + objectPropertyFileName));
        //load all objects
        p.load(stream);
         return p;
    }
}
