package ru.practics.configuration;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XmlConfig implements Config<Object>{

	private static final String FILE_NAME= "config.xml";
	private static final String DEFAULT_PATH = System.getProperty("user.dir");
	private String PATH;
	
	private Object properties;
	private Class objClass;
	
	XmlConfig(Object properties, Class objClass) {	
		this.PATH = DEFAULT_PATH;
		this.properties = properties;
		this.objClass = objClass;
	}
	
	XmlConfig(Object properties,String path, Class objClass) {
		this.PATH = path;
		this.properties = properties;
		this.objClass = objClass;
	}
	
	@Override
	public Object loadConfig() {
		try {
			JAXBContext context = JAXBContext.newInstance(objClass);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			return (Object) unmarshaller.unmarshal(new File(PATH + FILE_NAME)); 
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return null;
	}	

	@Override
	public void saveConfig() {
		try {
			JAXBContext context = JAXBContext.newInstance(objClass);
			Marshaller marshaller = context.createMarshaller();
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marshaller.marshal((objClass.cast(this.properties)), new File(PATH + FILE_NAME));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}

	public void setDefaultProperties(Object defaultProperties) {
		this.properties = defaultProperties;
	}

	public Object getDefaultProperties() {
		return this.properties;
	}

}
