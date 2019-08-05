package ru.practics.configuration;

public interface Config<T> {
	
	public T loadConfig();
	public void saveConfig();

}
