package nisha.utilities;

import org.apache.log4j.Logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
/**
 * Represents the Logger functionality helper class.
 * @author Nisha Vekariya
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(Class clas) {
		if(root){
			return Logger.getLogger(clas);
		}
		
		PropertyConfigurator.configure(ConstantsHelper.log4jPropertyFilePath);
		root = true;
		return Logger.getLogger(clas);
	}

}
