package es.data.sql;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class ConnectionSQL {
	private Connection dbCon;
	private MysqlDataSource dataSource;
	private String url = "jdbc:mysql://127.0.0.1:3306/jobmatching";
	private String driver = "com.mysql.jdbc.Driver";
	private String servername = "127.0.0.1";
	private String dbname = "jobmatching";
	private String user = "root";
	private String pass = "thispass";	
	
	public ConnectionSQL(){
		dataSource = new MysqlDataSource();
		dataSource.setServerName(servername);
		dataSource.setDatabaseName(dbname);
		dataSource.setUser(user);
		dataSource.setPassword(pass);
		
		try {
			Class.forName(driver).newInstance();
			dbCon= DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Driver MySQL not load");
		}
	}
	
	public void introduceRatings(){
		File file = new File("output/mahout/ratings.csv");
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			while((linea=br.readLine())!=null){
				String[] cadena = linea.split(",");
				Long iduser = Long.parseLong(cadena[0]);
				Long idoffer = Long.parseLong(cadena[1]);
				float value = Float.parseFloat(cadena[2]);
				
				String selectStatement = "INSERT INTO ratings (id_user, id_offer, value) VALUES (?,?,?)";
				PreparedStatement prepStmt = (PreparedStatement) dbCon.prepareStatement(selectStatement);
			    prepStmt.setLong(1, iduser);
			    prepStmt.setLong(2, idoffer);
			    prepStmt.setFloat(3, value);
			    prepStmt.executeUpdate();

			}
			br.close();
			fr.close();
			System.out.println("Ratings introducidos en la base de datos");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
