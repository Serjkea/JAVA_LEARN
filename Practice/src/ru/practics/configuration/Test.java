package ru.practics.configuration;

import java.util.HashMap;
import java.util.Properties;

public class Test {
	
	public static void main(String[] args) {
		Properties prop = new Properties();
		prop.put("lang1", "es");
		prop.put("lang2", "ru");
		Config<Properties> config1 = ConfigFactory.getPropertiesConfig(prop, "/home/kostenko/Projects/Java/");
		Config<Object> config2 = ConfigFactory.getConfig(prop, "/home/kostenko/Projects/Java/");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("lang1", "es");
		map.put("lang2", "ru");
		Config<HashMap<String,String>> config3 = ConfigFactory.getMapConfig(map, "/home/kostenko/Projects/Java/");
		config1.saveConfig();
		config2.saveConfig();
		config3.saveConfig();
		Configuration prop1 = new Configuration("admin","12345","ru",8000);
		Config<Object> config = ConfigFactory.getXmlConfig(prop1, "/home/kostenko/Projects/Java/", prop1.getClass());
		config.saveConfig();
		Configuration prop2 = (Configuration) config.loadConfig();
		System.out.println(prop2);
	}

}
