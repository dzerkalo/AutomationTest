package framework.utils;

import java.io.IOException;
import java.util.Properties;

/**
 * PropertyLoader class follows Singleton pattern
 */
public class PropertyLoader {
	private static final String PROPERTIES_FILE = "/config.properties";
	private static final PropertyLoader INSTANCE = new PropertyLoader();

	private final Properties properties;

	private PropertyLoader() {
		properties = new Properties();

		loadPropertiesFromFile();
	}

	public static PropertyLoader getInstance() {
		return INSTANCE;
	}

	public String getUsername() {
		return properties.getProperty("user.username");
	}

	public String getPassword() {
		return properties.getProperty("user.password");
	}

	public String getAppUrl() {
		return properties.getProperty("site.url");
	}

	public String getBrowserName() {
		return System.getProperty("browser") != null ? System.getProperty("browser") : properties.getProperty("browser");
	}

	private void loadPropertiesFromFile() {
		try {
			properties.load(PropertyLoader.class.getResourceAsStream(PROPERTIES_FILE));
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Can't get properties from " + PROPERTIES_FILE, e);
		}
	}
}