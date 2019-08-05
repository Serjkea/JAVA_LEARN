package ru.practics.configuration;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="Configuration")
@XmlType(propOrder={"name", "language","port"})
public class Configuration {
	
	private String name;
	private String password;
	private String language;
	private int port;
	
	public Configuration() {		
	}
	
	public Configuration(String name, String password, String lang, int port) {
		this.name = name;
		this.password = password;
		this.language = lang;
		this.port = port;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	@XmlTransient
	public String getPassword() {
		return this.password;
	}
	
	public void setLanguage(String lang) {
		this.language = lang;
	}
	
	@XmlElement(name = "lang")
	public String getLanguage() {
		return this.language;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return this.port;
	}
	
	@Override
	public String toString() {
		return "name: " + this.name + " language: " + this.language + " port: " + this.port;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode()*31 + this.password.hashCode()*31 + this.language.hashCode()*31 + this.port*31;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		else if (this == obj) return true;
		else if (obj instanceof Configuration) {
			Configuration tmp = (Configuration) obj;
			return this.name.equals(tmp.name) &&
			       this.password.equals(tmp.password) &&
			       this.language.equals(tmp.language) &&
			      (this.port == tmp.port);
		} else return false;
	}
	
}
