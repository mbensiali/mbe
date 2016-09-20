package javaPatternBuilderBDD;

public interface IConfigApp {
	String getConfigValue(String name);
	void setConfigValue(String name, String value);
	void save();
	void load();	
}
