package javaPatternFabrique1;

public class Program {

	public static void main(String[] args) {
		AppFactory factory = new AppFactory();
		
		IConfigApp cfg3 = factory.BuildConfig("database", "langage=francais;savedir=svg");
		System.out.println(cfg3.getConfigValue("langage"));
	}

}
