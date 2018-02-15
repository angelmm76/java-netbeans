package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class manageDB {
    private String dbname;
    private Connection conn;
    private ResultSet rs;
    private Statement statem;
    
    public manageDB(String dbna, String IP, String usuario, String pass){
        this.dbname = dbna;
        // Abrir conexión mysql de una base de datos con user y password
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(
                    //"jdbc:mysql://localhost:3306/" + dbname, usuario, pass);
                    "jdbc:mysql://" + IP + ":3306/" + dbname, usuario, pass);
        }
        catch(ClassNotFoundException cnfe){
            System.out.println("Class exception");
            cnfe.printStackTrace();
        }
        catch(SQLException sqle){
            System.out.println("Closing exception");
            sqle.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    
     public void readTable(String tablename){
        // Crear statement con su query
        String sqlquery = "SELECT * FROM " + tablename;
//        String prstquery = "SELECT * FROM " + tablename + 
//                " WHERE Nombre_equipo=?";
        String prstquery = "SELECT * FROM " + tablename + 
            " WHERE Puntos_por_partido >= ? AND Rebotes_por_partido >= ?";
        try {
            // Con prepared statement
//            prepStatem = conn.prepareStatement(prstquery);
//            //prepStatement.setString(1, "Magic");
//            prepStatem.setInt(1, 20);
//            prepStatem.setInt(2, 10);
//            rs = prepStatem.executeQuery();
            // Con statement
            statem = conn.createStatement();
            rs = statem.executeQuery(sqlquery);
            //rs = statem.getResultSet(); // Resultado de la consulta        
        } 
        catch (SQLException ex) {
            System.out.println("Statement exception");
            ex.printStackTrace();
        }
        // Leer los registros del result set
        //listarResultSet(rs);
     }
}
