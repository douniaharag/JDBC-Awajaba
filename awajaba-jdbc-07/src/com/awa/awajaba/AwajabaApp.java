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
        	String sql = "DELETE FROM Specialite WHERE idS=?";
        	PreparedStatement pstmt = (PreparedStatement) connexion.prepareStatement(sql);
        	pstmt.setInt(1, 6);
        	 
        	int rowsDeleted = pstmt.executeUpdate();
        	    System.out.println("The Specialite was deleted successfully!");
        		
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
