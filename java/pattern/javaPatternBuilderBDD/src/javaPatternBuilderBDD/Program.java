package javaPatternBuilderBDD;

import javaPatternBuilderBDD.DBConfigSaverBuilder;
import javaPatternBuilderBDD.IConfigApp;

public class Program {

	public static void main(String[] args) {
		IConfigApp cfg3 = new DBConfigSaverBuilder("jdbc:mysql...")
				.login("root")
				.table("myconfigtable")
				.build();


	}

}
