package org.mx.mongdb.stu.client;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;
/**
 * 封装数据库连接细节
 * @author Administrator
 *
 */
public class MongoConn {

	/**
	 * ip1:port1,ip2:port2,...
	 */
	private String connectString;
	private String database;
    private static MongoConn conn = null;
    MongoClient client = null ;
    private static final String CONN_PREFIX = "mongodb://";
	private MongoConn() {		
		InputStream is = null;
		Properties pro = new Properties();

		try {
			is = Thread.currentThread().getContextClassLoader().getResourceAsStream("mongo.properties");// new FileInputStream(file);
			pro.load(is);
			/*Enumeration e = pro.propertyNames();
			while (e.hasMoreElements()) {
				String key = (String) e.nextElement();
				String value = (String) pro.get(key);
				proMap.put(key, value);
			}*/
			connectString = CONN_PREFIX+pro.getProperty("connectString");
			database = pro.getProperty("database");
			MongoClientURI uri = new MongoClientURI(connectString);
			client = new MongoClient(uri);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();// 千万别忘了关闭资源哦！
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static MongoConn getInstance() {
		if (conn == null) {
			conn = new MongoConn();
		}
		return conn;
	}

	public MongoClient getClient (){
		return client ;
	}
	public MongoDatabase getDataBase(){
		return client.getDatabase(database);
	}
	public MongoDatabase getDataBase(String database){
		return client.getDatabase(database);
	}
	public static void main(String[] args) {
		MongoConn.getInstance().getDataBase()
				.createCollection("passrecord");
	}
}
