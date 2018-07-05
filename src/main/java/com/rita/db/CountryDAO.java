
package com.rita.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.rita.models.Country;
import com.rita.models.Language;


public class CountryDAO  extends DAO{
	private static CountryDAO instance=null;
	private DataSource datasource;
	
	public static final CountryDAO getInstance() throws Exception {
		if(instance==null) instance=new CountryDAO();
		return instance;
	}
	
	
	private CountryDAO() throws Exception {
		
	}
	
	public List<Country> getLista() {
		List<Country> resultado =new ArrayList<Country>();
		try {
			Connection conn = datasource.getConnection();
			Statement stmt=conn.createStatement();
		 	
			ResultSet rs=stmt.executeQuery("SELECT c.Name, c.Code, cl.* FROM country c LEFT JOIN countrylanguage cl ON cl.CountryCode=c.Code");
		 	
		 	Country tempCountry=null;
			while(rs.next()) {
				if(tempCountry==null) {
					tempCountry=new Country(rs.getString("Code"), rs.getString("Name"));
					tempCountry.setLanguages(new ArrayList<Language>());
				}else if(!rs.getString("Code").equals(tempCountry.getCode())) {
					resultado.add(tempCountry);
					tempCountry=new Country(rs.getString("Code"), rs.getString("Name"));
					tempCountry.setLanguages(new ArrayList<Language>());
				}
				tempCountry.getLanguages().add(
						new Language(
						rs.getString("language"),
						rs.getString("isOfficial")!=null?(rs.getString("isOfficial").equals("T")?true:false):false,
						rs.getDouble("percentage")
						)
						);
				
				
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultado;
	}
	
	
}