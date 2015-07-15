package com.nana.common.utils;

import java.util.HashMap;
import java.util.Map;

import com.nana.common.utils.Files;

public class Property {
	private static final String CONFIG_FILE = "config.properties";
	private Map<String, String> configMap = new HashMap<String, String>();
	private static Property testResManager;

	public static Property getInstance() {
		if (testResManager == null) {
			try {
				testResManager = new Property();
			} catch (Exception e) {
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
		return testResManager;
	}

	public Property() throws Exception {
		configMap = Files.loadPropertiesFile(Property.CONFIG_FILE);
	}

	public String getCfg(String key) {
		return configMap.get(key);
	}

}
