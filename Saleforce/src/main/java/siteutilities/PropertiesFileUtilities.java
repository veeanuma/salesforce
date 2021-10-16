package siteutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesFileUtilities {
	public static String getValueInPropertiesFile(String Propertyname) throws Exception
	{
		String pfpath=System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties";
		FileInputStream fi=new FileInputStream(pfpath);
		Properties p=new Properties();
		p.load(fi);
		String value=p.getProperty(Propertyname);
		fi.close();
		return(value);
		
	}

}
