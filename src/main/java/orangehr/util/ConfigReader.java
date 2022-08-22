package orangehr.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private Properties prop;
	
	/**
	 * loads the properties from config file
	 * @return prop
	 * @throws IOException
	 */
	public Properties init_prop() throws IOException {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("./src/test/resources/orangehr/config/config.properties");
		prop.load(ip);	
		return prop;
	}
}
