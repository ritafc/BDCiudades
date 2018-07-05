package com.rita.db;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.rita.utils.PropertyValues;

public class DAO {
	protected static String url=null;
	protected DataSource datasource;
	
	protected DAO() throws Exception {
		/*Properties props=new PropertyValues().getPropValues();
		Class.forName(props.getProperty("dbdriver")).newInstance();
		this.url=props.getProperty("url")+"/"+props.getProperty("database")+"?user="+props.getProperty("user")+"&password="+props.getProperty("password");
		*/
		
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env"); 
		datasource = (DataSource)envContext.lookup("jdbc/TestDB");
	
		
		
		
	
		
		
				
	}
	
	
	
}
