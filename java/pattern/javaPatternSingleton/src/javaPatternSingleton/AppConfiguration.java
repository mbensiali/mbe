package javaPatternSingleton;

public class AppConfiguration {

	private static AppConfiguration instance = null;
	
	public static AppConfiguration getInstance(){
		if (instance == null){
			instance = new AppConfiguration();
		}
		return instance;
	}

	public AppConfiguration() {
	}
	
	
}
