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
        	String req = ("select * from Membre where bloque=False") ;
        	PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(req);
        	res =  (ResultSet) pstmt.executeQuery();
        	
        	// iterate through the java resultSet
            while (res.next())
            {
            	System.out.println("Id : " + res.getString("idM")) ;
            	System.out.println("Login : " + res.getString("login")) ;
            	System.out.println("Mot de passe : " + res.getString("mdp")) ;
            	System.out.println("Email :" + res.getString("email")) ;
            	System.out.println("Date d'inscription : " + res.getDate("dateInscription")) ;
            	System.out.println("Bloque : " + res.getBoolean("bloque")) ;
            }
              
           
        		
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
