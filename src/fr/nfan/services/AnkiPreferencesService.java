package fr.nfan.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.nfan.utils.SortedProperties;

public class AnkiPreferencesService {
	
	public static Logger log = LoggerFactory.getLogger(AnkiPreferencesService.class);
	
	private static Properties properties = null;
	
	private static String propertiesPath = "E:\\Project\\Java Anki\\";
	private static String propertiesFileName = "preferences.properties";
	
	public static void initProperties() {
		properties = new SortedProperties();
		File propertiesFile = new File (propertiesPath + propertiesFileName);
		if (! propertiesFile.exists()) {
			ResourceBundle bundle = ResourceBundle.getBundle("preferences");
			Enumeration<String> keys = bundle.getKeys();
			
			while (keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = bundle.getString(key);
				
				properties.put(key, value);
			}
			
			try {
				properties.store(new FileOutputStream(propertiesFile), "Anki Preferences");
			} catch (IOException e) {
				log.error("init Properties failed: ", e);
			}
		} else {
			try {
				properties.load(new FileInputStream(propertiesFile));
			} catch (IOException e) {
				log.error("init Properties failed: ", e);
			}
		}
	}
	
	public static void store() {
		File propertiesFile = new File (propertiesPath + propertiesFileName);
		try {
			properties.store(new FileOutputStream(propertiesFile), "Anki Preferences");
		} catch (IOException e) {
			log.error("Store failed: ", e);
		}
	}
	
	public static String getStringValue(String key) {
		return properties.getProperty(key);
	}
	
	public static boolean getBooleanValue(String key) {
		return Boolean.parseBoolean(properties.getProperty(key));
	}
	
	public static int getIntValue(String key) {
		return Integer.parseInt(properties.getProperty(key));
	}
	
	public static void put(String key, Boolean value) {
		properties.setProperty(key, String.valueOf(value));
	}
	
	public static void put(String key, String value) {
		properties.setProperty(key, value == null ? "" : value);
	}
	
	public static void put(String key, int value) {
		properties.setProperty(key, String.valueOf(value));
	}
	
}
