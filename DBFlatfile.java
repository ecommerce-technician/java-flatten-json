import java.sql.*;
import java.util.Properties;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Map;

import java.util.Iterator;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import com.github.wnameless.json.flattener.JsonFlattener;
import com.github.wnameless.json.unflattener.JsonUnflattener;

public class DBFlatfile
{
	//JDBC
	private static final String dbClassName = "com.mysql.jdbc.Driver";
	private static final String CONNECTION = "jdbc:mysql://127.0.0.1/optimum";
	//private static final String currentDir = System.getProperty("user.dir"));

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws ClassNotFoundException,SQLException 
	{
		//create mysql connection
		System.out.println(dbClassName);
		Class.forName(dbClassName);
		Properties p = new Properties();
		p.put("user","default");
		p.put("password","vanilla");
	
		//test mysql connection
		Connection c = DriverManager.getConnection(CONNECTION,p);
		System.out.println("Mysql Connected!");
		c.close();	
		
		//JSON
	       JSONParser parser = new JSONParser();
 
	        try {
 
	            Object obj = parser.parse(new FileReader(
                    "/home/alex/Code/flatfile/fintech.json"));
	            JSONObject jsonObject = (JSONObject) obj;
			// JsonFlattener: A Java utility used to FLATTEN nested JSON objects
			String flattenedJson = JsonFlattener.flatten(jsonObject.toString());
			log("\n=====Simple Flatten===== \n" + flattenedJson);
 
			Map<String, Object> flattenedJsonMap = JsonFlattener.flattenAsMap(jsonObject.toString());
 
			log("\n=====Flatten As Map=====\n" + flattenedJson);
			// We are using Java8 forEach loop. More info: http://crunchify.me/1VIwm0l
			flattenedJsonMap.forEach((k, v) -> log(k + " : " + v));
 
			// Unflatten it back to original JSON
			String nestedJson = JsonUnflattener.unflatten(flattenedJson);
			System.out.println("\n=====Unflatten it back to original JSON===== \n" + nestedJson);
 
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
}
