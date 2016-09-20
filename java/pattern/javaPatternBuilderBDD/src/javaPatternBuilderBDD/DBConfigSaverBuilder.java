package javaPatternBuilderBDD;

public class DBConfigSaverBuilder {
	
	private DBConfigSaver DBConfig1;
	
	public DBConfigSaverBuilder(String url) {
		DBConfig1 = new DBConfigSaver(url);
	}
	
	public DBConfigSaverBuilder driverClass(String DrvClass) {
		DBConfig1.setDriverClass(DrvClass);
		return this;
	}
	public DBConfigSaverBuilder login(String login) {
		DBConfig1.setLogin(login);
		return this;
	}
	
	public DBConfigSaverBuilder password(String pass) {
		DBConfig1.setPassword(pass);
		return this;
	}
	
	public DBConfigSaverBuilder table(String table){
		DBConfig1.setTable(table);
		return this;
	}

	public DBConfigSaverBuilder cle(String cle){
		DBConfig1.setCle(cle);
		return this;
	}
	
	public DBConfigSaverBuilder valeur(String value){
		DBConfig1.setValeur(value);
		return this;
	}
	
	
	public DBConfigSaver build() {
		return DBConfig1;
	}


}
