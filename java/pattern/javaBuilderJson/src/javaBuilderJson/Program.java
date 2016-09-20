package javaBuilderJson;

import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class Program {

	public static void main(String[] args) {
		
		PrintWriter pw = new PrintWriter(System.out);
		
		JsonWriter jsonWriter = Json.createWriter(pw);
		JsonObjectBuilder builder1 = Json.createObjectBuilder();
		builder1.add("nom", "bob")
		        .add("prenom","charles")
		        .add("java",true);
		
		JsonObject jobj1 = builder1.build();
		
		jsonWriter.writeObject(jobj1);
		jsonWriter.close();

	}

}
