package com.awa.awajaba;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;


public class AwajabaApp {
	public static void main(String[] args) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        	System.out.println ("Erreur lors du chargement " + e.getMessage()) ;
        }
        String url = "jdbc:mysql://localhost:3306/awajaba" ;
        Connection connexion = null ;
        Statement stmt = null ;
        ResultSet res = null ;
        try {
        	connexion = (Connection) DriverManager.getConnection( url , "developpeur" , "azerty") ; 
        	stmt = (Statement) connexion.createStatement();
        	String req = "INSERT INTO Specialite (idS , libelle ) VALUES (? , ?)" ;
        	PreparedStatement pstmt =  (PreparedStatement) connexion.prepareStatement(req);
        	pstmt.setInt(1 , 6) ;
        	pstmt.setString(2 , "Chinoise");
        	int rowsInserted = pstmt.executeUpdate();
        	
        	System.out.println ("A new Specialité was inserted successfully!");
        		
        	}
       
        catch (SQLException e) {
        }
        finally {
        	if (res != null){
        		try {
        			res.close();
        		}
        		catch (SQLException ignore ) {
        			
        		}
        	}
        	if (stmt != null ){
        		stmt.close();
        	}
        	if (connexion != null ){
        		connexion.close();
        	}
        }
    }

}
