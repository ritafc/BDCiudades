package com.rita.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import java.sql.PreparedStatement;
import com.rita.models.City;
import com.rita.models.Country;
import com.rita.models.Language;


public class CiudadesDAO extends DAO {

	private static CiudadesDAO instance=null;

	
	public static final CiudadesDAO getInstance() throws Exception {
		if(instance==null) instance= new CiudadesDAO();
		return instance;
	}
	
	private CiudadesDAO() throws Exception {
		
	}
	
	public List<City> getLista( String countryCode) {
		List<City> resultado =new ArrayList<City>();
		
		try {
			Connection conn = datasource.getConnection();

			
			String sql=countryCode!=null && !countryCode.equals("")?"SELECT c.*, ct.* FROM city c LEFT JOIN country ct ON c.CountryCode=ct.Code where c.CountryCode=?":"SELECT c.*, ct.* FROM city c LEFT JOIN country ct ON c.CountryCode=ct.Code";;
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			
			
			if(countryCode!=null && !countryCode.equals("")) {
				stmt.setString(1,countryCode);
			}
			
		 	ResultSet rs=stmt.executeQuery();
		 	
		 	City tempCity=null;
			while(rs.next()) {
				tempCity=(new City(rs.getInt("id"),
									rs.getString("name"),
									rs.getString("district"),
									rs.getInt("population")
						));
				tempCity.setCountry(new Country(rs.getString("code"),rs.getString("ct.name")));
				resultado.add(tempCity);

			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return resultado;
	}
	
	
	public City getCiudad(int idCity) {
		City unaCiudad =null;
		try {
			Connection conn = datasource.getConnection();
			
			String sql="SELECT * FROM city where id=?";
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1,idCity);
			
			
		 	ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				unaCiudad=new City(rs.getInt("id"),rs.getString("name"),rs.getString("countrycode"),rs.getString("district"),rs.getInt("population"));
				break;
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return unaCiudad;
	}
	
	
	public boolean UpdateCiudad( City cityToUpdate) {
		boolean result=false;
		try {
			Connection conn =datasource.getConnection();
			
			String sql="UPDATE city SET name = ?, CountryCode=?, District =?, Population=? WHERE id=?" ;
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, cityToUpdate.getName());
			stmt.setString(2, cityToUpdate.getCode());
			stmt.setString(3, cityToUpdate.getDistrict());
			stmt.setInt(4, cityToUpdate.getPopulation());
			stmt.setInt(5, cityToUpdate.getId());
			
		 	int isOk=stmt.executeUpdate();
			result=true;

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	

	public int InsertarCiudad( City cityToInsert) {
		int result=0;
		try {
			Connection conn = DriverManager.getConnection(url);
			
			String sql="INSERT INTO city (name, CountryCode, District, Population) VALUES (?,?,?,?)";
			
			PreparedStatement stmt=datasource.getConnection();
			stmt.setString(1,cityToInsert.getName());
			stmt.setString(2,cityToInsert.getCode());
			stmt.setString(3,cityToInsert.getDistrict());
			stmt.setInt(4,cityToInsert.getPopulation());
			
			
		 	stmt.executeUpdate();
		 	
		 	ResultSet rs=stmt.getGeneratedKeys();
		 	while (rs.next()) {
				result=rs.getInt(1);
			}
			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	public boolean DeleteCiudad( int idCity ) {
		boolean result=false;
		try {
			Connection conn = datasource.getConnection();
			String sql="DELETE FROM city WHERE id=?" ;
			
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setInt(1, idCity);
			
		 	int isOk=stmt.executeUpdate();
			result=true;

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} 
		return result;
	}
	
	
	public int InsertarCiudadPais( City cityToInsert,Country countryToInsert) throws SQLException {
		int result=0;
		Connection conn=null;
		try {
			conn = datasource.getConnection();//DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			
			String sqlPais="INSERT INTO country (name, code, Continent,region,surfaceArea,Population,LocalName,GovernmentForm,Code2) "
					+ "VALUES (?,?,?,?,?,?,?,?,?)";
			
			PreparedStatement stmtp=conn.prepareStatement(sqlPais);
			stmtp.setString(1,countryToInsert.getName());
			stmtp.setString(2, countryToInsert.getCode());
			stmtp.setString(3,"Oceania");
			stmtp.setString(4,"LATAM");
			stmtp.setFloat(5,1000);
			stmtp.setInt(6,1000);
			stmtp.setString(7,"my-my");
			stmtp.setString(8,"DictatorShip");
			stmtp.setString(9,"CO");
			
			stmtp.executeUpdate();
			
			String sql="INSERT INTO city (name, CountryCode, District, Population) VALUES (?,?,?,?)";
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1,cityToInsert.getName());
			stmt.setString(2,countryToInsert.getCode());
			stmt.setString(3,cityToInsert.getDistrict());
			stmt.setInt(4,cityToInsert.getPopulation());
			
		 	stmt.executeUpdate();
		 	
		 	ResultSet rs=stmt.getGeneratedKeys();
		 	while (rs.next()) {
				result=rs.getInt(1);
			}
		 	conn.commit();
		 	
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} 
		return result;
	}

	
}
